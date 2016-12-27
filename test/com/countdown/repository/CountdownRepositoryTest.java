package com.countdown.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.countdown.models.Countdown;

@RunWith(MockitoJUnitRunner.class)
public class CountdownRepositoryTest {

    private static final String DUMMY_ID = "dummy id";
    @Mock
    private JacksonDBCollection<Countdown, String> collectionMock;
    @Mock
    private CollectionToJacksonCollection collectionToJacksonCollectionMock;
    @Mock
    private WriteResult<Countdown, String> resultMock;
    @Mock
    private Countdown countdownMock;

    private Countdown countdown;

    private CountdownRepository underTest;

    @Before
    public void setUp() {
        when(collectionToJacksonCollectionMock.getJacksonDBCollection()).thenReturn(collectionMock);
        countdown = new Countdown();
        underTest = new CountdownRepository(collectionToJacksonCollectionMock);
    }

    @Test
    public void testSearch() throws Exception {
        // Given
        when(collectionMock.findOne(any(DBQuery.Query.class))).thenReturn(new Countdown());

        // When
        underTest.search(DUMMY_ID);

        // Then
        verify(collectionMock).findOne(any(DBQuery.Query.class));
    }

    @Test
    public void testInsert() throws Exception {
        // Given
        when(collectionMock.insert(any(Countdown.class))).thenReturn(resultMock);
        when(resultMock.getSavedObject()).thenReturn(countdownMock);
        when(countdownMock.get_id()).thenReturn(DUMMY_ID);

        // When
        String result = underTest.insert(countdown);

        // Then
        assertThat(result).isEqualTo(DUMMY_ID);
        verify(collectionMock).insert(any(Countdown.class));
    }

    @Test
    public void testUpdate() throws Exception {
        // Given

        // When
        underTest.update(countdown);

        // Then
        verify(collectionMock).updateById(countdown.get_id(), countdown);
    }

}