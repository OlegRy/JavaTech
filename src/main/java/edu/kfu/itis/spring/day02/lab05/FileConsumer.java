package edu.kfu.itis.spring.day02.lab05;

import javax.annotation.PostConstruct;
import java.io.File;

public class FileConsumer {

    private String fileName;

    public FileConsumer(String fileName) {
        this.fileName = fileName;
    }

    @PostConstruct
    public void consumeFile() {
        System.out.println("Reading from file " + fileName);
        System.out.println(new File(fileName).length());
    }
}
