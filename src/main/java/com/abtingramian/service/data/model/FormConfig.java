package com.abtingramian.service.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This is a model representing a Form config object.
 */
public class FormConfig {

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
