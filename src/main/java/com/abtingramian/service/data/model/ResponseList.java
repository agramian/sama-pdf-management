package com.abtingramian.service.data.model;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a model representing a generic list response object.
 */
public class ResponseList<T> extends ArrayList<T> implements Responsive {

    public ResponseList(@Nonnull final List<T> list) {
        addAll(list);
    }

}
