package com.bobocode.service;

import com.bobocode.model.entity.Camera;
import com.bobocode.model.entity.Picture;
import com.bobocode.repository.CameraRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CameraService {

  private final CameraRepository cameraRepository;

  @Transactional(readOnly = true)
  public boolean existsByNasaId(Long nasaId) {
    return cameraRepository.existsByNasaId(nasaId);
  }

  @Transactional
  public void createPicturesByCameraNasaId(Long nasaId, List<Picture> pictures) {
    Camera camera = cameraRepository.findByNasaId(nasaId).orElseThrow(
        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
            "Not found camera by nasa id: %d".formatted(nasaId)));
    pictures.forEach(camera::addPicture);
    cameraRepository.flush();
  }

  @Transactional
  public Camera createCamera(Camera camera) {
    return cameraRepository.save(camera);
  }

}
