package com.abtingramian.service.data.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * This is a model representing a Form config object.
 */
public class FormConfigElement implements Responsive {

    @Expose
    public String key;
    @Expose
    public String title;
    @Expose
    public String type;
    @Expose
    @SerializedName("default")
    public String defaultvalue;
    @Expose
    public Date createdAt;
    @Expose
    public Date updatedAt;

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !FormConfigElement.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final FormConfigElement other = (FormConfigElement) obj;
        return Objects.equal(key, other.key);
    }

    @Override
    public String toString() {
        return String.format("key: %s;", key);
    }

}