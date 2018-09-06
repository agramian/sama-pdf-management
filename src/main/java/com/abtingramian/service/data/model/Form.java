package com.abtingramian.service.data.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * This is a model representing a Form object.
 */
public class Form implements Responsive {

    @Expose
    public Integer id;
    @Expose
    public String state;
    @Expose
    public Integer payerId;
    @Expose
    public Integer planId;
    @Expose
    public Integer medicationId;
    @Expose
    public FormConfig formConfig;
    @Expose
    public String formConfigRaw;
    @Expose
    public String formConfigFormatted;
    @Expose
    public Date createdAt;
    @Expose
    public Date updatedAt;

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !Form.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Form other = (Form) obj;
        return Objects.equal(id, other.id);
    }

    @Override
    public String toString() {
        return String.format("id: %s;", id);
    }

}
