package com.example.administrator.a20180130_ratrofit.retrofit;

import com.example.administrator.a20180130_ratrofit.model.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018-01-30.
 */

public interface RetrofitRequest {
    @GET("goods")
    Call<ArrayList<Item>> getGoods();
}
