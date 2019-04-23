package proxy;

import com.baizhi.service.CLazzService;
import com.baizhi.service.ClazzServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestClazzProxy {
    public static void main(String[] args) {
        //生成代理对象
        final CLazzService clazzService = new ClazzServiceImpl();
        //生成动态代理对象  proxy用来生成代理对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();//参数1，当前线程类加载器
        Class[] interfaces = { CLazzService.class } ;//参数2目标对象的接口的类型的数组
        //返回值  生成的代理对象
        //参数3 通过代理对象调用代理中方法时会优先执行回调对象 invoke方法 在invoke方法中调用目标对象的方法执行后还会回到invoke方法继续执行
         CLazzService cLazzServiceProxy= (CLazzService) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
             //参数1: 当前生成代理对象
             //参数2: 当前代理对象调用方法对象
             //参数3: 当前代理对象调用方法传递的参数数组
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    System.out.println("-----开始事务----");
                    //调用真正业务逻辑对象 目标对象
                    Object invoke = method.invoke(clazzService, args);
                    System.out.println("-----提交事务----");

                    return null;
                }catch (Exception e){
                    System.out.println("-----回滚事务----");
                    e.printStackTrace();
                }
                return null;
            }

        });
         //通过动态代理对象调用代理中方法
        cLazzServiceProxy.delete("wangwang");
        System.out.println(cLazzServiceProxy.getClass());



    }
}
