package edu.kfu.itis.spring.day02.lab04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    private Quoter quoter;

    @Autowired
    @QuoterQualifier(QuoterType.TERMINATOR)
    public void setQuoter(Quoter quoter) {
        this.quoter = quoter;
    }

    public String talk() {
        return quoter.sayQuote();
    }
}
