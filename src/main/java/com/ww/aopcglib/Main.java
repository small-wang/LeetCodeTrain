package com.ww.aopcglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @since 2024/5/30 10:06
 */
public class Main {

    public static void main(String[] args) {
        HelloServiceTarget target = new HelloServiceTarget();
        HelloService proxy = (HelloService) createProxy(target);

        proxy.listen("Main");
        proxy.say();
    }

    private static Object createProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("Enhancer start...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("Enhancer stop...");
                return result;
            }
        });

        return enhancer.create();
    }

    public boolean checkSuperClass(Class classType) {
        return this.getClass().isAssignableFrom(classType);
    }
}
