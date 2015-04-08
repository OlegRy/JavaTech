package edu.kfu.itis.spring.day03.lab01.dao.impl;

import edu.kfu.itis.spring.day03.lab01.dao.GuestDAO;
import edu.kfu.itis.spring.day03.lab01.model.Guest;
import edu.kfu.itis.spring.day03.lab01.dao.mappers.GuestRowMapper;
import edu.kfu.itis.spring.day03.lab01.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class GuestDAOImpl extends JdbcDaoSupport implements GuestDAO {

    private JdbcTemplate template;
    private String query;

    @Override
    public void add(Guest object) {
        query = "insert into guests (name, surname) values (?, ?)";
        template.update(query, object.getName(), object.getSurname());
    }

    @Override
    public void update(Guest guest) {
        query = "update guests set name = ?, surname = ? where id = ?";
        template.update(query, guest.getName(), guest.getSurname(), guest.getId());
    }

    @Override
    public List<Guest> getObjects() {
        query = "select * from guests";
        List<Guest> guests = new ArrayList<>();
        List<Map<String, Object>> rows = template.queryForList(query);
        for (Map<String, Object> row : rows) {

            guests.add(initGuest(row));
        }
        return guests;
    }

    @Override
    public Guest getObjectById(long id) {
        query = "select * from guests where id = ?";

        return (Guest) template.queryForObject(query, new Object[] {id}, new GuestRowMapper());
    }

    @Override
    public List<Guest> getGuests(Order o) {
        query = "select * from guests where order_id = ?";
        List<Guest> guests = new ArrayList<>();
        List<Map<String, Object>> maps = template.queryForList(query, o.getId());
        for (Map<String, Object> map : maps) {
            guests.add(initGuest(map));
        }
        return null;
    }

    private Guest initGuest(Map<String, Object> map) {
        Guest guest = new Guest();
        guest.setId((Long) map.get("id"));
        guest.setName((String) map.get("name"));
        guest.setSurname((String) map.get("surname"));
        return guest;
    }
}
