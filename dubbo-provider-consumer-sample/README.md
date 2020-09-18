# 示例介绍

一个简单的例子，演示服务发现、动态配置、服务治理等功能。 `PriceApplication` 提供了两个接口 `PriceService` 和 `PingService`。 
`PriceService` 传参如果为 `timeout`， 后台会 sleep 3 秒后返回， 用于模拟超时的情况。 

# 如何使用

1. 下载[本地微服务引擎](https://support.huaweicloud.com/productdesc-servicestage/cse_productdesc_0012.html), 解压后运行
  `start.bat` 启动。 工具会安装注册中心、配置中心，以及控制台。 安装完毕后， 通过 `http://localhost:30106/` 可以访问控制台。
  
2. 运行 `PriceApplication`

3. 运行 `OrderApplication`。 运行成功后， console 会有日志输出，输出调用 `PriceApplication` 接口的结果。

4. 通过控制台，可以看到 `PriceApplication` 和 `OrderApplication` 两个服务的注册信息和实例信息。

5. 通过动态配置进行治理。在控制台创建全局配置：

        ```yaml
        dubbo.servicecomb.governance: {"providerInfos":[{"serviceName":"price-provider","schemaInfos":[{"schemaId":"com.huaweicloud.it.price.PriceService","parameters":{"timeout":5000}}]}]}
        ```
  配置项将请求超时时间设置为 5 秒。 可以观察 `OrderApplication` 的 console 日志输出的变化，不再有请求超时。 全局配置模拟针对 provider 的治理。 
  如果配置项不是全局配置，而是针对 `OrderApplication`，可以达到一样的效果，通过设置配置项生效的范围为具体微服务，可以模拟针对 consumer 的治理。
   
