package com.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author GaoPeng
 * @Date 2022/01/10/10:06
 * @Version 1.0
 */
@Service
public class PaymentService {
    /**
     * @Description: 正常返回，OK
     * @Param: id
     * @return: java.lang.String
     * @Author: GaoPeng
     * @Date: 2022/01/10/10:06
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * @Description: 异常常返回，false
     * @Param: id
     * @return: java.lang.String
     * @Author: GaoPeng
     * @Date: 2022/01/10/10:06
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id:" + id + "\t" + "┭┮﹏┭┮呜呜~" + "耗时(秒)" + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "系统繁忙，稍后重试" + "┭┮﹏┭┮呜呜~";
    }
}
