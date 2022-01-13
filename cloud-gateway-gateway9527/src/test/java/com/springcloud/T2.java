package com.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

/**
 * @Author GaoPeng
 * @Date 2022/01/13/17:34
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class T2 {
    @Test
    public void DateNow() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        /*
        * 2022-01-13T17:40:43.665+08:00[Asia/Shanghai]
        * */
    }
}
