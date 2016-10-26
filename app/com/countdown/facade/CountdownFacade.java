package com.countdown.facade;

import java.util.UUID;

import com.mongodb.BasicDBObject;
import org.mongojack.JacksonDBCollection;
import org.mongojack.ObjectId;
import org.mongojack.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.countdown.model.Countdown;
import com.google.inject.Inject;

public class CountdownFacade {

    private static final Logger LOG = LoggerFactory.getLogger(CountdownFacade.class);

    private JacksonDBCollection<Countdown, ObjectId> collection;

    @Inject
    public CountdownFacade(CollectionToJacksonCollection collectionToJacksonCollection) {
        this.collection = collectionToJacksonCollection.getJacksonDBCollection();
    }

    public Countdown search(String id) {
        LOG.info("search");
        return collection.findOne(new BasicDBObject("_id", id));
//        return String.valueOf(collection.count());
    }

    public UUID insert(Countdown countdown) {
        WriteResult<Countdown, ObjectId> result = collection.insert(countdown);
        return result.getSavedObject().get_id();
    }
}
