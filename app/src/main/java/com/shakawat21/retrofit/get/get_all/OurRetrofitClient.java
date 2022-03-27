package com.shakawat21.retrofit.get.get_all;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OurRetrofitClient {

    @GET("continents")
    Call<OurMainDataClass> getData(@Query("api_token") String token);
}
