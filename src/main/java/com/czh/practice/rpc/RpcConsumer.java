package com.czh.practice.rpc;

public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService helloService = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < 10; i++) {
            String hello = helloService.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}
