package com.example.events;

import java.io.Serializable;

public class EventModel implements Serializable {

    private String eventTitle;
    private String eventDescription;
    private String eventStartDate;
    private String eventEndDate;
    private String eventStartTime;
    private String eventEndTime;
    private int price;

    public EventModel(String eventTitle, String eventDescription, String eventStartDate, String eventEndDate, String eventStartTime, String eventEndTime, int price) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.price = price;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public int getPrice() {
        return price;
    }
}