---
title: SpringBoot Actuator介绍
date: 2018-12-9 17:48:48
tags:
  - SpringBoot
categories: 
  - SpringCloud与Docker
---

## 前言

> 该模块增加了很多监控点，使用`http://{ip}:{port}/{endpoint}`来访问这些断点，了解程序的运行情况。这是一个完全暴露自身信息的模块，主要作用就是作为监控和管理的。


## 引入依赖

```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
```
注意这里也需要添加`starter-web`模块。

## 查看日志

启动程序后，通过查看日志，我们很清晰的看到这里的actuator地址只有这三个。分别是`/actuator/health`、`/actuator/info`、`/actuator`

```
2018-12-09 17:54:36.904  INFO 14364 --- [           main] s.b.a.e.w.s.WebMvcEndpointHandlerMapping : Mapped "{[/actuator/health],methods=[GET],produces=[application/vnd.spring-boot.actuator.v2+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.web.servlet.AbstractWebMvcEndpointHandlerMapping$OperationHandler.handle(javax.servlet.http.HttpServletRequest,java.util.Map<java.lang.String, java.lang.String>)
2018-12-09 17:54:36.905  INFO 14364 --- [           main] s.b.a.e.w.s.WebMvcEndpointHandlerMapping : Mapped "{[/actuator/info],methods=[GET],produces=[application/vnd.spring-boot.actuator.v2+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.web.servlet.AbstractWebMvcEndpointHandlerMapping$OperationHandler.handle(javax.servlet.http.HttpServletRequest,java.util.Map<java.lang.String, java.lang.String>)
2018-12-09 17:54:36.906  INFO 14364 --- [           main] s.b.a.e.w.s.WebMvcEndpointHandlerMapping : Mapped "{[/actuator],methods=[GET],produces=[application/vnd.spring-boot.actuator.v2+json || application/json]}" onto protected java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.springframework.boot.actuate.endpoint.web.Link>> org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping.links(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)

```
 如果我们需要查看其他的监控信息，则需要在配置中将其打开；在这里提示，springBoot2.x之后配置方式和之前有所改变。

### /actuator 所有监控地址

我们在地址栏中访问这个地址，详细的看到所有监点。正如上面日志中所提到的只开放了这三个监控点。其他的监控信息，我们配置之后就可以看到。
```
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/actuator",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8080/actuator/health",
            "templated": false
        },
        "info": {
            "href": "http://localhost:8080/actuator/info",
            "templated": false
        }
    }
}
```

### /actuator/health 服务是否启动

```
{
    "status": "UP"
}
```
`Up`表示正常运行，除此之外还有`DOWN`、`OUT_OF_SERVICE` 、`UNKNOWN`等状态。

### /info 

info属性来自定义info端点公开的数据。

## 配置开启所有监控端点
```
management:
  endpoints:
    web:
      exposure:
        include: "*"
```
开启所有监控端点，运行程序，可以在日志当中看到映射mapping地址;同样也可以在程序正常启动后通过访问`http://localhost:8080/actuator`后的json数据中显示所监控的信息。

```
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/actuator",
            "templated": false
        },
        "auditevents": {
            "href": "http://localhost:8080/actuator/auditevents",
            "templated": false
        },
        "beans": {
            "href": "http://localhost:8080/actuator/beans",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8080/actuator/health",
            "templated": false
        },
        "conditions": {
            "href": "http://localhost:8080/actuator/conditions",
            "templated": false
        },
        "configprops": {
            "href": "http://localhost:8080/actuator/configprops",
            "templated": false
        },
        "env": {
            "href": "http://localhost:8080/actuator/env",
            "templated": false
        },
        "env-toMatch": {
            "href": "http://localhost:8080/actuator/env/{toMatch}",
            "templated": true
        },
        "info": {
            "href": "http://localhost:8080/actuator/info",
            "templated": false
        },
        "loggers": {
            "href": "http://localhost:8080/actuator/loggers",
            "templated": false
        },
        "loggers-name": {
            "href": "http://localhost:8080/actuator/loggers/{name}",
            "templated": true
        },
        "heapdump": {
            "href": "http://localhost:8080/actuator/heapdump",
            "templated": false
        },
        "threaddump": {
            "href": "http://localhost:8080/actuator/threaddump",
            "templated": false
        },
        "metrics": {
            "href": "http://localhost:8080/actuator/metrics",
            "templated": false
        },
        "metrics-requiredMetricName": {
            "href": "http://localhost:8080/actuator/metrics/{requiredMetricName}",
            "templated": true
        },
        "scheduledtasks": {
            "href": "http://localhost:8080/actuator/scheduledtasks",
            "templated": false
        },
        "httptrace": {
            "href": "http://localhost:8080/actuator/httptrace",
            "templated": false
        },
        "mappings": {
            "href": "http://localhost:8080/actuator/mappings",
            "templated": false
        }
    }
}
```
+ `management.endpoints.web.exposure.include:` 默认情况只是开启了/health 和 /info端点，想要暴露所有的端点只需要设置成`*`
```
management:
  endpoints:
    web:
      exposure:
        include: "*"
```
+ `management.server.servlet.context-path:` 设置管理端点的上下文路径，默认是"",此时设置了，地址栏访问:`http://localhost:9000/au/actuator`
```
management:
 server:
    servlet:
      context-path: /au
```

+ `management.server.port:` 设置管理服务的端口，默认和应用端口保持一致。
```
management:
  server:
    port: 9000
```
关于这些值配置，在`spring-boot-actuator-autoconfigure-{xxx}.jar`这个jar包中有一个`spring-configuration-metadata.json`包含了

```
management:
  server:
    servlet:
      context-path: "/management"
    port: 8088
  endpoints:
    web:
      exposure:
        include: "*"
      base-path: "/monitor"
  endpoint:
    shutdown:
      enabled: true
info:
  app:
    name: "@project.artifactId@"
    encoding: '@project.build.sourceEncoding@'
    java:
      source: '@java.version@'
      target: '@java.version@'

```
现将配置修改如上，/actuator 在 management.endpoints.web.base-path 的根目录中有一个映射，它提供了到所有暴露端点的链接。现将其修改成了`/monitor`，默认为`/actuator`。`info`如上所说自定义属性系列信息，在此打印服务名称和服务编码和基础环境等信息。

## 联系

[聪聪](https://ccoder.cc/)的独立博客 ，一个喜欢技术，喜欢钻研的95后。如果你看到这篇文章，千里之外，我在等你联系。

- [Blog@ccoder's blog](https://ccoder.cc/)
- [CSDN@ccoder](http://blog.csdn.net/chencong3139)
- [Github@ccoder](https://github.com/chencong-plan)
- [Email@ccoder](mailto:admin@ccoder.top) *or* [Gmail@ccoder](mailto:chencong3139@gmail.com)
