package com.countdown.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.countdown.facade.CountdownFacade;
import com.countdown.models.Countdown;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;

public class CountdownController extends Controller {

    private static final Logger LOG = LoggerFactory.getLogger(CountdownController.class);

    private CountdownFacade countdownFacade;
    private ObjectMapper mapper;

    @Inject
    public CountdownController(CountdownFacade countdownFacade, ObjectMapper mapper) {
        this.countdownFacade = countdownFacade;
        this.mapper = mapper;
    }

    public Result show(String id) throws JsonProcessingException {
        LOG.info("show with id: " + id);
        return ok(mapper.writeValueAsString(countdownFacade.search(id)));
    }

    public Result add() throws JsonProcessingException {
        Countdown countdown = getPostedCountdown();
        countdown.set_id(UUID.randomUUID().toString());
        LOG.info(countdown.toString());
        return ok(countdownFacade.insert(countdown));
    }

    private Countdown getPostedCountdown() throws JsonProcessingException {
        JsonNode jsonNode = request().body().asJson();
        LOG.info(jsonNode.toString());
        return mapper.treeToValue(jsonNode, Countdown.class);
    }

    public Result update(String id) throws JsonProcessingException {
        Countdown countdown = getPostedCountdown();
        countdown.set_id(id);
        countdownFacade.update(countdown);
        return ok();
    }
}
