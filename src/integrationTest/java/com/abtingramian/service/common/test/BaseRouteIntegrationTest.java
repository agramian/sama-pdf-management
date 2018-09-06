package com.abtingramian.service.common.test;

import com.abtingramian.service.Service;
import com.abtingramian.service.common.di.component.AppComponent;
import com.abtingramian.service.common.util.ResourceProvider;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import okhttp3.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static spark.Spark.stop;

public abstract class BaseRouteIntegrationTest {//<T extends Route> {

    private static final String HOST = "http://localhost";

    protected final Gson gson;
    protected final AppComponent appComponent;
    protected ResourceProvider resourceProvider = new ResourceProvider(new Gson());
    private final OkHttpClient client;
    private final Service service;

    public BaseRouteIntegrationTest() {
        service = new Service("test");
        appComponent = service.appComponent;
        client = service.appComponent.okHttpClient();
        gson = appComponent.gson();
    }

    @BeforeClass
    public static void setUpSuite() {
    }

    @Before
    public void setUp() {
        service.appComponent.flyway().clean();
        service.appComponent.flyway().migrate();
    }

    @After
    public void tearDown() {
        stop();
    }

    @AfterClass
    public static void tearDownSuite() {
    }

    protected Response get(final String route) throws IOException {
        return sendRequest(getRequestBuilder(route, null).get().build());
    }

    protected <T> TestResponse<T> get(final String route, final Class<T> classOfT) throws IOException {
        return sendRequest(getRequestBuilder(route, null).get().build(), classOfT);
    }

    protected Response post(final String route, final RequestBody requestBody) throws IOException {
        return sendRequest(getRequestBuilder(route, null).post(requestBody).build());
    }

    protected <T> TestResponse<T> post(final String route,
                                       final RequestBody requestBody,
                                       final Class<T> classOfT) throws IOException {
        return post(route, null, requestBody, classOfT);
    }

    protected <T> TestResponse<T> post(final String route,
                                       @Nullable final Map<String,String> queryParams,
                                       final RequestBody requestBody,
                                       final Class<T> classOfT) throws IOException {
        return sendRequest(getRequestBuilder(route, queryParams).post(requestBody).build(), classOfT);
    }

    protected Response patch(final String route, final RequestBody requestBody) throws IOException {
        return sendRequest(getRequestBuilder(route, null).patch(requestBody).build());
    }

    protected <T> TestResponse<T> patch(final String route,
                                        final RequestBody requestBody,
                                        final Class<T> classOfT) throws IOException {
        return sendRequest(getRequestBuilder(route, null).patch(requestBody).build(), classOfT);
    }

    private Request.Builder getRequestBuilder(final String route, @Nullable final Map<String,String> queryParams) throws MalformedURLException {
        final URL url = new URL(HOST + route);
        // create http url with query params if any
        final HttpUrl.Builder httpUrlBuilder = new HttpUrl.Builder().scheme(url.getProtocol())
                .host(url.getHost())
                .port(service.appComponent.config().portNumber);
        if (!Strings.isNullOrEmpty(url.getPath())) {
            httpUrlBuilder.encodedPath(url.getPath());
        }
        // maybe add query params
        if (queryParams != null) {
            queryParams.forEach(httpUrlBuilder::addQueryParameter);
        }
        // return a request builder object
        return new Request.Builder().url(httpUrlBuilder.build());
    }

    private Response sendRequest(final Request request) throws IOException {
        // make the request and return the response
        return client.newCall(request).execute();
    }

    private <T> TestResponse<T> sendRequest(final Request request, final Class<T> classOfT) throws IOException {
        // make the request and return a TestResponse object which contains
        // the original response and the model object parsed from the json
        final TestResponse<T> testResponse = new TestResponse<>();
        testResponse.response = client.newCall(request).execute();
        testResponse.responseModel = gson.fromJson(testResponse.response.body().string(), classOfT);
        return testResponse;
    }

    public static class TestResponse<T> {
        public Response response;
        public T responseModel;
    }

}
