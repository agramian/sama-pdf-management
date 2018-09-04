package com.abtingramian.service.data.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;

import javax.annotation.Nonnull;

public class Error {

    @Expose
    public final String fieldName;
    @Expose
    public final String cause;

    public Error(@Nonnull final String fieldName, @Nonnull final Exception cause) {
        this.fieldName = fieldName;
        this.cause = cause.getClass().getSimpleName();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !Error.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Error other = (Error) obj;
        return Objects.equal(fieldName, other.fieldName)
                && Objects.equal(cause, other.cause);
    }

    @Override
    public String toString() {
        return String.format("fieldName: %s;cause: %s", fieldName, cause);
    }

}
