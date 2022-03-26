package com.shakawat21.retrofit.workWithTwoAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.shakawat21.retrofit.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorkWithTwoAdapter extends AppCompatActivity {

    Interface_all interface_all;
    TextView ct_id_1, ct_country_id_1;
    String sID, sCountryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_work_with_two_adapter);
        setContentView(R.layout.test_1);

        ct_id_1= findViewById(R.id.ct_id_1);
        ct_country_id_1= findViewById(R.id.ct_country_id_1);

        OkHttpClient client= new OkHttpClient.Builder()
                .connectTimeout(7000, TimeUnit.SECONDS)
                .readTimeout(7000,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        interface_all= retrofit.create(Interface_all.class);








        Call<Model_1_2> call= interface_all.getData(10,getResources().getString(R.string.token_0));

        call.enqueue(new Callback<Model_1_2>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Model_1_2> call, Response<Model_1_2> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "1 Response Success", Toast.LENGTH_SHORT).show();
                    Model_1_2 model_1_2= response.body();

                    sID= model_1_2.getData().getId()+"";
                    sCountryId= model_1_2.getData().getCountry_id()+"";


                    Call<Model_2_3> call1= interface_all.getAllData(getResources().getString(R.string.token_0));
                    call1.enqueue(new Callback<Model_2_3>() {
                        @Override
                        public void onResponse(Call<Model_2_3> call, Response<Model_2_3> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "2 Response Success", Toast.LENGTH_SHORT).show();
                                List<Model_2_2> model_2_2s= response.body().getData();
                                for (Model_2_2 model_2_2 : model_2_2s){
                                    Log.d("first name", model_2_2.getFirstname());
                                    Log.d("Last name", model_2_2.getLastname());
                                }



                            }else {
                                Toast.makeText(getApplicationContext(), "2 Response failed", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<Model_2_3> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "2 Failure failed Success", Toast.LENGTH_SHORT).show();


                        }
                    });

                }
                else {
                    Toast.makeText(getApplicationContext(), "1 Response Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model_1_2> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "1 Failure failed", Toast.LENGTH_SHORT).show();
            }
        });


    }
}