package com.halo.lock.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 可重入锁
 *
 * 进入该注解的方法之前会尝试加锁waiteTime秒，未获取到会抛出异常，获取到则持有该锁并执行方法体；
 * 过程中通过watch dog机制自动对锁有效期进行延时，从而避免因方法执行过久导致锁超时失效；
 * 方法执行完成后自动释放锁。
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Lock {

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
