package com.abtingramian.service.data.api.di;

import com.abtingramian.service.common.config.Config;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvidesLoggingInterceptorFactory implements Factory<Interceptor> {
  private final ApiModule module;

  private final Provider<Config> configProvider;

  public ApiModule_ProvidesLoggingInterceptorFactory(
      ApiModule module, Provider<Config> configProvider) {
    this.module = module;
    this.configProvider = configProvider;
  }

  @Override
  public Interceptor get() {
    return provideInstance(module, configProvider);
  }

  public static Interceptor provideInstance(ApiModule module, Provider<Config> configProvider) {
    return proxyProvidesLoggingInterceptor(module, configProvider.get());
  }

  public static ApiModule_ProvidesLoggingInterceptorFactory create(
      ApiModule module, Provider<Config> configProvider) {
    return new ApiModule_ProvidesLoggingInterceptorFactory(module, configProvider);
  }

  public static Interceptor proxyProvidesLoggingInterceptor(ApiModule instance, Config config) {
    return Preconditions.checkNotNull(
        instance.providesLoggingInterceptor(config),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
