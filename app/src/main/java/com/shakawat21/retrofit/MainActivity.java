package com.shakawat21.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shakawat21.retrofit.get_all.Activity_get_all;
import com.shakawat21.retrofit.get_by_id.Activity_get_by_id;

public class MainActivity extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, Activity_get_all.class));
                startActivity(new Intent(MainActivity.this, Activity_get_by_id.class));
            }
        });

    }
}