package com.abtingramian.service.data.source.di;

import com.abtingramian.service.common.di.component.AppComponent;
import com.abtingramian.service.common.util.UUIDProvider;
import com.abtingramian.service.data.source.FormRepository;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import org.sql2o.Sql2o;

import javax.inject.Singleton;

/**
 * This is a Dagger module used to provide data source dependencies to the {@link AppComponent}.
 */
@Module
public final class DataSourceModule {

    @Provides
    @Singleton
    FormRepository providesFormRepository(final Sql2o sql2o, final UUIDProvider uuidProvider, final Gson gson) {
        return new FormRepository(sql2o, uuidProvider, gson);
    }

}
