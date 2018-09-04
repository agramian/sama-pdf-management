package com.abtingramian.service.common.di.module;

import com.abtingramian.service.common.config.Config;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvidesConfigFactory implements Factory<Config> {
  private final AppModule module;

  private final Provider<Gson> gsonProvider;

  public AppModule_ProvidesConfigFactory(AppModule module, Provider<Gson> gsonProvider) {
    this.module = module;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Config get() {
    return provideInstance(module, gsonProvider);
  }

  public static Config provideInstance(AppModule module, Provider<Gson> gsonProvider) {
    return proxyProvidesConfig(module, gsonProvider.get());
  }

  public static AppModule_ProvidesConfigFactory create(
      AppModule module, Provider<Gson> gsonProvider) {
    return new AppModule_ProvidesConfigFactory(module, gsonProvider);
  }

  public static Config proxyProvidesConfig(AppModule instance, Gson gson) {
    return Preconditions.checkNotNull(
        instance.providesConfig(gson), "Cannot return null from a non-@Nullable @Provides method");
  }
}
