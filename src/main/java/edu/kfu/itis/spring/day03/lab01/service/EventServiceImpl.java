package edu.kfu.itis.spring.day03.lab01.service;

import edu.kfu.itis.spring.day03.lab01.dao.EventDAO;
import edu.kfu.itis.spring.day03.lab01.dao.GuestDAO;
import edu.kfu.itis.spring.day03.lab01.dao.OrderDAO;
import edu.kfu.itis.spring.day03.lab01.model.Event;
import edu.kfu.itis.spring.day03.lab01.model.Guest;
import edu.kfu.itis.spring.day03.lab01.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by atataururu on 08.04.15.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private GuestDAO guestDao;

    @Autowired
    private EventDAO eventDao;

    @Autowired
    private OrderDAO orderDao;

    @Override
    @Transactional
    public void register(Event event, Order order) {
        if (eventDao.getObjectById(event.getId()) == null) {
            eventDao.add(event);
            log("saved new event: " + event.getId());
        }
        if (orderDao.getObjectById(order.getId()) == null) {
            orderDao.add(order);
            log("saved new order: " + order.getId());
        }
        for (Guest g: order.getGuests()) {
            guestDao.add(g);
            log("saved new guest: " + g.getId());
        }
    }

    @Override
    public List<Guest> getGuests(Event event) {
        List<Guest> list = new ArrayList<>();
        for (Order o: orderDao.getOrders(event)) {
            list.addAll(guestDao.getGuests(o).stream().collect(Collectors.toList()));
        }
        return list;
    }

    private void log(String s) {
        System.out.println(s);
    }
}
