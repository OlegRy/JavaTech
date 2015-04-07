package edu.kfu.itis.spring.day02.lab04;

import org.springframework.stereotype.Component;

@Component
public class ShakeSpearQuoter implements Quoter {
    @Override
    public String sayQuote() {
        return "2b | !2b";
    }
}
