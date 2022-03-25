package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.shakawat21.retrofit.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Country_and_team extends AppCompatActivity {
    RecyclerView recycleViewID_team_country;
    Country_team_retrofit country_team_retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_and_team);

        recycleViewID_team_country= findViewById(R.id.recycleViewID_team_country);
        recycleViewID_team_country.setLayoutManager(new LinearLayoutManager(this));

//        https://cricket.sportmonks.com/api/v2.0/teams/10?api_token=ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX
//        https://cricket.sportmonks.com/api/v2.0/players?api_token=ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        country_team_retrofit= retrofit.create(Country_team_retrofit.class);
        Call<Country_team_model_1_2> call_1= country_team_retrofit.onlySomeInfo(10,getResources().getString(R.string.token_0));
        call_1.enqueue(new Callback<Country_team_model_1_2>() {
            @Override
            public void onResponse(Call<Country_team_model_1_2> call, Response<Country_team_model_1_2> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "1_response success", Toast.LENGTH_SHORT).show();
                    Country_team_model_1_2 country_team_model_1_2=response.body();


                    Call<Country_team_data_class_2_3> call_2= country_team_retrofit.allCountryInfo(getResources().getString(R.string.token_0));
                    call_2.enqueue(new Callback<Country_team_data_class_2_3>() {
                        @Override
                        public void onResponse(Call<Country_team_data_class_2_3> call, Response<Country_team_data_class_2_3> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "2_response Success", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "2_response failed", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Country_team_data_class_2_3> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "2_failure failed", Toast.LENGTH_SHORT).show();
                        }
                    });





                }
                else {
                    Toast.makeText(getApplicationContext(), "1_response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Country_team_model_1_2> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "1_failure failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}