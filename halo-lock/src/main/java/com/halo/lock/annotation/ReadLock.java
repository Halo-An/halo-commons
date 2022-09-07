package com.halo.lock.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 读锁
 *
 * 进入该注解的方法之前会尝试加锁waiteTime秒，未获取到会抛出异常，获取到则持有该锁并执行方法体；
 * 不同的读线程之间不会相互阻塞，即不互斥，但当写线程正在持有同key写锁时，会阻塞其他的读线程直至写线程执行完毕释放写锁
 * 读锁与写锁的spels需要保持一致才能达到读写锁的效果
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadLock {

    /**
     * SpEL表达式数组，用于组成锁名
     * 有多个时会通过 ":" 连接
     * @return
     */
    String[] spels() default {};

    /**
     * 加锁最长等待时间（秒），请求尝试获取锁超过该时间则放弃获取
     * @return
     */
    long waiteTime() default 10L;

}
