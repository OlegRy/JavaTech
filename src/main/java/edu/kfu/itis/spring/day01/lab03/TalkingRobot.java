package edu.kfu.itis.spring.day01.lab03;

import edu.kfu.itis.spring.day01.lab02.Quoter;

import javax.annotation.PostConstruct;
import java.util.List;

public class TalkingRobot implements Robot {

    private List<Quoter> quoters;

    @Override
    @PostConstruct
    public void talk() {
        System.out.println("I am robot " + toString() );
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }


    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }


}
