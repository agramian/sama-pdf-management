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

    public Form() {
    }

    public Form(final Form form) {
        this.id = form.id;
        this.createdAt = form.createdAt;
        this.updatedAt = form.updatedAt;
        this.state = form.state;
        this.payerId = form.payerId;
        this.planId = form.planId;
        this.medicationId = form.medicationId;
        this.pdfFilePath = form.pdfFilePath;
        this.formConfig = form.formConfig;
        this.formElements = form.formElements;
        this.formElementConfig = form.formElementConfig;
        this.formFieldConfig = form.formFieldConfig;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !Form.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Form other = (Form) obj;
        return Objects.equal(id, other.id)
                && Objects.equal(state, other.state)
                && Objects.equal(payerId, other.payerId)
                && Objects.equal(planId, other.planId)
                && Objects.equal(medicationId, other.medicationId)
                && Objects.equal(pdfFilePath, other.pdfFilePath)
                && Objects.equal(formConfig, other.formConfig)
                && Objects.equal(formElements, other.formElements)
                && Objects.equal(formElementConfig, other.formElementConfig)
                && Objects.equal(formFieldConfig, other.formFieldConfig);
    }

    @Override
    public String toString() {
        return String.format("id: %s;", id);
    }

}
