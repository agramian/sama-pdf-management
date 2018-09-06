package com.abtingramian.service.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This is a model representing a Form config object.
 */
public class FormConfig implements Responsive {

    @SerializedName("file_name")
    @Expose
    public String fileName;
    @SerializedName("input_boxes")
    @Expose
    public List<InputBox> inputBoxes = null;
    @SerializedName("number_of_pages")
    @Expose
    public Integer numberOfPages;
    @SerializedName("page_height")
    @Expose
    public Integer pageHeight;
    @SerializedName("page_width")
    @Expose
    public Integer pageWidth;

}
