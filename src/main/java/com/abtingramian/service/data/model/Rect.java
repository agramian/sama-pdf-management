package com.abtingramian.service.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This is a model representing a rect object.
 */
public class Rect {

    @SerializedName("x")
    @Expose
    public Integer x;
    @SerializedName("y")
    @Expose
    public Integer y;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;

}
