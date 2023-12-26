package com.bobocode.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PictureDto(Long id, @JsonProperty("img_src") String imgSrc, CameraDto camera) {

}
