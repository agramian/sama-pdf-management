package com.abtingramian.service.common.util;

import com.google.common.base.Strings;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class RequestUtil {

    public static @Nullable Integer getRequestParamAsInteger(@Nullable final String requestParam) {
        if (Strings.isNullOrEmpty(requestParam)) {
            return null;
        }
        return Integer.valueOf(requestParam);
    }


    /**
     * Prevent construction of objects of this class.
     */
    private RequestUtil() {
        throw new AssertionError();
    }

}
