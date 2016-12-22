package com.countdown.repository;

import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.countdown.models.Countdown;
import com.google.inject.Inject;

public class CountdownRepository {

    private static final Logger LOG = LoggerFactory.getLogger(CountdownRepository.class);

    private JacksonDBCollection<Countdown, String> collection;

    @Inject
    public CountdownRepository(CollectionToJacksonCollection collectionToJacksonCollection) {
        this.collection = collectionToJacksonCollection.getJacksonDBCollection();
    }

    public Countdown search(String id) {
        LOG.info("search");
        return collection.findOne(DBQuery.is("_id", id));
        // return String.valueOf(collection.count());
    }

    public String insert(Countdown countdown) {
        WriteResult<Countdown, String> result = collection.insert(countdown);
        return result.getSavedObject().get_id();
    }

    public void update(Countdown countdown) {
        WriteResult<Countdown, String> result = collection.updateById(countdown.get_id(), countdown);
    }
}
