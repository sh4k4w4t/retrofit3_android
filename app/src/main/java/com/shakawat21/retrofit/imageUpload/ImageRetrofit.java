package com.shakawat21.retrofit.imageUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shakawat21.retrofit.AllInterface;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageRetrofit {
    public static Retrofit api;
    public static AllInterface services;

    public static AllInterface getServices(){
        if (services==null){
            if (api==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();

                OkHttpClient client= new OkHttpClient.Builder()
                        .connectTimeout(1000, TimeUnit.SECONDS)
                        .readTimeout(1000,TimeUnit.SECONDS)
                        .build();
                api= new Retrofit.Builder()
                        .client(client)
                        .baseUrl("https://testing.alivepython.com/testapi/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            services = api.create(AllInterface.class);
            return services;
        }
        return services;
    }
}
