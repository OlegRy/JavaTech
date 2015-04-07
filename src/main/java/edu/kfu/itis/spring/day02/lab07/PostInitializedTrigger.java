package edu.kfu.itis.spring.day02.lab07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class PostInitializedTrigger implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        String[] beanDefinitionsNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionsName : beanDefinitionsNames) {
            Object bean = applicationContext.getBean(beanDefinitionsName);
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                if (method.getAnnotation(PostInitialized.class) != null) {
                    try {
                        method.invoke(bean);
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        }
    }
}
