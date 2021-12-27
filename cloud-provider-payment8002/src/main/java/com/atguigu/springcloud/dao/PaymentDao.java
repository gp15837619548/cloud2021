package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author GaoPeng
 * @Date 2021/12/22/8:39
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    /***
     *
     * @Description: 插入方法
     * @Param: [payment] 实体类对象
     * @return: int
     * @Author: GaoPeng
     * @Date: 2021/12/22
     */
    public int create(Payment payment);

    /***
     * @Description: 根据id查询
     * @Param: [id] 序列化id
     * @return: com.atguigu.springcloud.entities.Payment
     * @Author: GaoPeng
     * @Date: 2021/12/22
     */
    public Payment getPaymentById(@Param("id") Long id);
}
