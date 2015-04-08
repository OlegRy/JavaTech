package edu.kfu.itis.spring.day03.lab01.model;

import java.util.List;

public class Order extends BaseModel {

    private String name;
    private long event_id;
    private List<Guest> guests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public List<Guest> getGuests() {
        return guests;
    }
}
