package com.abtingramian.service.common.di.module;

import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.config.SparkConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.logging.Logger;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvidesSparkConfigFactory implements Factory<SparkConfig> {
  private final AppModule module;

  private final Provider<Config> configProvider;

  private final Provider<Logger> loggerProvider;

  public AppModule_ProvidesSparkConfigFactory(
      AppModule module, Provider<Config> configProvider, Provider<Logger> loggerProvider) {
    this.module = module;
    this.configProvider = configProvider;
    this.loggerProvider = loggerProvider;
  }

  @Override
  public SparkConfig get() {
    return provideInstance(module, configProvider, loggerProvider);
  }

  public static SparkConfig provideInstance(
      AppModule module, Provider<Config> configProvider, Provider<Logger> loggerProvider) {
    return proxyProvidesSparkConfig(module, configProvider.get(), loggerProvider.get());
  }

  public static AppModule_ProvidesSparkConfigFactory create(
      AppModule module, Provider<Config> configProvider, Provider<Logger> loggerProvider) {
    return new AppModule_ProvidesSparkConfigFactory(module, configProvider, loggerProvider);
  }

  public static SparkConfig proxyProvidesSparkConfig(
      AppModule instance, Config config, Logger logger) {
    return Preconditions.checkNotNull(
        instance.providesSparkConfig(config, logger),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
