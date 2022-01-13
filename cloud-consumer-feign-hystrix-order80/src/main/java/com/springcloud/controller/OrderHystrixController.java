package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author GaoPeng
 * @Date 2022/01/10/14:01
 * @Version 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfoGlobalFallBackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("******result:" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeOut/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("******result:" + result);
        return result;
    }

    public String paymentInfoTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "80端口,调用方系统繁忙，请稍后重试";
    }


    public String paymentInfoGlobalFallBackMethod(@PathVariable("id") Integer id) {
        return "全局处理方法,调用方系统繁忙，请稍后重试";
    }

}
