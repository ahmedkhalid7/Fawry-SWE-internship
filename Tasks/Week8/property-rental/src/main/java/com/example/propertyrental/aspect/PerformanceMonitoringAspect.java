package com.example.propertyrental.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitoringAspect {

    private final Logger logger = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* com.example.propertyrental.ReservationManager.ReservationService.reserveProperty(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        String methodName = joinPoint.getSignature().getName();
        logger.info("Execution time of {} method is {} ms", methodName, executionTime);

        return result;
    }
}