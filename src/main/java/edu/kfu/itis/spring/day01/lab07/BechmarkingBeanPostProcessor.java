package edu.kfu.itis.spring.day01.lab07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by oleg on 06.04.15.
 */
public class BechmarkingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) {
        return bean;


    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (bean.getClass().getMethod(method.getName(), method.getParameterTypes()).getAnnotation(Benchmark.class) != null) {
                            long start = System.currentTimeMillis();
                            Object returnValue = method.invoke(bean, args);
                            System.out.println("Invocation time: " + (start - System.currentTimeMillis()));
                            return returnValue;
                        }
                        return method.invoke(bean,args);
                    }
                });
    }
}
