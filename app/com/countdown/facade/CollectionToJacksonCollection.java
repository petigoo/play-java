package com.countdown.facade;

import org.mongojack.JacksonDBCollection;

import com.countdown.models.Countdown;
import com.google.inject.Inject;
import com.mongodb.DBCollection;

public class CollectionToJacksonCollection {

    private DBCollection collection;
    private JacksonDBCollection<Countdown, String> jacksonDBCollection;

    @Inject
    public CollectionToJacksonCollection(DBCollection collection) {
        this.collection = collection;
        this.jacksonDBCollection = JacksonDBCollection.wrap(collection, Countdown.class, String.class);
    }

    public JacksonDBCollection<Countdown, String> getJacksonDBCollection() {
        return jacksonDBCollection;
    }
}
