package edu.kfu.itis.spring.day03.lab01.dao;

import edu.kfu.itis.spring.day03.lab01.model.Event;
import edu.kfu.itis.spring.day03.lab01.model.Order;

import java.util.List;

public interface OrderDAO extends Dao<Order> {


    List<Order> getOrders(Event event);
}
