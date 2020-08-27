package com.robertwang.openfeigndemo.config;

import feign.Logger;
import feign.Logger.Level;
import feign.Retryer;
import feign.Retryer.Default;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

  @Bean
  public Retryer retryer() {
    return new Default();
  }
  @Bean
  Logger.Level feignLoggerLevel() {
    return Level.FULL;
  }
}
