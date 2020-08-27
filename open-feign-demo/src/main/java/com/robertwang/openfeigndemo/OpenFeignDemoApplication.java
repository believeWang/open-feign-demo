package com.robertwang.openfeigndemo;

import com.robertwang.openfeigndemo.feign.FeignRoutingService;
import com.robertwang.openfeigndemo.request.DemoRequest;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class OpenFeignDemoApplication {

  @Autowired private FeignRoutingService feignRoutingService;

  public static void main(String[] args) {
    SpringApplication.run(OpenFeignDemoApplication.class, args);
  }

  @Bean
  public void showFeign() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    log.info("doGet1");
    IntStream.range(0, 100)
        .forEach(
            (c) -> {
              try {

                feignRoutingService.doGet("doGet");
              } catch (Exception e) {
                log.info("error :", e);
              }
            });
    log.info("doGet2 :{}", stopWatch.getTotalTimeSeconds());
    stopWatch.stop();
    stopWatch.start();
    DemoRequest request = new DemoRequest();

    request.setDemoName("doPost");

    try {
      feignRoutingService.doPost(request);
    } catch (Exception e) {
      log.info("error :", e);
    }

    log.info("dopost:{}", stopWatch.getTotalTimeSeconds());
    stopWatch.stop();
  }
}
