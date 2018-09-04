package com.abtingramian.service.common.di.module;

import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.di.component.AppComponent;
import com.abtingramian.service.common.test.MockConstants;
import dagger.Module;
import dagger.Provides;
import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGSimpleDataSource;
import org.sql2o.Sql2o;

import javax.inject.Singleton;
import javax.sql.DataSource;

/**
 * This is a Dagger module used to provide several dependencies to the {@link AppComponent}.
 */
@Module
public final class DbModule {

    @Provides
    @Singleton
    DataSource providesDatasource(final Config config) {
        return new PGSimpleDataSource();
    }

    @Provides
    @Singleton
    Flyway providesFlyway(final DataSource dataSource) {
        return MockConstants.getInstance().flyway;
    }

    @Provides
    @Singleton
    Sql2o providesSql2o(final DataSource dataSource) {
        return MockConstants.getInstance().sql2o;
    }

}
