package edu.kfu.itis.spring.day02.lab07;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PostPostComponent {

    @PostConstruct
    public void postConstruct() {
        System.out.println("I am post construct");
    }

    @PostInitialized
    public void postInitialize() {
        System.out.println("I am post initialize");
    }
}
