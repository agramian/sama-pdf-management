package com.abtingramian.service.common.di.module;

import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.di.component.AppComponent;
import dagger.Module;
import dagger.Provides;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
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
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName(config.dbHost);
        dataSource.setDatabaseName(config.dbName);
        dataSource.setUser(config.dbUser);
        dataSource.setPassword(config.dbPassword);
        return dataSource;
    }

    @Provides
    @Singleton
    Flyway providesFlyway(final DataSource dataSource) {
        return new Flyway(new FluentConfiguration().dataSource(dataSource).schemas("public"));
    }

    @Provides
    @Singleton
    Sql2o providesSql2o(final DataSource dataSource) {
        return new Sql2o(dataSource);
    }

}
