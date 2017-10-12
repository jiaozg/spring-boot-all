package com.example.demo.dynamicproxy;

/**
 * 代理和实际对象一般有相同的接口，在这个例子中，共同的接口是IService，实际对象是RealService，代理是TraceProxy。
 * TraceProxy内部有一个IService的成员变量，指向实际对象，在构造方法中被初始化，对于方法sayHello的调用，它转发给了实际对象
 */
public class SimpleStaticProxyDemo {

    static interface IService {
        public void sayHello();
    }

    static class RealService implements IService {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class TraceProxy implements IService {
        private IService realService;

        public TraceProxy(IService realService) {
            this.realService = realService;
        }

        @Override
        public void sayHello() {
            System.out.println("entering sayHello");
            this.realService.sayHello();
            System.out.println("leaving sayHello");
        }
    }

    public static void main(String[] args) {
        IService realService = new RealService();
        IService proxyService = new TraceProxy(realService);
        proxyService.sayHello();
    }
}