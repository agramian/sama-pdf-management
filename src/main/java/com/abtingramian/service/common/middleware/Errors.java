package com.abtingramian.service.common.middleware;

import com.abtingramian.service.data.model.BaseResponse;
import com.google.gson.Gson;

import static spark.Spark.*;

public final class Errors {

    public static final BaseResponse ERROR_404 = new BaseResponse.Builder().message("Not found.").build();
    public static final BaseResponse ERROR_500 = new BaseResponse.Builder().message("Internal server error.").build();
    public static final BaseResponse ERROR_MISSING_POST_BODY = new BaseResponse.Builder().message("Missing POST body.").build();
    public static final BaseResponse ERROR_INVALID_POST_BODY = new BaseResponse.Builder().message("Invalid POST body.").build();

    public static void addGlobalErrorHandling(final Gson gson) {
        // handle 404 errors
        notFound((request, response) -> gson.toJson(ERROR_404));
        // handle 500 errors
        internalServerError((request, response) -> gson.toJson(ERROR_500));
        // handle custom exceptions
        exception(MissingPostBodyException.class, (exception, request, response) -> {
            response.status(400);
            response.body(gson.toJson(ERROR_MISSING_POST_BODY));
        });
        exception(InvalidPostBodyException.class, (exception, request, response) -> {
            response.status(400);
            response.body(gson.toJson(ERROR_INVALID_POST_BODY));
        });
    }

    /**
     * Custom error exceptions.
     */
    public static class RequestException extends Exception {
    }

    public static final class MissingPostBodyException extends RequestException {
    }

    public static final class InvalidPostBodyException extends RequestException {
    }

    public static final class MissingQueryParameterException extends RequestException {
    }

    public static final class InvalidQueryParameterException extends RequestException {
    }

    public static final class MissingPathParameterException extends RequestException {
    }

    public static final class InvalidPathParameterException extends RequestException {
    }

    public static final class MissingPostBodyFieldException extends RequestException {
    }

    public static final class InvalidPostBodyFieldException extends RequestException {
    }

    /**
     * Prevent construction of objects of this class.
     */
    private Errors() {
        throw new AssertionError();
    }

}
