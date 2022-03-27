package com.shakawat21.retrofit.get.get_by_id;

import androidx.appcompat.app.AppCompatActivity;

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

public class Activity_get_by_id extends AppCompatActivity {

    TextView textView1,textView,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_by_id);

        textView =findViewById(R.id.textView);
        textView1 =findViewById(R.id.textView1);
        textView2 =findViewById(R.id.textView2);
        textView3 =findViewById(R.id.textView3);

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofitClient_for_ID retrofitClient_for_id= retrofit.create(OurRetrofitClient_for_ID.class);

        Call<OurMainDataClass_by_ID> call= retrofitClient_for_id.getData(2, "ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX");
        call.enqueue(new Callback<OurMainDataClass_by_ID>() {
            @Override
            public void onResponse(Call<OurMainDataClass_by_ID> call, Response<OurMainDataClass_by_ID> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "response Success", Toast.LENGTH_SHORT).show();
                    ObjectDataClass_for_ID objectDataClass_for_ID= response.body().getData();
                    Log.d("Resource", objectDataClass_for_ID.getResource());
                    Log.d("Id", String.valueOf(objectDataClass_for_ID.getId()));
                    Log.d("Name", objectDataClass_for_ID.getName());
                    Log.d("Updated_at", objectDataClass_for_ID.getUpdated_at());


                    textView1.setText(objectDataClass_for_ID.getName());
                    textView.setText(String.valueOf(objectDataClass_for_ID.getId()));
                    textView2.setText(objectDataClass_for_ID.getResource());
                    textView3.setText(objectDataClass_for_ID.getUpdated_at());
                }
                else {
                    Toast.makeText(getApplicationContext(), "response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OurMainDataClass_by_ID> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "onFailure failed", Toast.LENGTH_SHORT).show();

            }
        });


    }
}