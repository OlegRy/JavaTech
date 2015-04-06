package edu.kfu.itis.spring.day01.lab01;

/**
 * Created by oleg on 06.04.15.
 */
public class Robot {

    @Override
    public String toString() {
        return "I am Robot";
    }

    @RunThisMethod(repeat = 10)
    public void clean() {
        System.out.println("Cleanning");
    }
}
