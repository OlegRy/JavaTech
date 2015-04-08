package edu.kfu.itis.spring.day02.lab06;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private Repository repository;

    @Override
    public void saveData(String data) {
        try {
            repository.persistMessage(data);
        } catch (Exception e) {
            throw e;
        }

    }


    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
