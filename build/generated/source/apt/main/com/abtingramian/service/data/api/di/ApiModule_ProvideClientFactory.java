package com.abtingramian.service.data.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideClientFactory implements Factory<OkHttpClient> {
  private final ApiModule module;

  private final Provider<Interceptor> loggingInterceptorProvider;

  public ApiModule_ProvideClientFactory(
      ApiModule module, Provider<Interceptor> loggingInterceptorProvider) {
    this.module = module;
    this.loggingInterceptorProvider = loggingInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideInstance(module, loggingInterceptorProvider);
  }

  public static OkHttpClient provideInstance(
      ApiModule module, Provider<Interceptor> loggingInterceptorProvider) {
    return proxyProvideClient(module, loggingInterceptorProvider.get());
  }

  public static ApiModule_ProvideClientFactory create(
      ApiModule module, Provider<Interceptor> loggingInterceptorProvider) {
    return new ApiModule_ProvideClientFactory(module, loggingInterceptorProvider);
  }

  public static OkHttpClient proxyProvideClient(
      ApiModule instance, Interceptor loggingInterceptor) {
    return Preconditions.checkNotNull(
        instance.provideClient(loggingInterceptor),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
