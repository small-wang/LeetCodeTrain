package com.ww.aopjdk;

/**
 * @since 2024/5/30 9:40
 */
public class HelloServiceTarget implements HelloService {

    @Override
    public void listen(String msg) {
        System.out.println("listen: " + msg);
    }

    @Override
    public String say() {
        System.out.println("say: hello");
        return "hello";
    }
}
