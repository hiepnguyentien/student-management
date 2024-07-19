package com.example.student_management.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.student_management.service.implement.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before method: {}, request: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @After("execution(* com.example.student_management.service.implement.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("After method: {}", joinPoint.getSignature().getName());
    }

    @Around("execution(* com.example.student_management.service.implement.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Around before method: {}", joinPoint.getSignature().getName());
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("Exception in method: {}", joinPoint.getSignature().getName(), throwable);
            throw throwable;
        }
        logger.info("Around after method: {}", joinPoint.getSignature().getName());
        return result;
    }

    @AfterReturning(pointcut = "execution(* com.example.student_management.service.implement.*.*(..))", returning = "result")
    public void logAfterReturn(JoinPoint joinPoint, Object result) {
        logger.info("After returning method: {}, returning: {}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.student_management.service.implement.*.*(..))", throwing = "error")
    public void logAfterThrow(JoinPoint joinPoint, Throwable error) {
        logger.error("After throwing method: {}, exception: {}", joinPoint.getSignature().getName(), error.getMessage());
    }
}
