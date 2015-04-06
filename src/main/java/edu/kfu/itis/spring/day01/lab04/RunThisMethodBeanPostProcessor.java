package edu.kfu.itis.spring.day01.lab04;

import edu.kfu.itis.spring.day01.lab01.RunThisMethod;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

public class RunThisMethodBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        try {
            System.out.println("BPP runs on " + beanName);
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
                if (annotation != null) {
                    int repeat = annotation.repeat();
                    for (int j = 0; j < repeat; j++) {
                        method.invoke(bean);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println();
        return bean;
    }

}
