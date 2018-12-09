### Controller中注解
`@GetMapping`是spring4.3中提供的新注解。这是一个组合注解，等价于`@RequestMapping(method = RequestMethod.GET)`。
同时类似的注解还有`@PostMapping`,`@PutMapping`,`@DeleteMapping`,`@PatchMapping`

### @SpringBootApplication
这是一个组合注解，整合了各种注解，并且开启了SpringBoot程序组件扫描和自动配置的功能。通常使用`@EnableAutoConfiguration`和`@ComponentScan`等
注解，但是springBoot提供了这一注解简化了开发。

### UserApplication配置文件
```yaml
# 程序启动端口，默认就是8080 不配置则使用默认端口。
server:
  port: 8080
# 应用名称，可以作为程序地址栏访问名称，注册eureka服务中心的名字
spring:
  application:
    name: user
# 连接数据库的系列配置
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    username: chencong
    password: 1042738887Cc
    url: jdbc:mysql://118.25.194.100:3308/springCloud-docker?characterEncoding=utf-8&useSSL=false
#  使用JPA,在此打印日志
  jpa:
    show-sql: true
```
这里配置文件使用YAML(Yet Another Markup Language)格式,使用properties配置文件也行。

启动程序后，访问UserController当中的GET接口。得到JSON结果。
```json
{
    "id": 1,
    "username": "account1",
    "name": "张三",
    "age": 20,
    "balance": 100
}
```

### 整合SpringBoot Actuator
该模块增加了很多监控点，使用`http://{ip}:{port}/{endpoint}`来访问这些断点，了解程序的运行情况。

|端点名称|描述|方法类型|
|---|---|---|
|autoconfig|显示自动配置的信息|GET|

配置actuator，访问info仍然是没有任何信息，现在可以在application.yml中配置可应用的一些启动信息。
配置如下：
```json
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

