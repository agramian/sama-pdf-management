package com.abtingramian.service.common.util;

import com.abtingramian.service.data.model.BaseResponse;
import com.google.common.base.Objects;

import java.util.concurrent.TimeUnit;

public final class Constants {

    /**
     * API-related values
     */
    public static final int DEFAULT_API_TIMEOUT_SECONDS = 10;
    public static final String LOGGING_INTERCEPTOR_TAG = "HTTP";

    /**
     * Common API Responses
     */
    public static final BaseResponse EMPTY_RESPONSE = new BaseResponse();

    /**
     * Static file serving
     */
    public static final String STATIC_FILE_DIRECTORY = "/public";
    public static final long STATIC_FILE_CACHE_EXPIRE_TIME = TimeUnit.MINUTES.toSeconds(10);

    /**
     * PostgreSQL Error Codes
     */
    public enum PSQL_ERROR_CODE {
        UNTRACKED_ERROR("-"), SUCCESSFUL_COMPLETION("00000"), UNIQUE_VIOLATION("23505");
        public final String code;

        PSQL_ERROR_CODE(final String code) {
            this.code = code;
        }

        public static PSQL_ERROR_CODE fromCode(final String code) {
            for (final PSQL_ERROR_CODE c : values()) {
                if (Objects.equal(c.code, code)) {
                    return c;
                }
            }
            return UNTRACKED_ERROR;
        }
    }

    /**
     * Prevent construction of objects of this class.
     */
    private Constants() {
        throw new AssertionError();
    }

}
