package com.abtingramian.service.common.di.module;

import com.abtingramian.service.common.util.UUIDProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvidesUUIDProviderFactory implements Factory<UUIDProvider> {
  private final AppModule module;

  public AppModule_ProvidesUUIDProviderFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public UUIDProvider get() {
    return provideInstance(module);
  }

  public static UUIDProvider provideInstance(AppModule module) {
    return proxyProvidesUUIDProvider(module);
  }

  public static AppModule_ProvidesUUIDProviderFactory create(AppModule module) {
    return new AppModule_ProvidesUUIDProviderFactory(module);
  }

  public static UUIDProvider proxyProvidesUUIDProvider(AppModule instance) {
    return Preconditions.checkNotNull(
        instance.providesUUIDProvider(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
