package com.shakawat21.retrofit.get.get_by_id;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OurRetrofitClient_for_ID {

    @GET("continents/{ID}")
    Call<OurMainDataClass_by_ID> getData(@Path("ID") int id, @Query("api_token") String token);
}
