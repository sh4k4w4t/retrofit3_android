package com.shakawat21.retrofit;

import com.shakawat21.retrofit.get.get_all.OurMainDataClass;
import com.shakawat21.retrofit.get.get_by_id.OurMainDataClass_by_ID;
import com.shakawat21.retrofit.get.workWithTwoAdapter.Model_1_2;
import com.shakawat21.retrofit.get.workWithTwoAdapter.Model_2_3;
import com.shakawat21.retrofit.post.fakejson_1.request.Model_request_final_1;
import com.shakawat21.retrofit.post.fakejson_1.response.Model_response_user_info_1;
import com.shakawat21.retrofit.post.fakejson_2.request.Model_request_final_5;
import com.shakawat21.retrofit.post.fakejson_2.response.Model_response_final_4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AllInterface {

    //get_all sportsMonk
    @GET("continents")
    Call<OurMainDataClass> getData(@Query("api_token") String token);

    //get_by_id sportsMonk
    @GET("continents/{ID}")
    Call<OurMainDataClass_by_ID> getData(@Path("ID") int id, @Query("api_token") String token);

    //workWithTwoAdapter sportsMonk
    @GET("teams/{ID}")
    Call<Model_1_2> getTeamData(@Path("ID") int id, @Query("api_token") String token);

    //workWithTwoAdapter sportsMonk
    @GET("players")
    Call<Model_2_3> getAllData(@Query("api_token") String api_token);

    //fakeResponse_2
    @POST("q")
    Call<Model_response_final_4> getFakeResponse_2(@Body Model_request_final_5 model_request_final_5);

    //fakeResponse_1
    @POST("q")
    Call<List<Model_response_user_info_1>> userInfo(@Body Model_request_final_1 model_request_final_1);

}
