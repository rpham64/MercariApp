package com.mercari.mercaritest;

import android.app.Application;

import com.mercari.mercaritest.network.RestClient;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MercariApp extends Application {

    // String placeholders for future network calls.
    private static final String BASE_URL = "";
    private static final String API_KEY = "";

    private static MercariApp sInstance;

    private AppComponent appComponent;

    private OkHttpClient mOkHttpClient;
    private RestClient mRestClient;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);

        mOkHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        // Build an interceptor for the OkHttp client here.
                        return null;
                    }
                })
                .build();
    }

    /**
     * Returns a static instance of the MercariApp Application class.
     *
     * @return This MercariApp Application class.
     */
    public static MercariApp getInstance() {
        return sInstance;
    }

    /**
     * Returns an instance of the RestClient. If null, initializes it first.
     *
     * @return Instance of the RestClient interface.
     */
    public RestClient getRestClient() {
        if (mRestClient == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();
            mRestClient = retrofit.create(RestClient.class);
        }

        return mRestClient;
    }
}
