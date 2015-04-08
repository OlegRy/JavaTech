package edu.kfu.itis.spring.day02.lab06;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class ExceptionHandlerAspect {

    private List<DatabaseException> cache = new ArrayList<>();

    @AfterThrowing(pointcut = "within(@org.springframework.stereotype.Repository *)", throwing = "ex")
    public void handleDBExceptions(DatabaseException ex) {
        System.out.println("sending mail to dba@mycompany.com " + ex.getMessage());

    }
}
