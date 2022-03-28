package com.shakawat21.retrofit.post.fakejson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.shakawat21.retrofit.AllInterface;
import com.shakawat21.retrofit.R;
import com.shakawat21.retrofit.RetrofitClient_for_fakeJson;
import com.shakawat21.retrofit.post.fakejson_1.request.Model_request_data_1;
import com.shakawat21.retrofit.post.fakejson_1.request.Model_request_final_1;
import com.shakawat21.retrofit.post.fakejson_1.response.Model_response_user_info_final;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FakeJson_1 extends AppCompatActivity {
    AllInterface allInterface;

    Model_request_data_1 model_request_data_1;
    Model_request_final_1 model_request_final_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_json2);

        allInterface= RetrofitClient_for_fakeJson.getServices();
        model_request_data_1 = new Model_request_data_1("nameFirst","internetEmail",3);
        model_request_final_1= new Model_request_final_1("DhI-Xye_0SzOK3WbKey8Ow",model_request_data_1);
        loadCallSection();
    }

    private void loadCallSection() {
        Call<List<Model_response_user_info_final>> response= allInterface.userInfo(model_request_final_1);
        response.enqueue(new Callback<List<Model_response_user_info_final>>() {
            @Override
            public void onResponse(Call<List<Model_response_user_info_final>> call, Response<List<Model_response_user_info_final>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Response Success", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Response Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Model_response_user_info_final>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}