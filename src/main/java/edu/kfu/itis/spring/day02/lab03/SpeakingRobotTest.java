package edu.kfu.itis.spring.day02.lab03;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpeakingRobotTest {

    @Test
    public void testRandomQuotes() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context2-03.xml");
        SpeakingRobot robot = context.getBean(SpeakingRobot.class);
        Assert.assertNotEquals(robot.speak(), robot.speak());
    }
}
