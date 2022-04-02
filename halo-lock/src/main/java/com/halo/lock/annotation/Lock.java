package com.halo.lock.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 分布式锁，通过@Lock注解标记切点
 * LockAspect中实现加锁逻辑
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Lock {

    /**
     * SpEL表达式数组，用于当作锁名
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
