package com.abtingramian.service.data.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class BaseResponse implements Responsive {

    @Expose
    public String message;
    @Expose
    public List<Error> errors;

    public static class Builder {

        private String message;
        private List<Error> errors;

        public Builder() {
        }

        public Builder message(@Nonnull final String message) {
            this.message = message;
            return this;
        }

        public Builder error(final Error... errors) {
            if (errors == null || errors.length == 0) {
                return message("Error.");
            }
            message("Error. See \"errors\" field for details.");
            this.errors = Arrays.asList(errors);
            return this;
        }

        public Builder duplicate(@Nonnull final Class c) {
            return message(String.format("%s already exists.", c.getSimpleName()));
        }

        public BaseResponse build() {
            final BaseResponse baseResponse = new BaseResponse();
            baseResponse.message = message;
            baseResponse.errors = errors;
            return baseResponse;
        }

    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !BaseResponse.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final BaseResponse other = (BaseResponse) obj;
        return Objects.equal(message, other.message) && Objects.equal(errors, other.errors);
    }

    @Override
    public String toString() {
        return String.format("message: %s;errors: %s", message, errors != null ? errors.toString() : null);
    }

}
