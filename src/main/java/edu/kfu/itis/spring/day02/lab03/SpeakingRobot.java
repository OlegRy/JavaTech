package edu.kfu.itis.spring.day02.lab03;

/**
 * Created by oleg on 07.04.15.
 */
public abstract class SpeakingRobot implements Robot {

    @Override
    public String speak() {
        return getQuoter().getRandomQuote();
    }

    @Override
    public abstract RandomQuoter getQuoter();
}
