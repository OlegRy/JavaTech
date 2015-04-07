package edu.kfu.itis.spring.day02.lab06;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {

    @Override
    public void persistMessage(String message) {
        throw new DatabaseException("Failed to save");
    }
}
