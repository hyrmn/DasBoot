package com.boot;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {
    @Mock
    ShipwreckRepository shipwreckRepository;

    @InjectMocks
    ShipwreckController sut;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet(){
        Shipwreck saved = new Shipwreck();
        saved.setId(1L);
        when(shipwreckRepository.findOne(1l)).thenReturn(saved);

        Shipwreck wreck = sut.get(1l);

        assertThat(wreck.getId(), is(1l));
    }
}
