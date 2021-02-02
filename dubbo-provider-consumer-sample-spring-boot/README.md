# 示例介绍

一个简单的例子，演示服务发现、动态配置、服务治理等功能。`PriceApplication` 提供了两个接口 `PriceService` 和 `PingService`。 
`PriceService` 传参如果为 `timeout`， 后台会 sleep 3 秒后返回， 用于模拟超时的情况。 

例子同时演示了使用 dubbo rest 实现 dubbo 应用平滑演进到spring cloud。 

* price-provider: 使用 dubbo 协议开发的后台
* order-consumer: 使用 dubbo REST 协议开发的后台， 这个服务的 REST 接口会调用  price-provider 的接口。
* portal-consumer: 使用 spring cloud 开发的 REST 服务， 这个服务会调用 order-consumer 的 REST 接口。 
* spring-cloud-gateway: 使用 spring cloud gateway 开发的网关服务，网关服务负责接收外部请求，将
  请求转发给 portal-consumer, order-consumer 等微服务。
* struts-website: 使用 spring cloud + struts 开发的前端应用， 可以采用两种方式和后台服务交互，
  容器内采用服务发现的方式，或者通过域名的方式，在 application.yml 里面通过配置项控制。 

# 如何使用

1. 下载[本地微服务引擎](https://support.huaweicloud.com/productdesc-servicestage/cse_productdesc_0012.html), 解压后运行
  `start.bat` 启动。 工具会安装注册中心、配置中心，以及控制台。 安装完毕后， 通过 `http://localhost:30106/` 可以访问控制台。
  
2. 运行 `PriceApplication`

3. 运行 `OrderApplication`。 

4. 运行 `PortalApplication`。 运行成功后， console 会有日志输出，输出调用 `PriceApplication` 接口的结果。

5. 运行 `SpringCloudGatewayMain`。

6. 运行 `WebsiteApplication`。 这个是一个 war 应用，可以编译打包后，在 tomcat 运行。 直接运行 jsp
  文件无法解析。
  
 
5. 通过控制台，可以看到各个服务的注册信息和实例信息。可以通过 gateway 调用各个接口， 可以访问 struts 应用
  的 hello.action。 例如： http://localhost:9090/structs-website/hello.action

  
