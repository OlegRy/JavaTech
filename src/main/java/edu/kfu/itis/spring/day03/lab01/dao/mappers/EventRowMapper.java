package edu.kfu.itis.spring.day03.lab01.dao.mappers;

import edu.kfu.itis.spring.day03.lab01.model.Event;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements org.springframework.jdbc.core.RowMapper<Object> {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getLong("id"));
        event.setName(resultSet.getString("name"));
        return event;
    }
}
