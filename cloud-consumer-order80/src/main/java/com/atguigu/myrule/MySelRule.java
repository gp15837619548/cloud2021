package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author GaoPeng
 * @Date 2022/01/05/10:30
 * @Version 1.0
 */
@Configuration
public class MySelRule {

    @Bean
    public IRule myRule() {
        //随机
        return new RandomRule();
    }
}
