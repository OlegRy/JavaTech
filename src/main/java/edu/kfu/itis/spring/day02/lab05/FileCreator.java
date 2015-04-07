package edu.kfu.itis.spring.day02.lab05;

import javax.annotation.PostConstruct;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {

    private String fileName;

    public FileCreator(String fileName) {
        this.fileName = fileName;
    }

    @PostConstruct
    public void writeFile() {
        try(FileWriter writer = new FileWriter(fileName)) {
            writer.write("bla-bla-bla");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
