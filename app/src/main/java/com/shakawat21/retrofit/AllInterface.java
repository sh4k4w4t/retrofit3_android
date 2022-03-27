package com.shakawat21.retrofit;

import com.shakawat21.retrofit.get.get_all.OurMainDataClass;
import com.shakawat21.retrofit.get.get_by_id.OurMainDataClass_by_ID;
import com.shakawat21.retrofit.get.workWithTwoAdapter.Model_1_2;
import com.shakawat21.retrofit.get.workWithTwoAdapter.Model_2_3;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AllInterface {

    //get_all
    @GET("continents")
    Call<OurMainDataClass> getData(@Query("api_token") String token);

    //get_by_id
    @GET("continents/{ID}")
    Call<OurMainDataClass_by_ID> getData(@Path("ID") int id, @Query("api_token") String token);

    //workWithTwoAdapter
    @GET("teams/{ID}")
    Call<Model_1_2> getTeamData(@Path("ID") int id, @Query("api_token") String token);

    @GET("players")
    Call<Model_2_3> getAllData(@Query("api_token") String api_token);



}
