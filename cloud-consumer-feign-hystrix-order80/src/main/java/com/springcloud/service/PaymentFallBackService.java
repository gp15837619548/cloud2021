package com.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author GaoPeng
 * @Date 2022/01/13/9:41
 * @Version 1.0
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallBackService-----paymentInfo_OK o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallBackService-----paymentInfo_TimeOut o(╥﹏╥)o";
    }
}
