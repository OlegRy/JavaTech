package edu.kfu.itis.spring.day01.lab02;

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
