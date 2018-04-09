package com.mercari.mercaritest.network;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * A class for handling RESTful API calls via Retrofit and RxJava.
 */
public interface RestClient {

    /**
     * A method for retrieving data from the network via a GET HTTP request.
     *
     * @param someToken A token for retrieving the proper data.
     * @return A network response containing the network data from the web server.
     */
    @GET("some/url/here")
    Call<com.mercari.mercaritest.data.model.Response> getDataWithRetrofit(@Query("some_string") String someToken);

    /**
     * A method for retrieving data from the network via a GET HTTP request.
     *
     * @param someToken A token for retrieving the proper data.
     * @return An observable of the network response using RxJava.
     */
    @GET("some/url/here")
    io.reactivex.Observable<Response> getDataWithRxJava(@Query("some_string") String someToken);
}
