package com.huaweicloud.it.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.huaweicloud.it.service.HelloService;
import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
  public static final long serialVersionUID = 1L;

  @Autowired
  private HelloService helloService;

  private String model;

  @Override
  public String execute() throws Exception {
    model = helloService.sayHello("struts example");
    return SUCCESS;
  }

  public String getModel() {
    return model;
  }
}