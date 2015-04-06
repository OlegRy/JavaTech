package edu.kfu.itis.spring.day01.lab02;

import java.util.List;

/**
 * Created by oleg on 06.04.15.
 */
public class TerminatorQuoter implements Quoter {
    
    List<String> quotes;
    
    @Override
    public void sayQuote() {
        System.out.println(quotes);
    }
    
    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }
}
