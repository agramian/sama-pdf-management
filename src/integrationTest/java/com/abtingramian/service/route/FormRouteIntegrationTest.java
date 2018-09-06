package com.abtingramian.service.route;

import com.abtingramian.service.common.middleware.Errors;
import com.abtingramian.service.common.route.Routes;
import com.abtingramian.service.common.test.BaseRouteIntegrationTest;
import com.abtingramian.service.common.util.Constants;
import com.abtingramian.service.data.model.BaseResponse;
import com.abtingramian.service.data.model.Error;
import com.abtingramian.service.data.model.Form;
import com.abtingramian.service.data.model.FormElement;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.reflect.TypeToken;
import javafx.util.Pair;
import org.junit.Test;
import org.postgresql.util.PGobject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FormRouteIntegrationTest extends BaseRouteIntegrationTest {

    @Test
    public void test_get_form_missing_query_params() throws Exception {
        // trigger
        final TestResponse<BaseResponse> response = get(Routes.FORM_GET, null, BaseResponse.class);
        // verify
        assertEquals(400, response.response.code());
        assertFalse(response.response.isSuccessful());
        assertEquals(new BaseResponse.Builder().error(new Error("all", new Errors.MissingQueryParameterException())).build(), response.responseModel);
    }

    @Test
    public void test_get_form() throws Exception {
        // mock
        final Form form = new Form();
        form.id = 0;
        form.state = "CA";
        form.payerId = 0;
        form.formFieldConfig = new PGobject();
        form.formFieldConfig.setType("json");
        form.formFieldConfig.setValue(resourceProvider.getResource("form/priority_health/form_field_config.json"));
        form.formElementConfig = new PGobject();
        form.formElementConfig.setType("json");
        form.formElementConfig.setValue(resourceProvider.getResource("form/priority_health/form_element_config.json"));
        form.pdfFilePath = "form/priority_health/form.pdf";
        // insert data
        final Pair<Constants.PSQL_ERROR_CODE, Form> insertFormResult = appComponent.formRepository().createForm(form);
        assertEquals(insertFormResult.getKey(), Constants.PSQL_ERROR_CODE.SUCCESSFUL_COMPLETION);
        // set unexposed fields to null on inserted form so comparison passes since those values are not returned with actual request
        form.formFieldConfig = null;
        form.formElementConfig = null;
        form.pdfFilePath = null;
        // create processed form from validation file for validation
        final Form processedForm = new Form(form);
        final Type formElementListType = new TypeToken<ArrayList<FormElement>>(){}.getType();
        processedForm.formElements = resourceProvider.fromJson("form/priority_health/processed_form_config.json", formElementListType);
        // trigger
        final Type formListType = new TypeToken<ArrayList<Form>>(){}.getType();
        final TestResponse<BaseResponse> response = get(Routes.FORM_GET,
                new ImmutableMap.Builder<String, String>().put("id", "0").build(),
                formListType);
        // verify
        assertEquals(200, response.response.code());
        assertTrue(response.response.isSuccessful());
        assertEquals(new ImmutableList.Builder<Form>().add(processedForm).build(), response.responseModel);
    }

}
