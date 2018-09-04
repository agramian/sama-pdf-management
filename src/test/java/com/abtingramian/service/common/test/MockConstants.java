package com.abtingramian.service.common.test;

import org.flywaydb.core.Flyway;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sql2o.Sql2o;

import static org.mockito.Mockito.when;

/**
 * This is a helper class for storing global constants related to the mock source set.
 */
public class MockConstants {

    @Mock
    public Flyway flyway;
    @Mock
    public Sql2o sql2o;
    private static MockConstants instance;

    private MockConstants() {
        MockitoAnnotations.initMocks(this);
        when(flyway.migrate()).thenReturn(0);
    }

    public static MockConstants getInstance() {
        if (instance == null) {
            // call constructor to "initialize" the instance.
            instance = new MockConstants();
        }
        return instance;
    }

}
