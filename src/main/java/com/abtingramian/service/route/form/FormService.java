package com.abtingramian.service.route.form;

import com.abtingramian.service.common.middleware.Errors;
import com.abtingramian.service.common.util.Constants;
import com.abtingramian.service.common.util.RequestUtil;
import com.abtingramian.service.data.model.*;
import com.abtingramian.service.data.model.Error;
import com.abtingramian.service.data.source.FormRepository;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.util.Pair;
import spark.Request;
import spark.Response;

import javax.annotation.Nonnull;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FormService implements FormContract.Service {

    private final Gson gson;
    private final FormRepository formRepository;

    public FormService(final Gson gson, final FormRepository formRepository) {
        this.gson = gson;
        this.formRepository = formRepository;
    }

    @Override
    public Responsive getForm(Request request, Response response) throws Errors.RequestException {
        // check for missing path parameters
        final List<Error> errors = new ArrayList<>();
        if (Strings.isNullOrEmpty(request.queryParams("id"))
                && Strings.isNullOrEmpty(request.queryParams("state"))
                && Strings.isNullOrEmpty(request.queryParams("planId"))
                && Strings.isNullOrEmpty(request.queryParams("medicationId"))
                && Strings.isNullOrEmpty(request.queryParams("payerId"))) {
            errors.add(new Error("all", new Errors.MissingQueryParameterException()));
        }
        if (!errors.isEmpty()) {
            // return error if any problems were found with the request
            response.status(400);
            return new BaseResponse.Builder().error(errors.toArray(new Error[errors.size()])).build();
        }
        final Pair<Constants.PSQL_ERROR_CODE, List<Form>> getFormResult = formRepository.getForm(RequestUtil.getRequestParamAsInteger(request.queryParams("id")),
                request.queryParams("state"),
                RequestUtil.getRequestParamAsInteger(request.queryParams("planId")),
                RequestUtil.getRequestParamAsInteger(request.queryParams("medicationId")),
                RequestUtil.getRequestParamAsInteger(request.queryParams("payerId")));
        switch (getFormResult.getKey()) {
            case SUCCESSFUL_COMPLETION:
                final List<Form> forms = getFormResult.getValue();
                if (forms != null) {
                    response.status(200);
                    return new ResponseList<>(processForms(forms));
                }
            default:
                response.status(500);
                return new BaseResponse.Builder().error().build();
        }
    }

    @Override
    public Responsive fillOutForm(Request request, Response response) throws Errors.RequestException {
        return null;
    }

    private List<Form> processForms(@Nonnull final List<Form> forms) {
        if (forms.isEmpty()) {
            // return immediately if the forms list is empty
            return forms;
        }
        // store field for re-use when de-serializing form config list from json
        final Type formFieldConfigListType = new TypeToken<ArrayList<FormField>>(){}.getType();
        // process each form
        forms.forEach(form -> {
            // deserialize config objects
            final List<FormField> formFieldConfig = gson.fromJson(form.formFieldConfig.getValue(), formFieldConfigListType);
            final JsonArray formElementConfig = gson.fromJson(form.formElementConfig.getValue(), JsonArray.class);
            // create map from form field config
            final Map<String, FormField> formFieldConfigMap = Maps.uniqueIndex(formFieldConfig, formField -> formField.key);
            // create a processed form elements object to construct
            final List<FormElement> formElements = new ArrayList<>();
            // iterate through the form config and interpolate the form field values where necessary
            formElementConfig.forEach(formConfigElement -> {
                // construct a form element
                final FormElement formElement = new FormElement();
                formElement.title = ((JsonObject) formConfigElement).get("title").getAsString();
                formElement.items = new ArrayList<>();
                // iterate through form config formElementItems
                ((JsonObject) formConfigElement).get("items").getAsJsonArray().forEach(formConfigElementItem -> {
                    if (formConfigElementItem instanceof JsonObject) {
                        // construct new form field
                        final FormField formField = new FormField();
                        formField.options = new ArrayList<>();
                        // parse form config element item as json object
                        final JsonObject formConfigElementItemJsonObject = ((JsonObject) formConfigElementItem);
                        // parse primitive fields
                        formField.title = formConfigElementItemJsonObject.get("title").getAsString();
                        formField.type = formConfigElementItemJsonObject.get("type").getAsString();
                        formField.key = formConfigElementItemJsonObject.has("key") ? formConfigElementItemJsonObject.get("key").getAsString() : null;
                        formField.displayIf = formConfigElementItemJsonObject.has("displayIf") ? formConfigElementItemJsonObject.get("displayIf").getAsString() : null;
                        // iterate through options
                        ((JsonObject) formConfigElementItem).get("options").getAsJsonArray().forEach(option -> {
                            // construct new option
                            final Option formFieldOption = new Option();
                            if (option instanceof JsonObject) {
                                // parse form config element item as json object
                                final JsonObject optionJsonObject = ((JsonObject) option);
                                // parse primitive fields
                                formFieldOption.key = optionJsonObject.get("key").getAsString();
                                formFieldOption.title = optionJsonObject.get("title").getAsString();
                                formFieldOption.type = optionJsonObject.get("type").getAsString();
                            } else {
                                // add new form field form matching field in config map
                                final FormField formFieldConfigItem = formFieldConfigMap.get(option.getAsString());
                                formFieldOption.key = formFieldConfigItem.key;
                                formFieldOption.title = formFieldConfigItem.title;
                                formFieldOption.type = formFieldConfigItem.type;
                            }
                            // add new option
                            formField.options.add(formFieldOption);
                        });
                        // add new form field to form element
                        formElement.items.add(formField);
                    } else {
                        // add new form field form matching field in config map
                        formElement.items.add(formFieldConfigMap.get(formConfigElementItem.getAsString()));
                    }
                });
                formElements.add(formElement);
            });
            form.formElements = formElements;
        });
        return forms;
    }

}
