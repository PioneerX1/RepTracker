package com.pioneerx1.reptracker.services;


import android.util.Log;

import com.pioneerx1.reptracker.Constants;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProPublicaService {

    public static void findCongressMembers(String congressChamber, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder ongoing = chain.request().newBuilder();
                        ongoing.addHeader(Constants.PROPUBLICA_API_HEADER_PARAMETER, Constants.PROPUBLICA_API_KEY);
                        return chain.proceed(ongoing.build());
                    }
                })
                .build();

        HttpUrl.Builder urlBuilder;
        if (congressChamber.equals("senate")) {
            urlBuilder = HttpUrl.parse(Constants.PROPUBLICA_BASE_URL_SENATE).newBuilder();
        } else {
            urlBuilder = HttpUrl.parse(Constants.PROPUBLICA_BASE_URL_HOUSE).newBuilder();
        }

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);

        Log.d("--- API REQUEST URL ---", url);

    }

}
