package com.mercari.mercaritest.base;

import android.content.Context;

import com.mercari.mercaritest.network.RestClient;

/**
 * A base interface for MainPresenter. Represents the contract of methods that MainPresenter will
 * inherit and override.
 */
public interface BasePresenter {

    // Essential methods for a base presenter class.
    void attachView(BaseView baseView);
    void detachView();
    BaseView getView();

    void setItemsResponse(Context context);
    void updateUI();

    // Boilerplate methods for Retrofit and RxJava
    RestClient getRestClient();
    void fetchDataWithRetrofit(String token);
    void fetchDataWithRxJava(String token);
}
