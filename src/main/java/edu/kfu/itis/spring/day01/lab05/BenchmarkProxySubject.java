package edu.kfu.itis.spring.day01.lab05;

/**
 * Created by oleg on 06.04.15.
 */
class BenchmarkProxySubject implements Subject {

    private RealSubject subject;

    public BenchmarkProxySubject() {
        subject = new RealSubject();
    }

    @Override
    public int longMethod() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int count = subject.longMethod();
        System.out.println("Time: " + (System.currentTimeMillis()));
        return count;
    }
}
