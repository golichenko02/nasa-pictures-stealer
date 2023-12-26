package com.bobocode.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties(prefix = "nasa")
@Getter
@Setter
public class NasaClientProperties {

  private String url;
  private String apiKey;
}
