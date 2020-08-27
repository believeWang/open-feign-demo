package com.robertwang.openfeigndemo.request;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DemoRequest {

  private String demoName;

  private List<DemoSubRequest> subRequests;


}
