package com.countdown.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.countdown.facade.CountdownFacade;
import com.countdown.model.Countdown;
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

    public Result show(String id) {
        LOG.info("show with id: " + id);
        return ok(countdownFacade.search(id));
    }

    public Result add() throws JsonProcessingException {
        JsonNode jsonNode = request().body().asJson();
        LOG.info(jsonNode.toString());
        Countdown countdown = mapper.treeToValue(jsonNode, Countdown.class);
        countdown.set_id(UUID.randomUUID());
        LOG.info(countdown.toString());
        return ok(countdownFacade.insert(countdown).toString());
    }
}
