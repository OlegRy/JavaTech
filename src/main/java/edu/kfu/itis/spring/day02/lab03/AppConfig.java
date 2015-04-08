package edu.kfu.itis.spring.day02.lab03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public SpeakingRobot robot() {
        return new SpeakingRobot() {
            @Override
            public RandomQuoter getQuoter() {
                return quoter();
            }
        };
    }

    @Bean
    @Scope("prototype")
    public RandomQuoter quoter() {
        System.out.println("Creating new qouter");
        return new RandomQuoter();
    }
}
