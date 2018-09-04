package com.abtingramian.service.common.route;

import com.google.common.net.HttpHeaders;

import static spark.Spark.options;

public final class Routes {

    /**
     * Form routes
     */
    public static final String FORM_GET = "/form";
    public static final String FORM_POST = "/form/:id";

    /**
     * Global routes
     */
    public static void addGlobalRoutes() {
        // CORS
        options("/*", (request, response) -> {
            // maybe add allow headers header
            final String accessControlRequestHeaders = request.headers(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS);
            if (accessControlRequestHeaders != null) {
                response.header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, accessControlRequestHeaders);
            }
            // maybe add allow methods header
            final String accessControlRequestMethod = request.headers(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD);
            if (accessControlRequestMethod != null) {
                response.header(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, accessControlRequestMethod);
            }
            return "OK";
        });
    }

    /**
     * Prevent construction of objects of this class.
     */
    private Routes() {
        throw new AssertionError();
    }

}
