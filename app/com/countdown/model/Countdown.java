package com.countdown.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.UUID;

public class Countdown {
    UUID _id;
    @JsonFormat(pattern = "MMMM dd, yyyy HH:mm:ss")
    Date time;
    String text;

    public Countdown() {
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Countdown{" + "_id=" + _id + ", time=" + time + ", text='" + text + '\'' + '}';
    }
}
