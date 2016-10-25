package com.countdown.facade;

import com.countdown.model.Countdown;
import com.google.inject.Inject;
import com.mongodb.DBCollection;
import org.mongojack.JacksonDBCollection;

import java.util.UUID;

public class CollectionToJacksonCollection {

    private DBCollection collection;
    private JacksonDBCollection<Countdown, UUID> jacksonDBCollection;

    @Inject
    public CollectionToJacksonCollection(DBCollection collection) {
        this.collection = collection;
        this.jacksonDBCollection = JacksonDBCollection.wrap(collection, Countdown.class, UUID.class);
    }

    public JacksonDBCollection<Countdown, UUID> getJacksonDBCollection() {
        return jacksonDBCollection;
    }
}
