package com.bobocode.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PictureDto(@JsonProperty("id") Long nasaId, @JsonProperty("img_src") String imgSrc, CameraDto camera) {

}
