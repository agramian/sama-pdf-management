package com.abtingramian.service.common.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import javax.sql.DataSource;
import org.sql2o.Sql2o;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DbModule_ProvidesSql2oFactory implements Factory<Sql2o> {
  private final DbModule module;

  private final Provider<DataSource> dataSourceProvider;

  public DbModule_ProvidesSql2oFactory(DbModule module, Provider<DataSource> dataSourceProvider) {
    this.module = module;
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public Sql2o get() {
    return provideInstance(module, dataSourceProvider);
  }

  public static Sql2o provideInstance(DbModule module, Provider<DataSource> dataSourceProvider) {
    return proxyProvidesSql2o(module, dataSourceProvider.get());
  }

  public static DbModule_ProvidesSql2oFactory create(
      DbModule module, Provider<DataSource> dataSourceProvider) {
    return new DbModule_ProvidesSql2oFactory(module, dataSourceProvider);
  }

  public static Sql2o proxyProvidesSql2o(DbModule instance, DataSource dataSource) {
    return Preconditions.checkNotNull(
        instance.providesSql2o(dataSource),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
