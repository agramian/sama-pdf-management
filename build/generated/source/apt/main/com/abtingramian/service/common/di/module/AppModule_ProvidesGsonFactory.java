package com.abtingramian.service.common.di.module;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvidesGsonFactory implements Factory<Gson> {
  private final AppModule module;

  public AppModule_ProvidesGsonFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Gson get() {
    return provideInstance(module);
  }

  public static Gson provideInstance(AppModule module) {
    return proxyProvidesGson(module);
  }

  public static AppModule_ProvidesGsonFactory create(AppModule module) {
    return new AppModule_ProvidesGsonFactory(module);
  }

  public static Gson proxyProvidesGson(AppModule instance) {
    return Preconditions.checkNotNull(
        instance.providesGson(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
