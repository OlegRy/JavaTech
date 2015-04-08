package edu.kfu.itis.spring.day03.lab01.dao.impl;

import edu.kfu.itis.spring.day03.lab01.dao.EventDAO;
import edu.kfu.itis.spring.day03.lab01.model.Event;
import edu.kfu.itis.spring.day03.lab01.dao.mappers.EventRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EventDAOImpl extends JdbcDaoSupport implements EventDAO {

    private JdbcTemplate template;

    @Override
    public void add(Event event) {
        String query = "insert into events (name, guest_id) values (?, ?)";
        template.update(query, event.getName());
    }

    @Override
    public void update(Event event) {
        String query = "update events set name = ? where id = ?";
        template.update(query, event.getName(), event.getId());
    }

    @Override
    public List<Event> getObjects() {
        String query = "select * from events";
        List<Event> events = new ArrayList<>();

        List<Map<String, Object>> rows = template.queryForList(query);
        for (Map row : rows) {
            Event event = new Event();
            event.setId((Long) row.get("id"));
            event.setName((String) row.get("name"));
            events.add(event);
        }
        return events;
    }

    @Override
    public Event getObjectById(long id) {
        String query = "select * from events where id = ?";
        return (Event) template.queryForObject(query, new Object[] {id}, new EventRowMapper());
    }

}
