package com.abtingramian.service.route.form;

import com.abtingramian.service.common.middleware.Errors;
import com.abtingramian.service.common.route.BaseController;
import com.abtingramian.service.common.route.BaseService;
import com.abtingramian.service.data.model.Responsive;
import spark.Request;
import spark.Response;

public interface FormContract {

    interface Controller extends BaseController<Service> {
    }

    interface Service extends BaseService {

        Responsive getForm(final Request request, final Response response) throws Errors.RequestException;

        Responsive fillOutForm(final Request request, final Response response) throws Errors.RequestException;

    }

}
