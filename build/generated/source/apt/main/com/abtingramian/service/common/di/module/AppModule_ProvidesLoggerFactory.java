package com.abtingramian.service.common.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.logging.Logger;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvidesLoggerFactory implements Factory<Logger> {
  private final AppModule module;

  public AppModule_ProvidesLoggerFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Logger get() {
    return provideInstance(module);
  }

  public static Logger provideInstance(AppModule module) {
    return proxyProvidesLogger(module);
  }

  public static AppModule_ProvidesLoggerFactory create(AppModule module) {
    return new AppModule_ProvidesLoggerFactory(module);
  }

  public static Logger proxyProvidesLogger(AppModule instance) {
    return Preconditions.checkNotNull(
        instance.providesLogger(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
