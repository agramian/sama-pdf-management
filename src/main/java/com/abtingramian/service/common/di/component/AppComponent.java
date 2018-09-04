package com.abtingramian.service.common.di.component;

import com.abtingramian.service.Application;
import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.di.module.AppModule;
import com.abtingramian.service.common.di.module.DbModule;
import com.abtingramian.service.data.api.di.ApiModule;
import com.abtingramian.service.data.source.FormRepository;
import com.abtingramian.service.data.source.di.DataSourceModule;
import com.abtingramian.service.route.di.component.RoutesComponent;
import com.google.gson.Gson;
import dagger.Component;
import okhttp3.OkHttpClient;
import org.flywaydb.core.Flyway;

import javax.inject.Singleton;

/**
 * This is the main Dagger component which provides access to all modules for dependency injection
 * throughout the application.
 * <P>
 * Even though Dagger allows annotating a {@link Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link Application}.
 * In Dagger, an unscoped component cannot depend on a scoped component. Additionally, a component with a specific scope
 * cannot have a sub component with the same scope.
 */
@Singleton
@Component(
        modules = {
                AppModule.class, DbModule.class, DataSourceModule.class, ApiModule.class
        }
)
public interface AppComponent {

    Config config();

    Flyway flyway();

    Gson gson();

    OkHttpClient okHttpClient();

    FormRepository formRepository();

    RoutesComponent plus();

}
