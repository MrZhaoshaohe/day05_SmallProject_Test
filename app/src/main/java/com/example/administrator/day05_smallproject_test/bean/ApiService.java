package com.example.administrator.day05_smallproject_test.bean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/3/7.
 */

public interface ApiService {

    @GET
    public Call<User> getDataUrl (@Url String Url);
}
