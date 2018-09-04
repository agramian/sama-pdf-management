package com.abtingramian.service.common.di.module;

import com.abtingramian.service.common.di.component.AppComponent;
import com.abtingramian.service.common.di.scope.AppScope;
import com.abtingramian.service.common.route.BaseController;
import com.abtingramian.service.route.form.FormController;
import com.google.common.collect.ImmutableList;
import dagger.Module;
import dagger.Provides;

import java.util.List;

/**
 * This is a Dagger module used to provide several dependencies to the {@link AppComponent}.
 */
@Module
public final class RoutesModule {

    @Provides
    @AppScope
    List<BaseController> providesControllers(final FormController formController) {
        return new ImmutableList.Builder<BaseController>()
                .add(formController)
                .build();
    }

}
