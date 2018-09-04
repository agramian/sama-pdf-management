package com.abtingramian.service.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This is a model representing a input box object.
 */
public class InputBox {

    @SerializedName("guid")
    @Expose
    public String guid;
    @SerializedName("rect")
    @Expose
    public Rect rect;
    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("field_guid")
    @Expose
    public String fieldGuid;

}
