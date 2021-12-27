package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author GaoPeng
 * @date 2021/12/22/9:02
 * @version 1.0
 */
public interface PaymentService {
    /***
     * @description: 插入方法
     * @param: [payment] 实体类对象
     * @return: int
     * @author: GaoPeng
     * @date: 2021/12/22
     */
    public int create(Payment payment);

    /***
     * @description: 根据id查询
     * @param: [id] 序列化id
     * @return: com.atguigu.springcloud.entities.Payment
     * @author: GaoPeng
     * @date: 2021/12/22
     */
    public Payment getPaymentById(@Param("id") Long id);
}
