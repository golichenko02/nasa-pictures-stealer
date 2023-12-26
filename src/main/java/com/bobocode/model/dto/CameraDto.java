package com.bobocode.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CameraDto(@JsonProperty("id") Long nasaId, String name) {

}
