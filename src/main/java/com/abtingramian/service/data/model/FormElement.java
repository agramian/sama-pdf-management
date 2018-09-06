package com.abtingramian.service.data.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * This is a model representing a Form element object.
 */
public class FormElement implements Responsive {

    @Expose
    public String title;
    @Expose
    public List<FormField> items;

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !FormElement.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final FormElement other = (FormElement) obj;
        return Objects.equal(title, other.title) && Objects.equal(items, other.items);
    }

    @Override
    public String toString() {
        return String.format("title: %s;", title);
    }

}
