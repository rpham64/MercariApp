package com.mercari.mercaritest.ui;

import android.content.Context;

import com.mercari.mercaritest.MercariApp;
import com.mercari.mercaritest.base.BasePresenter;
import com.mercari.mercaritest.base.BaseView;
import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.data.model.Response;
import com.mercari.mercaritest.network.RestClient;
import com.mercari.mercaritest.utils.JSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * The Presenter of the Main section of this app. Represents the Presenter component in this app's
 * MVP architecture and handles the main business logic.
 */
public class MainPresenter implements BasePresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private static final String DATA_FILE_NAME = "all.json";

    private BaseView mView;
    private Response mItemsResponse;

    @Override
    public void attachView(BaseView baseView) {
        mView = baseView;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public BaseView getView() {
        return mView;
    }

    /**
     * Retrieves data from the provided json string and passes them into a pre-defined Response
     * object.
     */
    @Override
    public void setItemsResponse(Context context) {
        // Load string from the given all.json file.
        String jsonString = JSONUtils.loadJSONFromAsset(context, DATA_FILE_NAME);

        try {
            // Create JSONObject of the response.
            JSONObject jsonObject = new JSONObject(jsonString);

            // Retrieve "result" and "data" from the response.
            String result = jsonObject.getString("result");

            JSONArray dataArray = jsonObject.getJSONArray("data");
            List<Item> dataList = new ArrayList<>();

            for (int i = 0; i < dataArray.length(); ++i) {
                JSONObject object = dataArray.getJSONObject(i);
                Item item = new Item(
                        object.getString("id"),
                        object.getString("name"),
                        object.getLong("num_likes"),
                        object.getLong("num_comments"),
                        object.getLong("price"),
                        object.getString("photo"),
                        object.getString("status")
                );
                dataList.add(item);
            }

            // Instantiate the response object with the "result" and "data".
            mItemsResponse = new Response(result, dataList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUI() {
        if (mView != null) {
            mView.showItems(mItemsResponse.data);
        }
    }

    @Override
    public RestClient getRestClient() {
        return MercariApp.getInstance().getRestClient();
    }

    @Override
    public void fetchDataWithRetrofit(String token) {
        Call<Response> responseCall = getRestClient().getDataWithRetrofit(token);
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                // Do something on response.
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                // Do something on failure.
            }
        });
    }

    @Override
    public void fetchDataWithRxJava(String token) {

    }
}
