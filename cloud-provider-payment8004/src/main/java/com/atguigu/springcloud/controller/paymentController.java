package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author GaoPeng
 * @Date 2021/12/28/10:07
 * @Version 1.0
 */
@RestController
@Slf4j
public class paymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk() {
        return "springcloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}

