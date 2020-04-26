package com.czh.practice.rpc.rpcproxy;

import javassist.*;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.Method;

import static com.czh.practice.rpc.rpcproxy.CglibInterceptor.createCglibDynamicProxy;
import static com.czh.practice.rpc.rpcproxy.JdkHandler.createJdkDynamicProxy;

public class Main {
    public static void main(String[] args) throws Exception {

        BookApi delegate = new BookApiImpl();
        long time = System.currentTimeMillis();
        BookApi jdkProxy = createJdkDynamicProxy(delegate);
        time = System.currentTimeMillis() - time;
        System.out.println("Create JDK Proxy: " + time + " ms");

        time = System.currentTimeMillis();
        BookApi cglibProxy = createCglibDynamicProxy(delegate);
        time = System.currentTimeMillis() - time;
        System.out.println("Create CGLIB Proxy: " + time + " ms");

        time = System.currentTimeMillis();
        BookApi javassistBytecodeProxy = createJavassistBytecodeDynamicProxy();
        time = System.currentTimeMillis() - time;
        System.out.println("Create JavassistBytecode Proxy: " + time + " ms");

        for (int i = 0; i < 10; i++) {
            jdkProxy.sell();//warm
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            jdkProxy.sell();
        }
        System.out.println("JDK Proxy invoke cost " + (System.currentTimeMillis() - start) + " ms");

        for (int i = 0; i < 10; i++) {
            cglibProxy.sell();//warm
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            cglibProxy.sell();
        }
        System.out.println("CGLIB Proxy invoke cost " + (System.currentTimeMillis() - start) + " ms");

        for (int i = 0; i < 10; i++) {
            javassistBytecodeProxy.sell();//warm
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            javassistBytecodeProxy.sell();
        }
        System.out.println("JavassistBytecode Proxy invoke cost " + (System.currentTimeMillis() - start) + " ms");

        Class<?> serviceClass = delegate.getClass();
        String methodName = "sell";
        for (int i = 0; i < 10; i++) {
            cglibProxy.sell();//warm
        }
        // 执行反射调用
        for (int i = 0; i < 10; i++) {//warm
            Method method = serviceClass.getMethod(methodName, new Class[]{});
            method.invoke(delegate, new Object[]{});
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Method method = serviceClass.getMethod(methodName, new Class[]{});
            method.invoke(delegate, new Object[]{});
        }
        System.out.println("反射 invoke cost " + (System.currentTimeMillis() - start) + " ms");

        // 使用 CGLib 执行反射调用
        for (int i = 0; i < 10; i++) {//warm
            FastClass serviceFastClass = FastClass.create(serviceClass);
            FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, new Class[]{});
            serviceFastMethod.invoke(delegate, new Object[]{});
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            FastClass serviceFastClass = FastClass.create(serviceClass);
            FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, new Class[]{});
            serviceFastMethod.invoke(delegate, new Object[]{});
        }
        System.out.println("CGLIB invoke cost " + (System.currentTimeMillis() - start) + " ms");

    }

    public static BookApi createJavassistBytecodeDynamicProxy() throws Exception {
//        ClassPool mPool = new ClassPool(true);
        ClassPool mPool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(BookApi.class);
        mPool.insertClassPath(classPath);
        CtClass mCtc = mPool.makeClass(BookApi.class.getName() + "JavaassistProxy");
        mCtc.addInterface(mPool.get(BookApi.class.getName()));
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        mCtc.addMethod(CtNewMethod.make("public void sell() { System.out.print(\"\") ; }", mCtc));
        Class<?> pc = mCtc.toClass();
        BookApi bytecodeProxy = (BookApi) pc.newInstance();
        return bytecodeProxy;
    }
}
