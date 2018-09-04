package com.abtingramian.service.data.api.di;

import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.di.component.AppComponent;
import com.abtingramian.service.common.util.Constants;
import com.abtingramian.service.data.api.RickAndMortyApi;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;

/**
 * This is a Dagger module used to provide api dependencies to the {@link AppComponent}.
 */
@Module
public final class ApiModule {

    @Provides
    @Singleton
    Interceptor providesLoggingInterceptor(final Config config) {
        return new HttpLoggingInterceptor()
                .setLevel(config.debug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    @Provides
    @Singleton
    OkHttpClient provideClient(final Interceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(Constants.DEFAULT_API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    RickAndMortyApi providesRickAndMortyApi(final OkHttpClient client, final Gson gson, final Config config) {
        return new Retrofit.Builder()
                .client(client)
                // Java primitive and boxed type serialization/deserialization
                .addConverterFactory(ScalarsConverterFactory.create())
                // JSON serializing/deserializing
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(config.rickAndMortyApiBaseUrl)
                .build()
                .create(RickAndMortyApi.class);
    }

}
