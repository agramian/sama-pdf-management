package com.abtingramian.service.route.form;

import com.abtingramian.service.common.middleware.Errors;
import com.abtingramian.service.common.route.BaseController;
import com.abtingramian.service.common.route.BaseService;
import com.abtingramian.service.data.model.Form;
import com.abtingramian.service.data.model.Responsive;
import spark.Request;
import spark.Response;

import javax.annotation.Nonnull;

public interface FormContract {

    interface Controller extends BaseController<Service> {

        void processForm(@Nonnull final Form form);

    }

    interface Service extends BaseService {

        Responsive getForm(final Request request, final Response response) throws Errors.RequestException;

        Responsive fillOutForm(final Request request, final Response response) throws Errors.RequestException;

    }

}
