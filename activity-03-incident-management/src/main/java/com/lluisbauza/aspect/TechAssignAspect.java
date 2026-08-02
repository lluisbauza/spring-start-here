package com.lluisbauza.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TechAssignAspect {

    @Before("@annotation(com.lluisbauza.annotation.TechAssign)")
    public void log() throws Throwable {
        System.out.println("LOG: TechAssignAspect before execution.");
    }

}
