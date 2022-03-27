package com.shakawat21.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient_for_fakeJson {
    public static Retrofit api;
    public static AllInterface services;

    public static AllInterface getServices(){
        if (services==null){
            if (api==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();

                OkHttpClient okHttpClient= new OkHttpClient.Builder()
                        .connectTimeout(7000, TimeUnit.SECONDS)
                        .readTimeout(7000,TimeUnit.SECONDS)
                        .build();

                api= new Retrofit.Builder()
                        .baseUrl("http://app.fakejson.com/")
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            services= api.create(AllInterface.class);
            return services;
        }
        return services;
    }
}
