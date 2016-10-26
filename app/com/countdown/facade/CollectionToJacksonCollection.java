package com.countdown.facade;

import org.mongojack.JacksonDBCollection;
import org.mongojack.ObjectId;

import com.countdown.model.Countdown;
import com.google.inject.Inject;
import com.mongodb.DBCollection;

public class CollectionToJacksonCollection {

    private DBCollection collection;
    private JacksonDBCollection<Countdown, ObjectId> jacksonDBCollection;

    @Inject
    public CollectionToJacksonCollection(DBCollection collection) {
        this.collection = collection;
        this.jacksonDBCollection = JacksonDBCollection.wrap(collection, Countdown.class, ObjectId.class);
    }

    public JacksonDBCollection<Countdown, ObjectId> getJacksonDBCollection() {
        return jacksonDBCollection;
    }
}
