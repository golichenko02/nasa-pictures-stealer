package com.bobocode.controller;

import com.bobocode.model.dto.StealRequest;
import com.bobocode.service.StealService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor
public class StealerController {

  private final StealService stealService;

  @PostMapping("/steal")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void stealPictures(@RequestBody StealRequest stealRequest) {
    stealService.stealPicturesBySol(stealRequest.sol());
  }
}
