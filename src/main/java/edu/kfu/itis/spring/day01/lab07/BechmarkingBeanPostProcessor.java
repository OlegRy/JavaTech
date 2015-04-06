package edu.kfu.itis.spring.day01.lab07;

import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BechmarkingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) {
        return bean;


    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) {
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (bean.getClass().getMethod(method.getName(), method.getParameterTypes()).getAnnotation(Benchmark.class) != null) {
                            long start = System.currentTimeMillis();
                            Object returnValue = method.invoke(bean, args);
                            System.out.println("Invocation time: " + (System.currentTimeMillis() - start));
                            return returnValue;
                        }
                        return method.invoke(bean, args);
                    }
                });
    }
}
