package com.abtingramian.service.route.form.di.module;

import com.abtingramian.service.data.source.FormRepository;
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
public final class FormModule_ProvidesFormServiceFactory implements Factory<FormService> {
  private final FormModule module;

  private final Provider<Gson> gsonProvider;

  private final Provider<FormRepository> formRepositoryProvider;

  public FormModule_ProvidesFormServiceFactory(
      FormModule module,
      Provider<Gson> gsonProvider,
      Provider<FormRepository> formRepositoryProvider) {
    this.module = module;
    this.gsonProvider = gsonProvider;
    this.formRepositoryProvider = formRepositoryProvider;
  }

  @Override
  public FormService get() {
    return provideInstance(module, gsonProvider, formRepositoryProvider);
  }

  public static FormService provideInstance(
      FormModule module,
      Provider<Gson> gsonProvider,
      Provider<FormRepository> formRepositoryProvider) {
    return proxyProvidesFormService(module, gsonProvider.get(), formRepositoryProvider.get());
  }

  public static FormModule_ProvidesFormServiceFactory create(
      FormModule module,
      Provider<Gson> gsonProvider,
      Provider<FormRepository> formRepositoryProvider) {
    return new FormModule_ProvidesFormServiceFactory(module, gsonProvider, formRepositoryProvider);
  }

  public static FormService proxyProvidesFormService(
      FormModule instance, Gson gson, FormRepository formRepository) {
    return Preconditions.checkNotNull(
        instance.providesFormService(gson, formRepository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
