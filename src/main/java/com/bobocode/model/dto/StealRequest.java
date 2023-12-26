package com.bobocode.model.dto;


import jakarta.validation.constraints.PositiveOrZero;

public record StealRequest(@PositiveOrZero Long sol) {

}
