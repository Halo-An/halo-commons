package com.halo.lock.aspect;

import com.halo.lock.annotation.WriteLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class WriteLockAspect {

    private final String DEFAULT_KEY = "REDISSON_READ_WRITE_LOCK_KEY";

    @Resource
    RedissonClient redissonClient;

    @Pointcut("@annotation(com.halo.lock.annotation.WriteLock)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        //获取切点方法对象
        final Method method = ((MethodSignature) point.getSignature()).getMethod();
        //获取方法形参数组
        final Parameter[] parameters = method.getParameters();
        //获取方法实参数组
        final Object[] args = point.getArgs();

        //获取Lock注解及注解参数
        final WriteLock lock = method.getAnnotation(WriteLock.class);
        final String[] spels = lock.spels();
        final long waiteTime = lock.waiteTime();

        //装载SpEL表达式上下文
        final StandardEvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < parameters.length; i++) {
            context.setVariable(parameters[i].getName(), args[i]);
        }

        //从上下文中获取指定的参数值，以分号拼接
        String selectedParams = "";
        final ExpressionParser parser = new SpelExpressionParser();
        for (int i = 0; i < spels.length; i++) {
            selectedParams += parser.parseExpression(spels[i]).getValue(context, String.class);
            if (i != spels.length - 1) {
                selectedParams += ":";
            }
        }

        //以类名+方法名+参数值作为锁的key
        String redisKey = "";
        if (!selectedParams.isEmpty()) {
            redisKey += ":" + selectedParams;
        }else {
            redisKey = DEFAULT_KEY;
        }

        //获取锁对象
        RReadWriteLock rReadWriteLock = redissonClient.getReadWriteLock(redisKey);
        RLock writeLock = rReadWriteLock.writeLock();

        //尝试加锁，超时时间为waiteTime
        boolean b = writeLock.tryLock(waiteTime, TimeUnit.SECONDS);

        //加锁成功，执行切点方法并在方法执行完后释放锁，否则抛出异常
        if (b) {
            try {
                Object obj = point.proceed();
                return obj;
            } finally {
                writeLock.unlock();
            }
        }else {
            throw new RuntimeException("try write lock failed!");
        }
    }
}
