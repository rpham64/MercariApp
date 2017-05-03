package com.mercari.mercaritest.data.api;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl("xxxxxxxx")
                .build();
    }

    @Provides
    @Singleton
    HomeApi provideHomeApi(Retrofit retrofit) {
        return retrofit.create(HomeApi.class);
    }

}
