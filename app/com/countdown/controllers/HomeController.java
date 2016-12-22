package com.countdown.controllers;

import org.mongojack.JacksonDBCollection;

import com.countdown.repository.CollectionToJacksonCollection;
import com.countdown.models.Countdown;
import com.google.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;

public class HomeController extends Controller {

    private JacksonDBCollection<Countdown, String> collection;

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
