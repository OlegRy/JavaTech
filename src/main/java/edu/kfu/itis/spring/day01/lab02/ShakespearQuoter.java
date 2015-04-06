package edu.kfu.itis.spring.day01.lab02;

/**
 * Created by oleg on 06.04.15.
 */
public class ShakespearQuoter implements Quoter {

    String quote;

    @Override
    public void sayQuote() {
        System.out.println(quote);
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
