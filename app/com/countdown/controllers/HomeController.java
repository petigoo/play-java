package com.countdown.controllers;

import org.mongojack.JacksonDBCollection;
import org.mongojack.ObjectId;

import com.countdown.facade.CollectionToJacksonCollection;
import com.countdown.model.Countdown;
import com.google.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;

public class HomeController extends Controller {

    private JacksonDBCollection<Countdown, ObjectId> collection;

    @Inject
    public HomeController(CollectionToJacksonCollection collectionToJacksonCollection) {
        this.collection = collectionToJacksonCollection.getJacksonDBCollection();
    }

    public Result index() {
        return ok();
    }

    public Result getNumberOfDocuments() {
        return ok(String.valueOf(collection.count()));
    }

}
