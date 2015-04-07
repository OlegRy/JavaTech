package edu.kfu.itis.spring.day02.lab05;

import edu.kfu.itis.spring.day02.lab02.StringBuilderFactoryBean;
import edu.kfu.itis.spring.day02.lab04.Quoter;
import edu.kfu.itis.spring.day02.lab04.Robot;
import edu.kfu.itis.spring.day02.lab04.TerminatorQuoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:file.properties")
public class AppConfig {

    @Value("${fileName}")
    private String fileName;

    @Autowired
    private StringBuilder stringBuilder;

    @Bean
    @DependsOn("fileCreator")
    public FileConsumer fileConsumer() {
        return new FileConsumer(fileName);
    }

    @Bean
    public FileCreator fileCreator() {
        return new FileCreator(fileName);
    }

    @Bean
    public Quoter terminatorQuoter() {
        return  new TerminatorQuoter();
    }

    @Bean
    public Robot robot() {
        Robot robot = new Robot();
        robot.setQuoter(terminatorQuoter());
        return robot;
    }

    @Bean
    public StringBuilderFactoryBean stringBuilder() {
        StringBuilderFactoryBean stringBuilderFactoryBean = new StringBuilderFactoryBean();
        stringBuilderFactoryBean.setStart("Start");
        stringBuilderFactoryBean.setMiddle("Middle");
        stringBuilderFactoryBean.setFinish("Finish");
        return stringBuilderFactoryBean;
    }

    @Bean
    public CustomQuoter customQuoter() {
        return new CustomQuoter(stringBuilder);
    }
}

