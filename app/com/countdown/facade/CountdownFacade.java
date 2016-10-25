package com.countdown.facade;

import java.util.UUID;

import org.joda.time.DateTime;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.countdown.model.Countdown;
import com.google.inject.Inject;

public class CountdownFacade {

    private static final Logger LOG = LoggerFactory.getLogger(CountdownFacade.class);

    private JacksonDBCollection<Countdown, UUID> collection;

    @Inject
    public CountdownFacade(CollectionToJacksonCollection collectionToJacksonCollection) {
        this.collection = collectionToJacksonCollection.getJacksonDBCollection();
    }

    public String search(String id) {
        LOG.info("search");
        // collection.;
        return String.valueOf(collection.count());
    }

    public UUID insert() {
        Countdown countdown = new Countdown(DateTime.parse("2016-11-07T16:30:00"), "to home");
        WriteResult<Countdown, UUID> result = collection.insert(countdown);
        return result.getSavedId();
    }
}
