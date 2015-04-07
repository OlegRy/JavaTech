package edu.kfu.itis.spring.day02.lab03;

import java.util.Random;

/**
 * Created by oleg on 07.04.15.
 */
public class RandomQuoter {

    private String randomQuote;

    public RandomQuoter() {
        Random random = new Random();
        randomQuote = Integer.toHexString(random.nextInt());
    }

    public String getRandomQuote() {
        return randomQuote;
    }

}
