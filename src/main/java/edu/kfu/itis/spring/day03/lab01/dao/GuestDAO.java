package edu.kfu.itis.spring.day03.lab01.dao;

import edu.kfu.itis.spring.day03.lab01.model.Guest;
import edu.kfu.itis.spring.day03.lab01.model.Order;

import java.util.List;

public interface GuestDAO extends Dao<Guest> {

    List<Guest> getGuests(Order o);
}
