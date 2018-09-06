package com.abtingramian.service.data.model;

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

}
