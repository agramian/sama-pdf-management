package com.abtingramian.service.common.test;

import com.abtingramian.service.common.util.ResourceProvider;
import com.google.gson.Gson;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

public abstract class BaseRouteTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    protected ResourceProvider resourceProvider = new ResourceProvider(new Gson());

    public BaseRouteTest() {
    }

    @BeforeClass
    public static void setUpSuite() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownSuite() {
    }

}
