package com.abtingramian.service.route.form;

import com.abtingramian.service.common.route.Routes;
import com.abtingramian.service.data.model.Form;
import com.google.gson.Gson;

import javax.annotation.Nonnull;

import static spark.Spark.get;
import static spark.Spark.post;

public class FormController implements FormContract.Controller {

    private final Gson gson;
    private final FormContract.Service service;

    public FormController(final Gson gson, final FormService service) {
        this.gson = gson;
        this.service = service;
    }

    @Override
    public void defineEndpoints() {
        get(Routes.FORM_GET, service::getForm, gson::toJson);
        post(Routes.FORM_POST, service::fillOutForm, gson::toJson);
    }

    @Override
    public void defineFilters() {
    }

    @Override
    public void processForm(@Nonnull final Form form) {

    }
}
