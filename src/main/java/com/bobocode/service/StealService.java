package com.bobocode.service;

import com.bobocode.mapper.CameraMapper;
import com.bobocode.mapper.PictureMapper;
import com.bobocode.model.dto.PictureDto;
import com.bobocode.model.entity.Camera;
import com.bobocode.model.entity.Picture;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StealService {

  private final NasaClient nasaClient;
  private final CameraService cameraService;
  private final PictureMapper pictureMapper;
  private final CameraMapper cameraMapper;

  @Cacheable("steal-picture")
  public void stealPicturesBySol(Long sol) {
    nasaClient.findPicturesBySol(sol).stream()
        .collect(Collectors.groupingBy(PictureDto::camera))
        .forEach((cameraDto, value) -> {
          List<Picture> pictures = value.stream()
              .map(pictureMapper::pictureDtoToEntity)
              .toList();
          if (!cameraService.existsByNasaId(cameraDto.nasaId())) {
            log.debug("Not found camera by nasa id: {}", cameraDto.nasaId());
            Camera cameraToSave = cameraMapper.cameraDtoToEntity(cameraDto);
            pictures.forEach(cameraToSave::addPicture);
            Camera savedCamera = cameraService.createCamera(cameraToSave);
            log.debug("Created new camera: [{}]", savedCamera);
          } else {
            cameraService.createPicturesByCameraNasaId(cameraDto.nasaId(), pictures);
          }
        });
  }

}
