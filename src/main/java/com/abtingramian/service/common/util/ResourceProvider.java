package com.abtingramian.service.common.util;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;

/**
 * This is a helper class for retrieving resources which can be injected wherever necessary helping testability.
 */
public class ResourceProvider {

    private final Gson gson;

    public ResourceProvider(final Gson gson) {
        this.gson = gson;
    }

    public String getResource(final String path) throws IOException {
        final URL url = Resources.getResource(path);
        return Resources.toString(url, Charsets.UTF_8);
    }

    public <T> T fromJson(final String path, final Class<T> classOfT) throws IOException {
        return gson.fromJson(getResource(path), classOfT);
    }

    public <T> T fromJson(final String path, final Type typeOfT) throws IOException {
        return gson.fromJson(getResource(path), typeOfT);
    }

}
