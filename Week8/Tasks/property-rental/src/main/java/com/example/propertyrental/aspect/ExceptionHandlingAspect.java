package com.example.propertyrental.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {
    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.example.propertyrental.ReservationManager.ReservationService.reserveProperty(..)) || " +
            "execution(* com.example.propertyrental.ReservationManager.ReservationService.cancelReservation(..))",
            throwing = "exception")
    public void handleException(Exception exception) {
        logger.error("Exception occurred: {}", exception.getMessage());
    }
}