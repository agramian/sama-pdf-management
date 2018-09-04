package com.abtingramian.service.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharactersResponse implements Responsive {

    @Expose
    @SerializedName("results")
    public List<Character> characters;

}
