package com.countdown.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Countdown {
    String _id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Date time;
    String text;

    public Countdown() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
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
