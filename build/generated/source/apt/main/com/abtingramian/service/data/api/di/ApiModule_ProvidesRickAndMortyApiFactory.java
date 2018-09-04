package com.abtingramian.service.data.api.di;

import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.data.api.RickAndMortyApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvidesRickAndMortyApiFactory implements Factory<RickAndMortyApi> {
  private final ApiModule module;

  private final Provider<OkHttpClient> clientProvider;

  private final Provider<Gson> gsonProvider;

  private final Provider<Config> configProvider;

  public ApiModule_ProvidesRickAndMortyApiFactory(
      ApiModule module,
      Provider<OkHttpClient> clientProvider,
      Provider<Gson> gsonProvider,
      Provider<Config> configProvider) {
    this.module = module;
    this.clientProvider = clientProvider;
    this.gsonProvider = gsonProvider;
    this.configProvider = configProvider;
  }

  @Override
  public RickAndMortyApi get() {
    return provideInstance(module, clientProvider, gsonProvider, configProvider);
  }

  public static RickAndMortyApi provideInstance(
      ApiModule module,
      Provider<OkHttpClient> clientProvider,
      Provider<Gson> gsonProvider,
      Provider<Config> configProvider) {
    return proxyProvidesRickAndMortyApi(
        module, clientProvider.get(), gsonProvider.get(), configProvider.get());
  }

  public static ApiModule_ProvidesRickAndMortyApiFactory create(
      ApiModule module,
      Provider<OkHttpClient> clientProvider,
      Provider<Gson> gsonProvider,
      Provider<Config> configProvider) {
    return new ApiModule_ProvidesRickAndMortyApiFactory(
        module, clientProvider, gsonProvider, configProvider);
  }

  public static RickAndMortyApi proxyProvidesRickAndMortyApi(
      ApiModule instance, OkHttpClient client, Gson gson, Config config) {
    return Preconditions.checkNotNull(
        instance.providesRickAndMortyApi(client, gson, config),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
