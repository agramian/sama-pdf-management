package com.abtingramian.service.data.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * This is a model representing a Character object.
 */
public class Character implements Responsive {

    @Expose
    public Integer id;
    @Expose
    public String name;
    public Date createdAt;
    public Date updatedAt;

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !Character.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Character other = (Character) obj;
        return Objects.equal(id, other.id) && Objects.equal(name, other.name);
    }

    @Override
    public String toString() {
        return String.format("id: %s;name: %s", id, name);
    }

}
