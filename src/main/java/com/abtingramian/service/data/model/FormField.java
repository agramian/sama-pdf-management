package com.abtingramian.service.data.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This is a model representing a Form config object.
 */
public class FormField implements Responsive {

    @Expose
    public String key;
    @Expose
    public String title;
    @Expose
    public String type;
    @Expose
    @SerializedName("default")
    public String defaultValue;

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !FormField.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final FormField other = (FormField) obj;
        return Objects.equal(key, other.key);
    }

    @Override
    public String toString() {
        return String.format("key: %s;", key);
    }

}
