package com.countdown.controllers;

import java.util.UUID;

import org.joda.time.DateTime;
import org.mongojack.JacksonDBCollection;

import com.countdown.facade.CollectionToJacksonCollection;
import com.countdown.model.Countdown;
import com.countdown.views.html.index;
import com.google.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;

public class HomeController extends Controller {

    private JacksonDBCollection<Countdown, UUID> collection;

    @Inject
    public HomeController(CollectionToJacksonCollection collectionToJacksonCollection) {
        this.collection = collectionToJacksonCollection.getJacksonDBCollection();
    }

    public Result index() {
        return ok(index.render(new Countdown(DateTime.parse("2016-10-07T17:10:00"), "to PUBlin-IRAland")));
    }

    public Result getNumberOfDocuments() {
        return ok(String.valueOf(collection.count()));
    }

}
