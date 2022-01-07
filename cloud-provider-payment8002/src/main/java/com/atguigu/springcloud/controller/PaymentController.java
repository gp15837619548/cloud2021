package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author GaoPeng
 * @Date 2021/12/22/9:06
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int row = paymentService.create(payment);
        log.info("******插入结果：" + row);
        if (row > 0) {
            return new CommonResult<Integer>(200, "操作成功,serverPort:" + serverPort, row);
        } else {
            return new CommonResult<Integer>(500, "操作失败,serverPort:" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******插入结果：" + payment);
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult<Payment>(500, "没有对应的记录集,查询ID", null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
