package com.pioneerx1.reptracker.services;


import android.util.Log;

import com.pioneerx1.reptracker.Constants;
import com.pioneerx1.reptracker.models.Rep;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

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

    }

    public ArrayList<Rep> processResults(Response response) {
        ArrayList<Rep> reps = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject propublicaJSON = new JSONObject(jsonData);

                JSONArray resultsJSON = propublicaJSON.getJSONArray("results");
                String chamber = resultsJSON.getJSONObject(0).getString("chamber");
                String title;
                if (chamber.equals("Senate")) {
                    title = "Senator";
                } else {
                    title = "Representative";
                }

                JSONArray membersJSON = resultsJSON.getJSONObject(0).getJSONArray("members");
                Log.d("MEMBERS ARRAY", membersJSON.toString());

                for (int i = 0; i < membersJSON.length(); i++) {
                    JSONObject memberJSON = membersJSON.getJSONObject(i);
                    String firstName = memberJSON.getString("first_name");
                    String lastName = memberJSON.getString("last_name");
                    String name = firstName + " " + lastName;
                    String memberId = memberJSON.getString("id");
                    String party = memberJSON.getString("party");
                    String state = memberJSON.getString("state");

                    // additional info
                    String phone = memberJSON.getString("phone");
                    String website = memberJSON.getString("url");
                    String missedVotes = memberJSON.getString("missed_votes_pct");
                    String votesWithParty = memberJSON.getString("votes_with_party_pct");
                    String twitterHandle = memberJSON.getString("twitter_account");
                    String facebookAccount = memberJSON.getString("facebook_account");
                    String nextElection = memberJSON.getString("next_election");

                    Rep newRep = new Rep(name, title, memberId, state, party, phone, website, missedVotes, votesWithParty,
                                            twitterHandle, facebookAccount, nextElection);
                    reps.add(newRep);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return reps;
    }

}
