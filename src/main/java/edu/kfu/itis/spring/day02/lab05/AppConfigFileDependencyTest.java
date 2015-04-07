package edu.kfu.itis.spring.day02.lab05;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigFileDependencyTest {

    @Test
    public void testFileDependency() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

}
