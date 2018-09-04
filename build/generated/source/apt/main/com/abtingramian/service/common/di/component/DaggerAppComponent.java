package com.abtingramian.service.common.di.component;

import com.abtingramian.service.Service;
import com.abtingramian.service.Service_MembersInjector;
import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.config.SparkConfig;
import com.abtingramian.service.common.di.module.AppModule;
import com.abtingramian.service.common.di.module.AppModule_ProvidesConfigFactory;
import com.abtingramian.service.common.di.module.AppModule_ProvidesGsonFactory;
import com.abtingramian.service.common.di.module.AppModule_ProvidesLoggerFactory;
import com.abtingramian.service.common.di.module.AppModule_ProvidesResourceProviderFactory;
import com.abtingramian.service.common.di.module.AppModule_ProvidesSparkConfigFactory;
import com.abtingramian.service.common.di.module.AppModule_ProvidesUUIDProviderFactory;
import com.abtingramian.service.common.di.module.DbModule;
import com.abtingramian.service.common.di.module.DbModule_ProvidesDatasourceFactory;
import com.abtingramian.service.common.di.module.DbModule_ProvidesFlywayFactory;
import com.abtingramian.service.common.di.module.DbModule_ProvidesSql2oFactory;
import com.abtingramian.service.common.di.module.RoutesModule;
import com.abtingramian.service.common.di.module.RoutesModule_ProvidesControllersFactory;
import com.abtingramian.service.common.route.BaseController;
import com.abtingramian.service.common.util.ResourceProvider;
import com.abtingramian.service.common.util.UUIDProvider;
import com.abtingramian.service.data.api.di.ApiModule;
import com.abtingramian.service.data.api.di.ApiModule_ProvideClientFactory;
import com.abtingramian.service.data.api.di.ApiModule_ProvidesLoggingInterceptorFactory;
import com.abtingramian.service.data.source.FormRepository;
import com.abtingramian.service.data.source.di.DataSourceModule;
import com.abtingramian.service.data.source.di.DataSourceModule_ProvidesFormRepositoryFactory;
import com.abtingramian.service.route.di.component.RoutesComponent;
import com.abtingramian.service.route.form.FormController;
import com.abtingramian.service.route.form.FormService;
import com.abtingramian.service.route.form.di.module.FormModule;
import com.abtingramian.service.route.form.di.module.FormModule_ProvidesFormControllerFactory;
import com.abtingramian.service.route.form.di.module.FormModule_ProvidesFormServiceFactory;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Generated;
import javax.inject.Provider;
import javax.sql.DataSource;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.flywaydb.core.Flyway;
import org.sql2o.Sql2o;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<Gson> providesGsonProvider;

  private Provider<Config> providesConfigProvider;

  private Provider<DataSource> providesDatasourceProvider;

  private Provider<Flyway> providesFlywayProvider;

  private Provider<Interceptor> providesLoggingInterceptorProvider;

  private Provider<OkHttpClient> provideClientProvider;

  private Provider<Sql2o> providesSql2oProvider;

  private Provider<UUIDProvider> providesUUIDProvider;

  private Provider<FormRepository> providesFormRepositoryProvider;

  private Provider<Logger> providesLoggerProvider;

  private Provider<SparkConfig> providesSparkConfigProvider;

  private Provider<ResourceProvider> providesResourceProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.providesGsonProvider =
        DoubleCheck.provider(AppModule_ProvidesGsonFactory.create(builder.appModule));
    this.providesConfigProvider =
        DoubleCheck.provider(
            AppModule_ProvidesConfigFactory.create(builder.appModule, providesGsonProvider));
    this.providesDatasourceProvider =
        DoubleCheck.provider(
            DbModule_ProvidesDatasourceFactory.create(builder.dbModule, providesConfigProvider));
    this.providesFlywayProvider =
        DoubleCheck.provider(
            DbModule_ProvidesFlywayFactory.create(builder.dbModule, providesDatasourceProvider));
    this.providesLoggingInterceptorProvider =
        DoubleCheck.provider(
            ApiModule_ProvidesLoggingInterceptorFactory.create(
                builder.apiModule, providesConfigProvider));
    this.provideClientProvider =
        DoubleCheck.provider(
            ApiModule_ProvideClientFactory.create(
                builder.apiModule, providesLoggingInterceptorProvider));
    this.providesSql2oProvider =
        DoubleCheck.provider(
            DbModule_ProvidesSql2oFactory.create(builder.dbModule, providesDatasourceProvider));
    this.providesUUIDProvider =
        DoubleCheck.provider(AppModule_ProvidesUUIDProviderFactory.create(builder.appModule));
    this.providesFormRepositoryProvider =
        DoubleCheck.provider(
            DataSourceModule_ProvidesFormRepositoryFactory.create(
                builder.dataSourceModule, providesSql2oProvider, providesUUIDProvider));
    this.providesLoggerProvider =
        DoubleCheck.provider(AppModule_ProvidesLoggerFactory.create(builder.appModule));
    this.providesSparkConfigProvider =
        DoubleCheck.provider(
            AppModule_ProvidesSparkConfigFactory.create(
                builder.appModule, providesConfigProvider, providesLoggerProvider));
    this.providesResourceProvider =
        DoubleCheck.provider(
            AppModule_ProvidesResourceProviderFactory.create(
                builder.appModule, providesGsonProvider));
  }

  @Override
  public Config config() {
    return providesConfigProvider.get();
  }

  @Override
  public Flyway flyway() {
    return providesFlywayProvider.get();
  }

  @Override
  public Gson gson() {
    return providesGsonProvider.get();
  }

  @Override
  public OkHttpClient okHttpClient() {
    return provideClientProvider.get();
  }

  @Override
  public FormRepository formRepository() {
    return providesFormRepositoryProvider.get();
  }

  @Override
  public RoutesComponent plus() {
    return new RoutesComponentImpl();
  }

  public static final class Builder {
    private AppModule appModule;

    private DbModule dbModule;

    private ApiModule apiModule;

    private DataSourceModule dataSourceModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (dbModule == null) {
        this.dbModule = new DbModule();
      }
      if (apiModule == null) {
        this.apiModule = new ApiModule();
      }
      if (dataSourceModule == null) {
        this.dataSourceModule = new DataSourceModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder dbModule(DbModule dbModule) {
      this.dbModule = Preconditions.checkNotNull(dbModule);
      return this;
    }

    public Builder dataSourceModule(DataSourceModule dataSourceModule) {
      this.dataSourceModule = Preconditions.checkNotNull(dataSourceModule);
      return this;
    }

    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }
  }

  private final class RoutesComponentImpl implements RoutesComponent {
    private RoutesModule routesModule;

    private FormModule formModule;

    private Provider<FormService> providesFormServiceProvider;

    private Provider<FormController> providesFormControllerProvider;

    private Provider<List<BaseController>> providesControllersProvider;

    private RoutesComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.routesModule = new RoutesModule();
      this.formModule = new FormModule();
      this.providesFormServiceProvider =
          DoubleCheck.provider(
              FormModule_ProvidesFormServiceFactory.create(
                  formModule,
                  DaggerAppComponent.this.providesGsonProvider,
                  DaggerAppComponent.this.providesFormRepositoryProvider));
      this.providesFormControllerProvider =
          DoubleCheck.provider(
              FormModule_ProvidesFormControllerFactory.create(
                  formModule,
                  DaggerAppComponent.this.providesGsonProvider,
                  providesFormServiceProvider));
      this.providesControllersProvider =
          DoubleCheck.provider(
              RoutesModule_ProvidesControllersFactory.create(
                  routesModule, providesFormControllerProvider));
    }

    @Override
    public void inject(final Service service) {
      injectService(service);
    }

    @CanIgnoreReturnValue
    private Service injectService(Service instance) {
      Service_MembersInjector.injectSparkConfig(
          instance, DaggerAppComponent.this.providesSparkConfigProvider.get());
      Service_MembersInjector.injectConfig(
          instance, DaggerAppComponent.this.providesConfigProvider.get());
      Service_MembersInjector.injectFlyway(
          instance, DaggerAppComponent.this.providesFlywayProvider.get());
      Service_MembersInjector.injectGson(
          instance, DaggerAppComponent.this.providesGsonProvider.get());
      Service_MembersInjector.injectControllers(instance, providesControllersProvider.get());
      Service_MembersInjector.injectResourceProvider(
          instance, DaggerAppComponent.this.providesResourceProvider.get());
      return instance;
    }
  }
}
