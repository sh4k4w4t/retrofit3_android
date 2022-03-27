package com.shakawat21.retrofit.post.fakejson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shakawat21.retrofit.AllInterface;
import com.shakawat21.retrofit.R;
import com.shakawat21.retrofit.RetrofitClient_for_fakeJson;
import com.shakawat21.retrofit.post.fakejson_1.response.Model_response_final_4;

import retrofit2.Call;

public class FakeJson_1 extends AppCompatActivity {
    AllInterface allInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_json1);

        allInterface= RetrofitClient_for_fakeJson.getServices();
        loadHistory();
    }

    private void loadHistory() {
        Call<Model_response_final_4> call= allInterface.getFakeResponse_1();
    }
}