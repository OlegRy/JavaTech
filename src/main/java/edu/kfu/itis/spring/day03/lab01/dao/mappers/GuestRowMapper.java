package edu.kfu.itis.spring.day03.lab01.dao.mappers;

import edu.kfu.itis.spring.day03.lab01.model.Guest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestRowMapper implements org.springframework.jdbc.core.RowMapper<Object> {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Guest guest = new Guest();
        guest.setId(resultSet.getLong("id"));
        guest.setName(resultSet.getString("name"));
        guest.setSurname(resultSet.getString("surname"));
        return guest;
    }
}
