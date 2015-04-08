package edu.kfu.itis.spring.day03.lab02;

public class GreeterImpl implements Greeter {

    private String message;


    @Override
    public String greet() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
