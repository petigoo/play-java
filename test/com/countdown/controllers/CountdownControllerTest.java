package com.countdown.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.countdown.facade.CountdownFacade;
import com.countdown.models.Countdown;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.mvc.Http;
import play.mvc.Result;

@RunWith(MockitoJUnitRunner.class)
public class CountdownControllerTest {

    private static final String DUMMY_ID = "42f799cb-d719-4592-a9ab-fe5fc748f6aa";
    private static final String DUMMY_TEST = "some text for countdown";
    private static final String JSON_VALUE_AS_STRING = "{\"_id\":\"69d8b9c3-2fb8-45e4-82a2-f2b53eb1d704\",\"time\":\"2016-11-08T16:34:00\",\"text\":\"kalap\"}";
    private static final String DUMMY_DATE = "2016-11-11T05:02:30";
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    @Mock
    private CountdownFacade countdownFacadeMock;
    @Mock
    private ObjectMapper mapperMock;
    @Mock
    private Http.Request requestMock;
    @Mock
    private Http.RequestBody bodyMock;

    private Countdown countdown;

    private CountdownController underTest;

    @Before
    public void setUp() throws ParseException {
        underTest = new CountdownController(countdownFacadeMock, mapperMock);
        countdown = getCountdown();
    }

    private Countdown getCountdown() throws ParseException {
        Countdown countdown = new Countdown();
        countdown.set_id(DUMMY_ID);
        countdown.setTime(new SimpleDateFormat(DATE_PATTERN).parse(DUMMY_DATE));
        countdown.setText(DUMMY_TEST);
        return countdown;
    }

    @Test
    public void showShouldReturnWithOkStatusAndJsonValue() throws JsonProcessingException {
        // Given
        when(countdownFacadeMock.search(anyString())).thenReturn(countdown);
        when(mapperMock.writeValueAsString(any(Countdown.class))).thenReturn(JSON_VALUE_AS_STRING);

        // When
        Result result = underTest.show(DUMMY_ID);

        // Then
        assertThat(result.status()).isEqualTo(OK);
        assertThat(contentAsString(result)).isEqualTo(JSON_VALUE_AS_STRING);
    }

//    @Test
//    public void addShouldReturnWithOkStatus() throws IOException {
//        // Given
//        when(countdownFacadeMock.insert(any(Countdown.class))).thenReturn(countdown.get_id());
//        when(requestMock.body()).thenReturn(bodyMock);
//        when(bodyMock.asJson()).thenReturn(new ObjectMapper().readTree("{\"text\":\"auto\",\"time\":\"2016-11-08T16:31:00\"}"));
//        when(mapperMock.treeToValue(any(JsonNode.class), eq(Countdown.class))).thenReturn(countdown);
//
//        // When
//        Result result = underTest.add();
//
//        // Then
//        assertThat(result.status()).isEqualTo(OK);
//    }

}
