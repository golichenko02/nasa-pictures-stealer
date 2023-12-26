package com.bobocode.mapper;

import com.bobocode.model.dto.CameraDto;
import com.bobocode.model.entity.Camera;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CameraMapper {

  Camera cameraDtoToEntity(CameraDto cameraDto);
}
