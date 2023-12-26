package com.bobocode.mapper;

import com.bobocode.model.dto.PictureDto;
import com.bobocode.model.entity.Picture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PicturesMapper {


   Picture pictureDtoToEntity(PictureDto pictureDto);

}
