package edu.kfu.itis.spring.day02.lab06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RepositoryTest {

    @Autowired
    private Repository repository;

    @Test(expected = DatabaseException.class)
    public void testPersistMessage() {
        repository.persistMessage("bla");
    }
}
