package com.shakawat21.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shakawat21.retrofit.get_all.Activity_get_all;
import com.shakawat21.retrofit.get_by_id.Activity_get_by_id;

public class MainActivity extends AppCompatActivity {
    Button button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Activity_get_all.class)));
        button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Activity_get_by_id.class)));

    }
}