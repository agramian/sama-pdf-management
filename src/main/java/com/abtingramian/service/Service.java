package com.abtingramian.service;

import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.config.SparkConfig;
import com.abtingramian.service.common.di.component.AppComponent;
import com.abtingramian.service.common.di.component.DaggerAppComponent;
import com.abtingramian.service.common.di.module.AppModule;
import com.abtingramian.service.common.middleware.Errors;
import com.abtingramian.service.common.middleware.Filters;
import com.abtingramian.service.common.route.BaseController;
import com.abtingramian.service.common.route.Routes;
import com.abtingramian.service.common.util.Constants;
import com.google.gson.Gson;
import org.flywaydb.core.Flyway;

import javax.inject.Inject;
import java.util.List;

import static spark.Spark.awaitInitialization;
import static spark.Spark.staticFiles;

public class Service {

    public AppComponent appComponent;
    @Inject
    SparkConfig sparkConfig;
    @Inject
    Config config;
    @Inject
    Flyway flyway;
    @Inject
    Gson gson;
    @Inject
    List<BaseController> controllers;

    public Service(final String environment) {
        // initialize app component dependency
        initAppComponent(environment);
        // run migrations
        flyway.migrate();
        // configuration
        sparkConfig.configure();
        // global errors
        Errors.addGlobalErrorHandling(gson);
        // static file serving
        staticFiles.location(Constants.STATIC_FILE_DIRECTORY);
        staticFiles.expireTime(Constants.STATIC_FILE_CACHE_EXPIRE_TIME);
        // global filters
        Filters.addGlobalFilters(config);
        // set up routes
        Routes.addGlobalRoutes();
        for (BaseController controller : controllers) {
            controller.defineEndpoints();
            controller.defineFilters();
        }
        // wait until the server is ready to handle requests
        awaitInitialization();
    }

    private void initAppComponent(final String environment) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(environment))
                .build();
        appComponent.plus().inject(this);
    }

}
