package edu.kfu.itis.spring.day01.lab07;

import edu.kfu.itis.spring.day01.lab05.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BbppTest {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context07.xml");
        context.getBean(Subject.class).longMethod();
    }
}
