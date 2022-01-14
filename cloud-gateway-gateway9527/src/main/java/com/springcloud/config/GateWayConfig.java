package com.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author GaoPeng
 * @Date 2022/01/13/16:47
 * @Version 1.0
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route_config", r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();
    }
}
