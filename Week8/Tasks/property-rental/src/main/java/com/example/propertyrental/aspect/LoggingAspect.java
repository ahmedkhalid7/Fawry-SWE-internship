package com.example.propertyrental.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.propertyrental.ReservationManager.ReservationService.addProperty(..))")
    public void beforeAddProperty(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Logging before Method: {} - Args: {}", methodName, args);
    }

    @AfterReturning("execution(* com.example.propertyrental.ReservationManager.ReservationService.reserveProperty(..))")
    public void afterReserveProperty(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Logging After Returning from method: {}", methodName);
    }

    @AfterReturning("execution(* com.example.propertyrental.ReservationManager.ReservationService.cancelReservation(..))")
    public void afterCancelReservation(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Logging After Returning from method: {}", methodName);
    }
}