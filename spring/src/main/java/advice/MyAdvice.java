package advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Date;


public class MyAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("进入环绕通知！！！！！！");

        long start=new Date().getTime();
        Object proceed = methodInvocation.proceed();
        for (int i = 0; i < 2111111111; i++) {

        }
        long end= new Date().getTime();
        System.out.println("执行时间为："+(end-start)+"ms");
        System.out.println(proceed);
        return proceed;

    }
}
