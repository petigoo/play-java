package model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Countdown {
    DateTime time;
    String text;

    public Countdown(DateTime time, String text) {
        this.time = time;
        this.text = text;
    }

    public String getTime() {
        return DateTimeFormat.forPattern("MMMM dd, yyyy HH:mm:ss").print(time);
    }

    public String getText() {
        return text;
    }
}
