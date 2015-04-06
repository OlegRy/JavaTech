package edu.kfu.itis.spring.day01.lab08;

import edu.kfu.itis.spring.day01.lab07.Benchmark;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 06.04.15.
 */
public class TransactionBeanPostProcessor implements BeanPostProcessor {

    private List<String> classesToInstrument = new ArrayList<String>();

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) {
        if (bean.getClass().getAnnotation(Transactional.class) != null) {
            classesToInstrument.add(beanName);
        }


    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (classesToInstrument.contains(beanName)) {
            Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("transaction start");
                            Object returnValue = method.invoke(bean, args);
                            System.out.println("transaction commit");

                            return returnValue;
                        }
                    });
        }
        return bean;
    }
}
