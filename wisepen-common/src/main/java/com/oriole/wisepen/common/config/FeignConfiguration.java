package com.oriole.wisepen.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
// 所有引入 common 的服务，都会自动扫描 "com.oriole.wisepen" 下所有的 @FeignClient
@EnableFeignClients(basePackages = "com.oriole.wisepen")
public class FeignConfiguration {
    // 这里也可以放一些全局的 Feign 配置，比如日志级别、拦截器等
}