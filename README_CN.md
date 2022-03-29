# Dubbo ServiceComb 代码示例 [English](README.md) 

这个项目包含Dubbo ServiceComb使用的例子，详细内容请查看每个子项目的说明。


## 前提条件

运行这些例子之前，需要先准备CSE运行环境，有两种方式可供选择：

* 通过下载安装本地简化版 CSE 搭建本地开发环境，下载链接： [CSE 1.0](https://support.huaweicloud.com/devg-servicestage/ss-devg-0034.html) ， [CSE 2.0](https://support.huaweicloud.com/devg-cse/cse_devg_0036.html)  。
* 使用[华为云微服务引擎 CSE ](https://support.huaweicloud.com/qs-cse/cse_qs_0002.html) 

更多信息可以参考[开发指南](https://support.huaweicloud.com/devg-cse/cse_devg_0006.html) 

CSE运行环境准备好以后，编辑每个微服务的 `application.yml` 或者 `dubbo.properties` 文件，配置正确的 CSE  服务信息，比如配置中心、注册中心的地址。

例子默认使用微服务引擎1.0版本，配置中心的类型为 config-center，如果使用微服务引擎2.0， 配置中心类型需要修改为 kie：

```
dubbo.servicecomb.config.type: kie
dubbo.servicecomb.config.address: http://127.0.0.1:30110
```

