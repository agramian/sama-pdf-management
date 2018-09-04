package com.abtingramian.service.common.di.module;

import com.abtingramian.service.common.util.ResourceProvider;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvidesResourceProviderFactory implements Factory<ResourceProvider> {
  private final AppModule module;

  private final Provider<Gson> gsonProvider;

  public AppModule_ProvidesResourceProviderFactory(AppModule module, Provider<Gson> gsonProvider) {
    this.module = module;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public ResourceProvider get() {
    return provideInstance(module, gsonProvider);
  }

  public static ResourceProvider provideInstance(AppModule module, Provider<Gson> gsonProvider) {
    return proxyProvidesResourceProvider(module, gsonProvider.get());
  }

  public static AppModule_ProvidesResourceProviderFactory create(
      AppModule module, Provider<Gson> gsonProvider) {
    return new AppModule_ProvidesResourceProviderFactory(module, gsonProvider);
  }

  public static ResourceProvider proxyProvidesResourceProvider(AppModule instance, Gson gson) {
    return Preconditions.checkNotNull(
        instance.providesResourceProvider(gson),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
