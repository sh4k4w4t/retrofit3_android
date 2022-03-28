package com.shakawat21.retrofit.post.fakejson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.shakawat21.retrofit.AllInterface;
import com.shakawat21.retrofit.R;
import com.shakawat21.retrofit.RetrofitClient_for_fakeJson;
import com.shakawat21.retrofit.post.fakejson_2.request.Model_request_contacts_2;
import com.shakawat21.retrofit.post.fakejson_2.request.Model_request_data_4;
import com.shakawat21.retrofit.post.fakejson_2.request.Model_request_final_5;
import com.shakawat21.retrofit.post.fakejson_2.request.Model_request_job_1;
import com.shakawat21.retrofit.post.fakejson_2.request.Model_request_location_3;
import com.shakawat21.retrofit.post.fakejson_2.response.Model_response_final_4;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FakeJson_2 extends AppCompatActivity {
    AllInterface allInterface;

    Model_request_job_1 model_request_job_1;
    Model_request_contacts_2 model_request_contacts_2;
    Model_request_location_3 model_request_location_3;
    Model_request_data_4 model_request_data_4;
    Model_request_final_5 model_request_final_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_json1);

        allInterface= RetrofitClient_for_fakeJson.getServices();

        model_request_job_1= new Model_request_job_1("companyName","companyDepartment","personTitle","functionArray|3|phoneHome");
        model_request_contacts_2 = new Model_request_contacts_2("internetEmail","phoneMobile");
        model_request_location_3= new Model_request_location_3("addressStreetName","addressCity","addressState","addressCountry");
        model_request_data_4= new Model_request_data_4("nameFirst","nameLast",model_request_location_3,model_request_contacts_2,model_request_job_1);
        model_request_final_5= new Model_request_final_5(getResources().getString(R.string.token_fake_json),model_request_data_4);
        loadHistory();
    }

    private void loadHistory() {
        Call<Model_response_final_4> call= allInterface.getFakeResponse_2(model_request_final_5);
        call.enqueue(new Callback<Model_response_final_4>() {
            @Override
            public void onResponse(Call<Model_response_final_4> call, Response<Model_response_final_4> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Response Success", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model_response_final_4> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}