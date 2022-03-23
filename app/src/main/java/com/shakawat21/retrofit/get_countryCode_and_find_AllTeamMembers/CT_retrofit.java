package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CT_retrofit {

//        https://cricket.sportmonks.com/api/v2.0/teams/10?api_token=ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX
//        https://cricket.sportmonks.com/api/v2.0/players?api_token=ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX

    @GET("teams/{ID}")
    Call<CT_model_1> getData(@Path("ID") int id, @Query("api_token") String token);

    @GET("players")
    Call<CT_array_design_class_2> getPlayerData(@Query("api_token") String token);
}
