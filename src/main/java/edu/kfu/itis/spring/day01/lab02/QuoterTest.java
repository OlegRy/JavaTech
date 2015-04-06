package edu.kfu.itis.spring.day01.lab02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by oleg on 06.04.15.
 */
public class QuoterTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Quoter shakespearQuoter = ((Quoter) context.getBean(Quoter.class));
        shakespearQuoter.sayQuote();
    }
}
