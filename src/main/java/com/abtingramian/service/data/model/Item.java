package com.abtingramian.service.data.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * This is a model representing a form item object.
 */
public class Item {

    @Expose
    public String title;
    @Expose
    public String type;
    @Expose
    public List<Option> options;
    @Expose
    public String key;
    @Expose
    public String displayIf;

}
