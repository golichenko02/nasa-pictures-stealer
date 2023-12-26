package com.bobocode.service;

import com.bobocode.config.NasaClientProperties;
import com.bobocode.model.dto.PictureDto;
import com.bobocode.model.dto.PicturesResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@RequiredArgsConstructor
public class NasaClient {

  private final RestTemplate restTemplate;
  private final NasaClientProperties nasaClientProperties;

  public List<PictureDto> findPicturesBySol(Long sol) {
    log.debug("Request pictures from Nasa API by sol: {}", sol);
    URI uri = UriComponentsBuilder.fromHttpUrl(nasaClientProperties.getUrl())
        .queryParam("api_key", nasaClientProperties.getApiKey())
        .queryParam("sol", sol)
        .build()
        .toUri();
    return Optional.ofNullable(restTemplate.getForObject(uri, PicturesResponse.class))
        .map(PicturesResponse::photos)
        .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,
            "No pictures found by sol %s".formatted(sol)));
  }
}
