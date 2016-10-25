package com.countdown.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.countdown.facade.CountdownFacade;
import com.google.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;

public class CountdownController extends Controller {

    private static final Logger LOG = LoggerFactory.getLogger(CountdownController.class);

    private CountdownFacade countdownFacade;

    @Inject
    public CountdownController(CountdownFacade countdownFacade) {
        this.countdownFacade = countdownFacade;
    }

    public Result show(String id) {
        LOG.info("show with id: " + id);
        return ok(countdownFacade.search(id));
    }

    public Result add() {
        return ok(countdownFacade.insert().toString());
    }
}
