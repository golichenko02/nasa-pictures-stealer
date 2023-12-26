package com.bobocode.mapper;

import com.bobocode.model.dto.PictureDto;
import com.bobocode.model.entity.Picture;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)

public interface PictureMapper {


  @Mapping(ignore = true, target = "camera")
  Picture pictureDtoToEntity(PictureDto pictureDto);

}
