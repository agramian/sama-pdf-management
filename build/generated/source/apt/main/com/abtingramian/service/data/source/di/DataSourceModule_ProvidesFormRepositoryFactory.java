package com.abtingramian.service.data.source.di;

import com.abtingramian.service.common.util.UUIDProvider;
import com.abtingramian.service.data.source.FormRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.sql2o.Sql2o;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataSourceModule_ProvidesFormRepositoryFactory
    implements Factory<FormRepository> {
  private final DataSourceModule module;

  private final Provider<Sql2o> sql2oProvider;

  private final Provider<UUIDProvider> uuidProvider;

  public DataSourceModule_ProvidesFormRepositoryFactory(
      DataSourceModule module, Provider<Sql2o> sql2oProvider, Provider<UUIDProvider> uuidProvider) {
    this.module = module;
    this.sql2oProvider = sql2oProvider;
    this.uuidProvider = uuidProvider;
  }

  @Override
  public FormRepository get() {
    return provideInstance(module, sql2oProvider, uuidProvider);
  }

  public static FormRepository provideInstance(
      DataSourceModule module, Provider<Sql2o> sql2oProvider, Provider<UUIDProvider> uuidProvider) {
    return proxyProvidesFormRepository(module, sql2oProvider.get(), uuidProvider.get());
  }

  public static DataSourceModule_ProvidesFormRepositoryFactory create(
      DataSourceModule module, Provider<Sql2o> sql2oProvider, Provider<UUIDProvider> uuidProvider) {
    return new DataSourceModule_ProvidesFormRepositoryFactory(module, sql2oProvider, uuidProvider);
  }

  public static FormRepository proxyProvidesFormRepository(
      DataSourceModule instance, Sql2o sql2o, UUIDProvider uuidProvider) {
    return Preconditions.checkNotNull(
        instance.providesFormRepository(sql2o, uuidProvider),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
