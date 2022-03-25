package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Country_team_retrofit {

//        https://cricket.sportmonks.com/api/v2.0/teams/10?api_token=ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX
//        https://cricket.sportmonks.com/api/v2.0/players?api_token=ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX


    @GET("teams/{ID}")
    Call<Country_team_model_1_2> onlySomeInfo(@Path("ID") int id,
                                              @Query("api_token") String api);

    @GET("players")
    Call<Country_team_data_class_2_3> allCountryInfo(@Query("api_token") String api);

}
