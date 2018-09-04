package com.abtingramian.service.common.di.module;

import com.abtingramian.service.Application;
import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.config.SparkConfig;
import com.abtingramian.service.common.util.ResourceProvider;
import com.abtingramian.service.common.util.UUIDProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * This is a Dagger module used to provide several dependencies to the {@link com.abtingramian.service.common.di.component.AppComponent}.
 */
@Module
public final class AppModule {

    private final String environment;

    public AppModule(final String environment) {
        this.environment = environment;
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    Logger providesLogger() {
        return Logger.getLogger(Application.class.getName());
    }

    @Provides
    @Singleton
    Config providesConfig(final Gson gson) {
        try {
            final BufferedReader reader = Files.newBufferedReader(Paths.get("config", environment + ".json"));
            final Config config = gson.fromJson(reader, Config.class);
            reader.close();
            return config;
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Provides
    @Singleton
    SparkConfig providesSparkConfig(final Config config, final Logger logger) {
        return new SparkConfig(config, logger);
    }

    @Provides
    @Singleton
    UUIDProvider providesUUIDProvider() {
        return new UUIDProvider();
    }

    @Provides
    @Singleton
    ResourceProvider providesResourceProvider(final Gson gson) {
        return new ResourceProvider(gson);
    }

}
