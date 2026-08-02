package com.lluisbauza.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class NewIncidentAspect {

    private final Logger logger = Logger.getLogger(NewIncidentAspect.class.getName());

    @Around("@annotation(com.lluisbauza.annotation.NewIncident)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime();

        logger.info("Incident will be created.");

        Object result = joinPoint.proceed();

        long endTime = System.nanoTime();

        long totalTime = endTime - startTime;

        logger.info("Incident created. Time taken: " + totalTime + " ns");

        return result;
    }

}
