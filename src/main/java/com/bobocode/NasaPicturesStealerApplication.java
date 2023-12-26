package com.bobocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@EnableConfigurationProperties
@EnableCaching
@SpringBootApplication
public class NasaPicturesStealerApplication {

  public static void main(String[] args) {
    SpringApplication.run(NasaPicturesStealerApplication.class, args);
  }

}
