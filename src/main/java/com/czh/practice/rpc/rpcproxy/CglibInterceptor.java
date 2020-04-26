package com.czh.practice.rpc.rpcproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {

    final Object delegate;

    CglibInterceptor(Object delegate) {
        this.delegate = delegate;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 添加代理逻辑（实际项目中会更加复杂）
        if (method.getName().equals("sell")) {
            System.out.println("");
        }

        return null;
    }

    public static BookApi createCglibDynamicProxy(final BookApi delegate) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibInterceptor(delegate));
        enhancer.setInterfaces(new Class[]{BookApi.class});
        BookApi cglibProxy = (BookApi) enhancer.create();
        return cglibProxy;
    }
}
