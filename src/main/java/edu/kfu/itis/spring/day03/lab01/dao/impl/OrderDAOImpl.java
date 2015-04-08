package edu.kfu.itis.spring.day03.lab01.dao.impl;

import edu.kfu.itis.spring.day03.lab01.dao.OrderDAO;
import edu.kfu.itis.spring.day03.lab01.dao.mappers.OrderRowMapper;
import edu.kfu.itis.spring.day03.lab01.model.Event;
import edu.kfu.itis.spring.day03.lab01.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDAOImpl extends JdbcDaoSupport implements OrderDAO {

    private JdbcTemplate template;

    private String query;
    @Override
    public void add(Order object) {
        query = "insert into orders (name, event_id) values (?, ?, ?)";
        template.update(query, object.getId(), object.getName(), object.getEvent_id());
    }

    @Override
    public void update(Order object) {
        query = "update orders set name = ? where id = ?";
        template.update(query, object.getName(), object.getId());
    }

    @Override
    public List<Order> getObjects() {
        query = "select * from orders";
        List<Order> orders = new ArrayList<>();
        List<Map<String, Object>> rows = template.queryForList(query);
        for (Map<String, Object> row : rows) {

            orders.add(initOrder(row));
        }
        return orders;
    }

    @Override
    public Order getObjectById(long id) {
        query = "select * from orders where id = ?";

        return (Order) template.queryForObject(query, new Object[] {id}, new OrderRowMapper());
    }

    @Autowired
    public void init(JdbcTemplate template) {
        setJdbcTemplate(template);
        this.template = template;
    }

    @Override
    public List<Order> getOrders(Event event) {
        query = "select * from orders where event_id = ?";
        List<Order> orders = new ArrayList<>();
        List<Map<String, Object>> maps = template.queryForList(query, event.getId());
        for (Map<String, Object> map : maps) {
            orders.add(initOrder(map));
        }
        return orders;
    }

    private Order initOrder(Map<String, Object> row) {
        Order order = new Order();
        order.setId((Long) row.get("id"));
        order.setName((String) row.get("name"));
        order.setEvent_id((Long) row.get("event_id"));
        return order;
    }
}
