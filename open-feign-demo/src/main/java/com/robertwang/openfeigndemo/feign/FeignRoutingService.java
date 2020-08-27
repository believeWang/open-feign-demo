package com.robertwang.openfeigndemo.feign;

import com.robertwang.openfeigndemo.config.FeignConfig;
import com.robertwang.openfeigndemo.request.DemoRequest;
import com.robertwang.openfeigndemo.response.DemoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "TestService", url = "127.0.0.1:8081", configuration = FeignConfig.class)
public interface FeignRoutingService {

  @GetMapping(path = "/query/{test}")
  ResponseEntity<String> doGet(@PathVariable String test) ;

  @PostMapping(path = "/query")
  ResponseEntity<DemoResponse> doPost(@RequestBody DemoRequest request) ;

}
