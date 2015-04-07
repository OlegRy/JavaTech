package edu.kfu.itis.spring.day02.lab06;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "edu.kfu.itis.spring.day02.lab06")
public class AppConfig {
}
