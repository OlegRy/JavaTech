package edu.kfu.itis.spring.day02.lab03;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SpeakingRobotJavaConfigTest {

    @Autowired
    private Robot robot;

    @Test
    public void testRandomQuotes() {
        Assert.assertNotEquals(robot.speak(), robot.speak());
    }
}
