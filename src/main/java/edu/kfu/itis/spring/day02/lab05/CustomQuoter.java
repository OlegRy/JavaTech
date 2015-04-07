package edu.kfu.itis.spring.day02.lab05;

import edu.kfu.itis.spring.day02.lab04.Quoter;

public class CustomQuoter implements Quoter {
    private StringBuilder stringBuilder;

    public CustomQuoter(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public String sayQuote() {
        return stringBuilder.toString();
    }
}
