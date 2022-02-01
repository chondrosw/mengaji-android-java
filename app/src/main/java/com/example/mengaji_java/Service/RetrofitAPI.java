package com.example.mengaji_java.Service;

import com.example.mengaji_java.Model.UserLoginModel;
import com.example.mengaji_java.Model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("register")
    Call<UserModel> postRegister(@Body UserModel userModel);
    @POST("login")
    Call<UserLoginModel> postLogin(@Body UserLoginModel userModel);
}
