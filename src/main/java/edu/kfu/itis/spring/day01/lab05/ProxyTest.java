package edu.kfu.itis.spring.day01.lab05;

/**
 * Created by oleg on 06.04.15.
 */
public class ProxyTest {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("context.xml");
        Subject subject = context.getBean(Subject.class);
        subject.longMethod();
    }
}
