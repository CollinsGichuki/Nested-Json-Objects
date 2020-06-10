package com.snilloc.nestedjsonobjects;

import com.snilloc.nestedjsonobjects.POJOS.Users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderAPI {
    @GET("users/1")
    Call<Users> getUsers();
}
