package com.huaweicloud.it.price;

import java.util.concurrent.CompletableFuture;

public interface PriceServiceRest {
  String sayHello(String name);

  CompletableFuture<String> sayHelloAsync(String name);
}
