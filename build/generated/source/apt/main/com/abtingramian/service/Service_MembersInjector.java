package com.abtingramian.service;

import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.config.SparkConfig;
import com.abtingramian.service.common.route.BaseController;
import com.abtingramian.service.common.util.ResourceProvider;
import com.google.gson.Gson;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.flywaydb.core.Flyway;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Service_MembersInjector implements MembersInjector<Service> {
  private final Provider<SparkConfig> sparkConfigProvider;

  private final Provider<Config> configProvider;

  private final Provider<Flyway> flywayProvider;

  private final Provider<Gson> gsonProvider;

  private final Provider<List<BaseController>> controllersProvider;

  private final Provider<ResourceProvider> resourceProvider;

  public Service_MembersInjector(
      Provider<SparkConfig> sparkConfigProvider,
      Provider<Config> configProvider,
      Provider<Flyway> flywayProvider,
      Provider<Gson> gsonProvider,
      Provider<List<BaseController>> controllersProvider,
      Provider<ResourceProvider> resourceProvider) {
    this.sparkConfigProvider = sparkConfigProvider;
    this.configProvider = configProvider;
    this.flywayProvider = flywayProvider;
    this.gsonProvider = gsonProvider;
    this.controllersProvider = controllersProvider;
    this.resourceProvider = resourceProvider;
  }

  public static MembersInjector<Service> create(
      Provider<SparkConfig> sparkConfigProvider,
      Provider<Config> configProvider,
      Provider<Flyway> flywayProvider,
      Provider<Gson> gsonProvider,
      Provider<List<BaseController>> controllersProvider,
      Provider<ResourceProvider> resourceProvider) {
    return new Service_MembersInjector(
        sparkConfigProvider,
        configProvider,
        flywayProvider,
        gsonProvider,
        controllersProvider,
        resourceProvider);
  }

  @Override
  public void injectMembers(Service instance) {
    injectSparkConfig(instance, sparkConfigProvider.get());
    injectConfig(instance, configProvider.get());
    injectFlyway(instance, flywayProvider.get());
    injectGson(instance, gsonProvider.get());
    injectControllers(instance, controllersProvider.get());
    injectResourceProvider(instance, resourceProvider.get());
  }

  public static void injectSparkConfig(Service instance, SparkConfig sparkConfig) {
    instance.sparkConfig = sparkConfig;
  }

  public static void injectConfig(Service instance, Config config) {
    instance.config = config;
  }

  public static void injectFlyway(Service instance, Flyway flyway) {
    instance.flyway = flyway;
  }

  public static void injectGson(Service instance, Gson gson) {
    instance.gson = gson;
  }

  public static void injectControllers(Service instance, List<BaseController> controllers) {
    instance.controllers = controllers;
  }

  public static void injectResourceProvider(Service instance, ResourceProvider resourceProvider) {
    instance.resourceProvider = resourceProvider;
  }
}
