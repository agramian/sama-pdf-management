package com.abtingramian.service.common.middleware;

import com.abtingramian.service.common.config.Config;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.afterAfter;
import static spark.Spark.before;

public class Filters {

    public static void addGlobalFilters(final Config config) {
        // before filters
        before(addJsonHeader);
        before(addCorsHeader(config));
        // after filters
        // TODO
        // after after filters
        afterAfter(addGzipHeader);
    }

    // Default all responses to type JSON.
    private static Filter addJsonHeader = (final Request request, final Response response) -> {
        response.type(MediaType.JSON_UTF_8.toString());
    };

    // Enable GZIP for all responses.
    private static Filter addGzipHeader = (final Request request, final Response response) -> {
        response.header(HttpHeaders.CONTENT_ENCODING, "gzip");
    };

    // Enable CORS.
    private static Filter addCorsHeader(final Config config) {
        return (final Request request, final Response response) -> {
            response.header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, config.frontendBaseUrl);
        };
    }

    /**
     * Prevent construction of objects of this class.
     */
    private Filters() {
        throw new AssertionError();
    }

}
