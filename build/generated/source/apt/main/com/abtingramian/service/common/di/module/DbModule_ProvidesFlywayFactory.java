package com.abtingramian.service.common.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DbModule_ProvidesFlywayFactory implements Factory<Flyway> {
  private final DbModule module;

  private final Provider<DataSource> dataSourceProvider;

  public DbModule_ProvidesFlywayFactory(DbModule module, Provider<DataSource> dataSourceProvider) {
    this.module = module;
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public Flyway get() {
    return provideInstance(module, dataSourceProvider);
  }

  public static Flyway provideInstance(DbModule module, Provider<DataSource> dataSourceProvider) {
    return proxyProvidesFlyway(module, dataSourceProvider.get());
  }

  public static DbModule_ProvidesFlywayFactory create(
      DbModule module, Provider<DataSource> dataSourceProvider) {
    return new DbModule_ProvidesFlywayFactory(module, dataSourceProvider);
  }

  public static Flyway proxyProvidesFlyway(DbModule instance, DataSource dataSource) {
    return Preconditions.checkNotNull(
        instance.providesFlyway(dataSource),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
