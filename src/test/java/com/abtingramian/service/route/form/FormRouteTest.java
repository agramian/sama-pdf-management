package com.abtingramian.service.route.form;


import com.abtingramian.service.common.middleware.Errors;
import com.abtingramian.service.data.model.BaseResponse;
import com.abtingramian.service.data.model.Error;
import com.abtingramian.service.data.model.Form;
import com.abtingramian.service.data.model.FormElement;
import com.google.common.collect.ImmutableList;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.postgresql.util.PGobject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FormRouteTest extends BaseFormRouteTest {

    @Test
    public void test_get_form_missing_all_fields() throws Exception {
        // trigger and assert
        assertEquals(new BaseResponse.Builder().error(new Error("all", new Errors.MissingQueryParameterException())).build(),
                service.getForm(request, response));
    }

    @Test
    public void test_get_form() throws Exception {
        // mock
        final Form form = new Form();
        form.id = 0;
        form.state = "CA";
        form.formFieldConfig = new PGobject();
        form.formFieldConfig.setType("json");
        form.formFieldConfig.setValue(resourceProvider.getResource("form/priority_health/form_field_config.json"));
        form.formElementConfig = new PGobject();
        form.formElementConfig.setType("json");
        form.formElementConfig.setValue(resourceProvider.getResource("form/priority_health/form_element_config.json"));
        when(request.queryParams("id")).thenReturn("0");
        final Form processedForm = new Form(form);
        final Type formElementListType = new TypeToken<ArrayList<FormElement>>(){}.getType();
        processedForm.formElements = resourceProvider.fromJson("form/priority_health/processed_form_config.json", formElementListType);
        when(query.executeAndFetch(Form.class)).thenReturn(new ImmutableList.Builder<Form>().add(form).build());
        // trigger
        assertEquals(new ImmutableList.Builder<Form>().add(processedForm).build(), service.getForm(request, response));
    }

}
