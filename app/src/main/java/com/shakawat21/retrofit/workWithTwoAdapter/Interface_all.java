package com.shakawat21.retrofit.workWithTwoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Interface_all {

    @GET("teams/{ID}")
    Call<Model_1_2> getTeamData(@Path("ID") int id, @Query("api_token") String token);

    @GET("players")
    Call<Model_2_3> getAllData(@Query("api_token") String api_token);
}
