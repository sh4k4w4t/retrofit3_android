package com.shakawat21.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView hello1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello1= findViewById(R.id.hello1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofitClient ourRetrofitClient = retrofit.create(OurRetrofitClient.class);
        Call<OurMainDataClass> call = ourRetrofitClient.getData("ieisuz1CyH3RKtswe9hdzZ0gWBDbTuIUlCBzrQHS0kTZQHz1MfPsCKKsOYEX");

        call.enqueue(new Callback<OurMainDataClass>() {
            @Override
            public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {
                if (response.isSuccessful()) {
                    List<ObjectDataClass> list = response.body().getData();
                    for (ObjectDataClass objectDataClass : list) {
                        Toast.makeText(getApplicationContext(), "response success", Toast.LENGTH_SHORT).show();
                        hello1.setText("response success");
                        Log.d("resource", String.valueOf(objectDataClass.getName()));
                        Log.d("id", String.valueOf(objectDataClass.getId()));
                        Log.d("name", String.valueOf(objectDataClass.getName()));
                        Log.d("updated_at", String.valueOf(objectDataClass.getUpdated_at()));
                    }
                } else {
                    Log.d("response", "onResponse: failed");
                    hello1.setText("response failed");
                    Toast.makeText(getApplicationContext(), "response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OurMainDataClass> call, Throwable t) {
                Log.d("response", "onFailure: failed");
                hello1.setText("onFailure failed");
                Toast.makeText(getApplicationContext(), "failure failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}