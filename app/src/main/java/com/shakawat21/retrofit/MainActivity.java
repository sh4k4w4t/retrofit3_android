package com.shakawat21.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.shakawat21.retrofit.get.get_all.Activity_get_all;
import com.shakawat21.retrofit.get.get_by_id.Activity_get_by_id;
import com.shakawat21.retrofit.get.workWithTwoAdapter.WorkWithTwoAdapter;
import com.shakawat21.retrofit.imageUpload.ImageUploadActivity;
import com.shakawat21.retrofit.post.fakejson_1.FakeJson_1;
import com.shakawat21.retrofit.post.fakejson_2.FakeJson_2;

public class MainActivity extends AppCompatActivity {
    Button button,button1,button2,fake_json_1,fake_json_2,imageUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        fake_json_1=findViewById(R.id.fake_json_1);
        fake_json_2=findViewById(R.id.fake_json_2);
        imageUpload=findViewById(R.id.imageUpload);

        button1.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Activity_get_all.class)));
        button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Activity_get_by_id.class)));
        button2.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, WorkWithTwoAdapter.class)));
        fake_json_1.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FakeJson_1.class)));
        fake_json_2.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FakeJson_2.class)));
        imageUpload.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ImageUploadActivity.class)));

    }
}