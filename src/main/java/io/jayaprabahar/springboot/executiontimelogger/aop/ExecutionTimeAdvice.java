package io.jayaprabahar.springboot.executiontimelogger.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

/**
 * <p> Project : execution-time-logger </p>
 * <p> Title : ExecutionTimeAdvice.java </p>
 * <p> Description: AOP Advice to log the ExecutionTime per method call </p>
 * <p> Created: Jan 8, 2022</p>
 *
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 * @version 1.0.0
 */

@Aspect
@Component
@Slf4j
@ConditionalOnExpression("${aspect.enabled:true}")
public class ExecutionTimeAdvice {

    private static final String LOG_STRING = "ExecutionTime for {} -> {} is {} ms";

    @Around("@annotation(com.cma.shipping.common.aop.LogExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        log.info(LOG_STRING, point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), (System.currentTimeMillis() - startTime));
        return object;
    }

    @Around("@annotation(com.cma.shipping.common.aop.LogExecutionTimeDebug)")
    public Object debugExecutionTime(ProceedingJoinPoint point) throws Throwable {
        if (!log.isDebugEnabled()) {
            long startTime = System.currentTimeMillis();
            Object object = point.proceed();
            log.debug(LOG_STRING, point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), (System.currentTimeMillis() - startTime));
            return object;
        } else {
            return point.proceed();
        }
    }

    @Around("@annotation(com.cma.shipping.common.aop.LogExecutionTimeExceptionally)")
    public Object executionTimeExceptionally(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object;
        try {
            object = point.proceed();
        } finally {
            log.info(LOG_STRING, point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), (System.currentTimeMillis() - startTime));
        }
        return object;
    }


    @Around("@annotation(com.cma.shipping.common.aop.LogExecutionTimeDebugExceptionally)")
    public Object debugExecutionTimeExceptionally(ProceedingJoinPoint point) throws Throwable {
        if (!log.isDebugEnabled()) {
            long startTime = System.currentTimeMillis();
            Object object;
            try {
                object = point.proceed();
            } finally {
                log.debug(LOG_STRING, point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), (System.currentTimeMillis() - startTime));
            }
            return object;
        } else {
            return point.proceed();
        }
    }

}
