package com.example.demo.finished;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Date;

@Aspect
@Component
public class MyAspect {

//    @Before("execution(* com.example.demo.finished.HpPrinter.*(..))")
//    public void before(){
//        System.out.println("I' m before");
//    }
//
//    @After("execution(* com.example.demo.finished.HpPrinter.*(..))")
//    public void after(){
//        System.out.println("I' m after");
//    }

    @Around("execution(* com.example.demo.finished.HpPrinter.*(..))")
    public Object around (ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("I' m around before");
//
//        // 執行切入點的方法
//        Object obj = pjp.proceed();
//
//        System.out.println("I' m around after");

        Date start = new Date();

        Object obj = pjp.proceed();

        Date end = new Date();

        long time = end.getTime() - start.getTime();
        System.out.println("總共執行了: " + time + "ms");

        return obj;
    }

}
