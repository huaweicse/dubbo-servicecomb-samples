package com.huaweicloud.it.config;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Struts2Configuration {
  @Bean
  public FilterRegistrationBean<Filter> filterRegistration() {
    FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
    registration.setFilter(new StrutsPrepareAndExecuteFilter());
    registration.addUrlPatterns("*.action");
    registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
    registration.setName("StrutsPrepareAndExecuteFilter");
    return registration;
  }

  @Bean
  @LoadBalanced
  @ConditionalOnProperty(value = "backend.enableDiscovery", matchIfMissing = true, havingValue = "true")
  public RestTemplate restTemplateLoadBalanced() {
    return new RestTemplate();
  }

  @Bean
  @ConditionalOnProperty(value = "backend.enableDiscovery", matchIfMissing = false, havingValue = "false")
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
