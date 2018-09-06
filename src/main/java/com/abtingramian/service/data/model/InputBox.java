package com.abtingramian.service.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This is a model representing a input box object.
 */
public class InputBox {

    @Expose
    public String guid;
    @Expose
    public Rect rect;
    @Expose
    public Integer page;
    @SerializedName("field_guid")
    @Expose
    public String fieldGuid;

}
