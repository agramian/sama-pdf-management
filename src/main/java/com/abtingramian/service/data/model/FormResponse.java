package com.abtingramian.service.data.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class FormResponse implements Responsive {

    @Expose
    public List<Form> forms;

}
