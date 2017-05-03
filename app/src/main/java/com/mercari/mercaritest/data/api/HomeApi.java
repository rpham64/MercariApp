package com.mercari.mercaritest.data.api;


import com.mercari.mercaritest.data.model.HomeResponse;

import io.reactivex.Maybe;
import retrofit2.http.GET;

public interface HomeApi {

    @GET("/home")
    Maybe<HomeResponse> getHome();
}
