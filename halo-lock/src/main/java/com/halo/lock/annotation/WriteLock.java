package com.halo.lock.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 写锁
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WriteLock {

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
