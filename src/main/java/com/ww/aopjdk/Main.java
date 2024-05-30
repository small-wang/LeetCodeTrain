package com.ww.aopjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @since 2024/5/30 9:46
 */
public class Main {

    public static void main(String[] args) {
        HelloServiceTarget target = new HelloServiceTarget();
        HelloService proxy = (HelloService) createProxy(target);

        proxy.listen("Main");
        proxy.say();
    }

    private static Object createProxy(Object target) {
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Proxy start...");
                Object result = method.invoke(target, args);
                System.out.println("Proxy stop...");
                return result;
            }
        });

        return proxy;
    }
}
