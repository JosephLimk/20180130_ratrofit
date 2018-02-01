package com.example.administrator.a20180130_ratrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018-01-30.
 */

public class RetrofitService {
    public static RetrofitService curr = null;
    private RetrofitRequest retrofitRequest;

    public static RetrofitService getInstance(){
        if(curr == null){
            curr = new RetrofitService();
        }
        return  curr;

        //★1
    }

    private RetrofitService(){
        retrofitRequest = init(); //★3

    }

    public RetrofitRequest init(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.141.201:8090/tbjagoods/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitRequest.class);    // 이부분은 인터페이스 클래스파일지정

        //★2

        //레트로핏을 초기화시켜주는 작업

    }

    public RetrofitRequest getRetrofitRequest() {
        return retrofitRequest;
        //★4 겟터생성
    }
}



