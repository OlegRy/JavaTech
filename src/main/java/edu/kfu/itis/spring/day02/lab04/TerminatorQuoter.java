package edu.kfu.itis.spring.day02.lab04;

import org.springframework.stereotype.Component;

@Component
public class TerminatorQuoter implements Quoter {

    @Override
    public String sayQuote() {
        return "I'll be back";
    }
}
