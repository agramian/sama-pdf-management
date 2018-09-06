package com.abtingramian.service.data.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * This is a model representing a Form element object.
 */
public class FormElement implements Responsive {

    @Expose
    public String title;
    @Expose
    public List<FormField> items;

}
