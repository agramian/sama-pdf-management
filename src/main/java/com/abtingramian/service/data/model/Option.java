package com.abtingramian.service.data.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;

/**
 * This is a model representing a form option object.
 */
public class Option {

    @Expose
    public String key;
    @Expose
    public String title;
    @Expose
    public String type;

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !Option.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Option other = (Option) obj;
        return Objects.equal(key, other.key)
                && Objects.equal(title, other.title)
                && Objects.equal(type, other.type);
    }

    @Override
    public String toString() {
        return String.format("key: %s;", key);
    }

}
