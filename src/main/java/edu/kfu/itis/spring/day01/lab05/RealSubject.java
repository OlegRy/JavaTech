package edu.kfu.itis.spring.day01.lab05;

import edu.kfu.itis.spring.day01.lab07.Benchmark;
import edu.kfu.itis.spring.day01.lab08.Transactional;

@Transactional
public class RealSubject implements Subject {

    @Override
    @Benchmark
    public int longMethod() throws InterruptedException {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            count++;
        }
        return count;
    }
}
