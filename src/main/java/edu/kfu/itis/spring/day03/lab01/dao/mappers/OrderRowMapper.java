package edu.kfu.itis.spring.day03.lab01.dao.mappers;

import edu.kfu.itis.spring.day03.lab01.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements org.springframework.jdbc.core.RowMapper<Object> {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setId( resultSet.getLong("id"));
        order.setName( resultSet.getString("name"));
        order.setEvent_id( resultSet.getLong("event_id"));
        return order;

    }
}
