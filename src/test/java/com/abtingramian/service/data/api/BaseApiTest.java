package com.abtingramian.service.data.api;

import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.util.Constants;
import com.abtingramian.service.common.util.ResourceProvider;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseApiTest {

    protected static Config config;
    protected ResourceProvider resourceProvider = new ResourceProvider(new Gson());

    protected static Retrofit.Builder getRetrofitBuilder() throws IOException {
        final Gson gson = new Gson();
        final BufferedReader reader = Files.newBufferedReader(Paths.get("config", "test.json"));
        config = gson.fromJson(reader, Config.class);
        reader.close();
        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor(message-> System.out.println(String.format("%s: %s", Constants.LOGGING_INTERCEPTOR_TAG, message)))
                                .setLevel(config.debug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                        .build())
                // Java primitive and boxed type serialization/deserialization
                .addConverterFactory(ScalarsConverterFactory.create())
                // JSON serializing/deserializing
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

}
