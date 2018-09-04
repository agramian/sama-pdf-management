package com.abtingramian.service.common.di.module;

import com.abtingramian.service.common.config.Config;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import javax.sql.DataSource;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DbModule_ProvidesDatasourceFactory implements Factory<DataSource> {
  private final DbModule module;

  private final Provider<Config> configProvider;

  public DbModule_ProvidesDatasourceFactory(DbModule module, Provider<Config> configProvider) {
    this.module = module;
    this.configProvider = configProvider;
  }

  @Override
  public DataSource get() {
    return provideInstance(module, configProvider);
  }

  public static DataSource provideInstance(DbModule module, Provider<Config> configProvider) {
    return proxyProvidesDatasource(module, configProvider.get());
  }

  public static DbModule_ProvidesDatasourceFactory create(
      DbModule module, Provider<Config> configProvider) {
    return new DbModule_ProvidesDatasourceFactory(module, configProvider);
  }

  public static DataSource proxyProvidesDatasource(DbModule instance, Config config) {
    return Preconditions.checkNotNull(
        instance.providesDatasource(config),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
