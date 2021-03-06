package com.shakawat21.retrofit.get.workWithTwoAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.shakawat21.retrofit.AllInterface;
import com.shakawat21.retrofit.R;
import com.shakawat21.retrofit.RetrofitClient_for_sportsMonk;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkWithTwoAdapter extends AppCompatActivity {
    AllInterface allInterface;

    TextView ct_id_1, ct_country_id_1;
    String sID, sCountryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_work_with_two_adapter);
        setContentView(R.layout.test_1);

        ct_id_1= findViewById(R.id.ct_id_1);
        ct_country_id_1= findViewById(R.id.ct_country_id_1);

        allInterface= RetrofitClient_for_sportsMonk.getServices();
        loadHistory();
    }

    private void loadHistory() {
        Call<Model_1_2> call= allInterface.getTeamData(10,getResources().getString(R.string.token_0));

        call.enqueue(new Callback<Model_1_2>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Model_1_2> call, Response<Model_1_2> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "1 Response Success", Toast.LENGTH_SHORT).show();
                    Model_1_2 model_1_2= response.body();

                    sID= model_1_2.getData().getId()+"";
                    sCountryId= model_1_2.getData().getCountry_id()+"";


                    Call<Model_2_3> call1= allInterface.getAllData(getResources().getString(R.string.token_0));
                    call1.enqueue(new Callback<Model_2_3>() {
                        @Override
                        public void onResponse(Call<Model_2_3> call, Response<Model_2_3> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "2 Response Success", Toast.LENGTH_SHORT).show();
                                List<Model_2_2> model_2_2s= response.body().getData();

                                for (Model_2_2 model_2_2 : model_2_2s){
                                        Log.d("first name", model_2_2.getFirstname());
                                        Log.d("Last name", model_2_2.getLastname());
                                        Log.d("ID", Integer.toString(model_2_2.getId()));
                                        Log.d("Country Id", Integer.toString(model_2_2.getCountry_id()));}
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