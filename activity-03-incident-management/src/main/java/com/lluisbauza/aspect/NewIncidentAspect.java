package com.lluisbauza.aspect;

import com.lluisbauza.factory.IncidentFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class NewIncidentAspect {

    private Logger logger = Logger.getLogger(IncidentFactory.class.getName());

    @Around("@annotation(com.lluisbauza.annotation.NewIncident)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("Incident will be created.");

        Object result = joinPoint.proceed();

        logger.info("Incident created.");

        return result;
    }

}
