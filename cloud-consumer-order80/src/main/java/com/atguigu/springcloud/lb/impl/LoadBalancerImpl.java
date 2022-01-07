package com.atguigu.springcloud.lb.impl;

import com.atguigu.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author GaoPeng
 * @Date 2022/01/06/18:21
 * @Version 1.0
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final int MAX_VALUE = 0x7fffffff;

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*****next:" + next);
        return next;
    }

    public final int getAndIncrement(int moound) {
        int current;
        int next;
        for (; ; ) {
            current = this.atomicInteger.get();
            next = current >= MAX_VALUE ? 0 : current + 1;
            System.out.println("*****next:" + next);
            if (this.atomicInteger.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
