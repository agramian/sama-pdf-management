package com.abtingramian.service.common.di.module;

import com.abtingramian.service.common.route.BaseController;
import com.abtingramian.service.route.form.FormController;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RoutesModule_ProvidesControllersFactory
    implements Factory<List<BaseController>> {
  private final RoutesModule module;

  private final Provider<FormController> formControllerProvider;

  public RoutesModule_ProvidesControllersFactory(
      RoutesModule module, Provider<FormController> formControllerProvider) {
    this.module = module;
    this.formControllerProvider = formControllerProvider;
  }

  @Override
  public List<BaseController> get() {
    return provideInstance(module, formControllerProvider);
  }

  public static List<BaseController> provideInstance(
      RoutesModule module, Provider<FormController> formControllerProvider) {
    return proxyProvidesControllers(module, formControllerProvider.get());
  }

  public static RoutesModule_ProvidesControllersFactory create(
      RoutesModule module, Provider<FormController> formControllerProvider) {
    return new RoutesModule_ProvidesControllersFactory(module, formControllerProvider);
  }

  public static List<BaseController> proxyProvidesControllers(
      RoutesModule instance, FormController formController) {
    return Preconditions.checkNotNull(
        instance.providesControllers(formController),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
