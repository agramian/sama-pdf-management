package com.abtingramian.service.data.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.postgresql.util.PGobject;

import java.util.Date;
import java.util.List;

/**
 * This is a model representing a Form object.
 */
public class Form implements Responsive {

    @Expose
    public Integer id;
    public Date createdAt;
    public Date updatedAt;

    @Expose
    public String state;
    @Expose
    public Integer payerId;
    @Expose
    public Integer planId;
    @Expose
    public Integer medicationId;
    public String pdfFilePath;
    public PGobject formConfig;
    @Expose
    @SerializedName("formConfig")
    public List<FormElement> formElements;
    public PGobject formElementConfig;
    public PGobject formFieldConfig;

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
