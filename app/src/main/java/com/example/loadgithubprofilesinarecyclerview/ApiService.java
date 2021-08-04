package com.example.loadgithubprofilesinarecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/comments")
    Call<List<ResponseDTO>> getPosts(@Query("login") String postId);

}