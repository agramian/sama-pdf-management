package com.abtingramian.service.route.form.di.module;

import com.abtingramian.service.common.di.module.RoutesModule;
import com.abtingramian.service.common.di.scope.AppScope;
import com.abtingramian.service.data.source.FormRepository;
import com.abtingramian.service.route.form.FormController;
import com.abtingramian.service.route.form.FormService;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module used to provide several dependencies to the {@link RoutesModule}.
 */
@Module
public final class FormModule {

    @Provides
    @AppScope
    FormController providesFormController(final Gson gson, final FormService service) {
        return new FormController(gson, service);
    }

    @Provides
    @AppScope
    FormService providesFormService(final Gson gson, final FormRepository formRepository) {
        return new FormService(gson, formRepository);
    }

}
