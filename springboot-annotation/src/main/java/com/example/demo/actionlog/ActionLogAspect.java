package com.example.demo.actionlog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by jiaozhiguang on 2017/9/20.
 */
@Aspect
@Component
public class ActionLogAspect {

    @Pointcut("@annotation(com.example.demo.actionlog.ActionLog)")
    public void setJoinPoint(){}


    //环绕通知:可以获取返回值
    @Around(value = "setJoinPoint()")
    public Object aroundMethod(ProceedingJoinPoint jp) {
        Object result = null;
        try {

            System.out.println(getServiceMethodDescription(jp));

            //前置通知
            result = jp.proceed();
            //返回通知
            String className = jp.getTarget().getClass().toString();//获取目标类名

            String signature = jp.getSignature().toString();//获取目标方法签名
            //缓存至Redis
            Object[] args = jp.getArgs();
            //key策略：需要缓存的对象的全类名-id，如：entity.User-1
            System.out.println("aop 拦截输入日志"+result.getClass().getName() + "-" + args[0] + result);

        } catch (Throwable e) {
            //异常通知

        }
        //后置通知

        return result;
    }

    @AfterThrowing(pointcut = "setJoinPoint()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println(e.getMessage());
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    private static String getServiceMethodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ActionLog.class).action();
                    break;
                }
            }
        }
        return description;
    }



}
