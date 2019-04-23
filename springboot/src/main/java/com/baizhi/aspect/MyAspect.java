package com.baizhi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class MyAspect {
//    @Before("within(com.baizhi.service.*ServiceImpl)")
//    public void before(JoinPoint joinPoint){
//        System.out.println("--------进入前置通知--------");
//        System.out.println(joinPoint.getTarget());//目标对象
//        System.out.println(joinPoint.getSignature());//方法签名
//        System.out.println(joinPoint.getArgs());//方法参数
//        System.out.println("--------退出前置通知-------");
//    }
//    @After("within(com.baizhi.service.*ServiceImpl)")
//    public void after(JoinPoint joinPoint){
//        System.out.println("--------进入后置通知--------");
//        System.out.println(joinPoint.getTarget());//目标对象
//        System.out.println(joinPoint.getSignature());//方法签名
//        System.out.println(joinPoint.getArgs());//方法参数
//        System.out.println("--------退出后置通知-------");
//    }
@Around("execution(* com.baizhi.service.*.*(..))")
public Object before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
   System.out.println("进入环绕通知");
//    proceedingJoinPoint.getTarget();//目标对象
//    proceedingJoinPoint.getSignature();//方法签名
//    proceedingJoinPoint.getArgs();//方法参数
    Object proceed = proceedingJoinPoint.proceed();//放行执行目标方法
    System.out.println("目标方法执行之后回到环绕通知");
    return proceed;//返回目标方法返回值
}
}
