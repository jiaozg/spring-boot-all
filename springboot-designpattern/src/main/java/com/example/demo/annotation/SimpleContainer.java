package com.example.demo.annotation;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jiaozhiguang on 2017/9/28.
 *
 * 应用注解 - DI容器
 定义@SimpleInject
 我们再来看一个简单的DI容器的例子
 */
public class SimpleContainer {

    private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

//    public static <T> T getInstance(Class<T> cls) {
//        try {
//            T obj = cls.newInstance();
//            Field[] fields = cls.getDeclaredFields();
//            for (Field f : fields) {
//                if (f.isAnnotationPresent(SimpleInject.class)) {
//                    if (!f.isAccessible()) {
//                        f.setAccessible(true);
//                    }
//                    Class<?> fieldCls = f.getType();
//                    f.set(obj, getInstance(fieldCls));
//                }
//            }
//            return obj;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static <T> T getInstance(Class<T> cls) {
        try {
            boolean singleton = cls.isAnnotationPresent(SimpleSingleton.class);
            if (!singleton) {
                return createInstance(cls);
            }
            Object obj = instances.get(cls);
            if (obj != null) {
                return (T) obj;
            }
            synchronized (cls) {
                obj = instances.get(cls);
                if (obj == null) {
                    obj = createInstance(cls);
                    instances.put(cls, obj);
                }
            }
            return (T) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T createInstance(Class<T> cls) throws Exception {
        T obj = cls.newInstance();
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(SimpleInject.class)) {
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                Class<?> fieldCls = f.getType();
                f.set(obj, getInstance(fieldCls));
            }
        }
        return obj;
    }

    public static void main(String[] args) {
        ServiceA a = SimpleContainer.getInstance(ServiceA.class);
        a.callB();

    }
}
