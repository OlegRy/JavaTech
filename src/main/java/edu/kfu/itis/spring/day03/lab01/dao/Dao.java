package edu.kfu.itis.spring.day03.lab01.dao;

import edu.kfu.itis.spring.day03.lab01.model.BaseModel;

import java.util.List;

public interface Dao<T extends BaseModel> {

    void add(T object);

    void update(T object);

    List<T> getObjects();

    T getObjectById(long id);
}
