package com.abtingramian.service.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EpisodesResponse implements Responsive {

    @SerializedName("results")
    public List<Episode> episodes;

}
