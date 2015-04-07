package edu.kfu.itis.spring.day02.lab02;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by oleg on 07.04.15.
 */
public class StringBuilderFactoryBeanTest {

    @Test
    public void testFactoryBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context2-02.xml");
        StringBuilder builder = context.getBean(StringBuilder.class);
        Assert.assertEquals("startmiddlefinish", builder.toString());
    }
}
