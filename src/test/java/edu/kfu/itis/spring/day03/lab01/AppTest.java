package edu.kfu.itis.spring.day03.lab01;

import edu.kfu.itis.spring.day03.lab01.model.Event;
import edu.kfu.itis.spring.day03.lab01.model.Guest;
import edu.kfu.itis.spring.day03.lab01.model.Order;
import edu.kfu.itis.spring.day03.lab01.service.EventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = edu.kfu.itis.spring.day03.lab01.conf.AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

    @Autowired
    private EventService eventService;

    @Test
    public void testRegister() {
        Event event = new Event();
        event.setName("JavaDay 2015");
        Order order = new Order();
        order.setName("order1");
        eventService.register(event, order);
    }

    @Test
    public void testGetGuests() {
        Event event = new Event();
        event.setName("JavaDay 2015");
        Order order = new Order();
        order.setName("order1");
        eventService.register(event, order);
        List<Guest> guestList = eventService.getGuests(event);
        org.junit.Assert.assertEquals(1, guestList.size());
    }
}