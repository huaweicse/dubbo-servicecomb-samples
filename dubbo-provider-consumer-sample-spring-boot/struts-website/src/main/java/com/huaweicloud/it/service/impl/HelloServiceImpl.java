package com.huaweicloud.it.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.huaweicloud.it.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
  @Value("${backend.server}")
  private String server;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public String sayHello(String name) {
    Map<String, String> params = new HashMap<>();
    params.put("name", name);
    System.out.println(server);
    return restTemplate
        .getForObject(server + "/portal-consumer/portal/sayHello?name={name}", String.class, params);
  }
}
