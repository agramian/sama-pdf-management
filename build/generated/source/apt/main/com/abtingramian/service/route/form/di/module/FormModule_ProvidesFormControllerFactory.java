package com.abtingramian.service.route.form.di.module;

import com.abtingramian.service.route.form.FormController;
import com.abtingramian.service.route.form.FormService;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FormModule_ProvidesFormControllerFactory implements Factory<FormController> {
  private final FormModule module;

  private final Provider<Gson> gsonProvider;

  private final Provider<FormService> serviceProvider;

  public FormModule_ProvidesFormControllerFactory(
      FormModule module, Provider<Gson> gsonProvider, Provider<FormService> serviceProvider) {
    this.module = module;
    this.gsonProvider = gsonProvider;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public FormController get() {
    return provideInstance(module, gsonProvider, serviceProvider);
  }

  public static FormController provideInstance(
      FormModule module, Provider<Gson> gsonProvider, Provider<FormService> serviceProvider) {
    return proxyProvidesFormController(module, gsonProvider.get(), serviceProvider.get());
  }

  public static FormModule_ProvidesFormControllerFactory create(
      FormModule module, Provider<Gson> gsonProvider, Provider<FormService> serviceProvider) {
    return new FormModule_ProvidesFormControllerFactory(module, gsonProvider, serviceProvider);
  }

  public static FormController proxyProvidesFormController(
      FormModule instance, Gson gson, FormService service) {
    return Preconditions.checkNotNull(
        instance.providesFormController(gson, service),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
