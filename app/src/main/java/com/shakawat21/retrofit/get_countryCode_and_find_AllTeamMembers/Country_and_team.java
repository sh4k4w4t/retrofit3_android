package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.shakawat21.retrofit.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Country_and_team extends AppCompatActivity {

    CT_retrofit ct_retrofit;

    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_and_team);

//        https://cricket.sportmonks.com/api/v2.0/teams/10?api_token=ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX
//        https://cricket.sportmonks.com/api/v2.0/players?api_token=ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ct_retrofit = retrofit.create(CT_retrofit.class);

        Call<CT_model_1> call = ct_retrofit.getData(10,"ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX");
        call.enqueue(new Callback<CT_model_1>() {
            @Override
            public void onResponse(Call<CT_model_1> call, Response<CT_model_1> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Response 1 success", Toast.LENGTH_SHORT).show();
                    int id = response.body().getId();
                    int cid = response.body().getCountry_id();
                    Toast.makeText(getApplicationContext(), id+" "+cid, Toast.LENGTH_SHORT).show();

                    Call<CT_array_design_class_2> call_player = ct_retrofit.getPlayerData(getResources().getString(R.string.token_tasnova));
                    call_player.enqueue(new Callback<CT_array_design_class_2>() {
                        @Override
                        public void onResponse(Call<CT_array_design_class_2> call, Response<CT_array_design_class_2> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Response 2 success", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Response 2 failed", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<CT_array_design_class_2> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "failure 2 failed", Toast.LENGTH_SHORT).show();
                        }
                    });


                } else {
                    Toast.makeText(getApplicationContext(), "Response 1 Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CT_model_1> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure 1 Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}