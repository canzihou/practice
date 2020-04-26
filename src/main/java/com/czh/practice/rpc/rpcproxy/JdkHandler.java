package com.czh.practice.rpc.rpcproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkHandler implements InvocationHandler {

    final Object delegate;

    JdkHandler(Object delegate) {
        this.delegate = delegate;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 添加代理逻辑（实际项目中会更加复杂）
        if (method.getName().equals("sell")) {
            System.out.println("");
        }

        return null;
    }

    public static BookApi createJdkDynamicProxy(final BookApi delegate) {
        BookApi jdkProxy = (BookApi) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{BookApi.class}, new JdkHandler(delegate));

        return jdkProxy;
    }
}
