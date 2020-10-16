# 示例介绍

一个简单的例子，演示服务发现、动态配置、服务治理等功能。`PriceApplication` 提供了两个接口 `PriceService` 和 `PingService`。 
`PriceService` 传参如果为 `timeout`， 后台会 sleep 3 秒后返回， 用于模拟超时的情况。 

例子同时演示了使用 dubbo rest 实现 dubbo 应用平滑演进到spring cloud。 

* price-provider: 使用 dubbo 协议开发的后台
* order-consumer: 使用 dubbo REST 协议开发的后台， 这个服务的 REST 接口会调用  price-provider 的接口。
* portal-consumer: 使用 spring cloud 开发的 REST 服务， 这个服务会调用 order-consumer 的 REST 接口。 

# 如何使用

1. 下载[本地微服务引擎](https://support.huaweicloud.com/productdesc-servicestage/cse_productdesc_0012.html), 解压后运行
  `start.bat` 启动。 工具会安装注册中心、配置中心，以及控制台。 安装完毕后， 通过 `http://localhost:30106/` 可以访问控制台。
  
2. 运行 `PriceApplication`

3. 运行 `OrderApplication`。 

4. 运行 `PortalApplication`。 运行成功后， console 会有日志输出，输出调用 `PriceApplication` 接口的结果。

5. 通过控制台，可以看到 `PriceApplication` 、`OrderApplication`、`PortalApplication`三个服务的注册信息和实例信息。
