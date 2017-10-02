package com.pioneerx1.reptracker.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.widget.RecyclerView;

import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.adapters.RepListAdapter;
import com.pioneerx1.reptracker.models.Rep;
import com.pioneerx1.reptracker.services.ProPublicaService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchCongressActivity extends AppCompatActivity {

    // get API call from this activity working, then REFACTOR this into a FRAGMENT!!!

    private ArrayList<Rep> mAllReps = new ArrayList<>();
    private RepListAdapter mAdapter;

    @Bind(R.id.congressRepsRecyclerView) RecyclerView mCongressRepsRecyclerView;

    // hard-code this for now:
    String congressChamber = "not specified";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_congress);

        Intent intent = getIntent();
        congressChamber = intent.getStringExtra("chamber");

        Log.d("You have arrived at ", " SEARCH CONGRESS ACTIVITY");
        getCongressMembers(congressChamber);
    }

    private void getCongressMembers(String congressChamber) {
        final ProPublicaService propublicaService = new ProPublicaService();
        propublicaService.findCongressMembers(congressChamber, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mAllReps = propublicaService.processResults(response);
                String count = mAllReps.size() + "";
                Log.d("COUNT: ", count);
//                for(int i = 0; i < mAllReps.size(); i++) {
//                    Log.d("----", "------------");
//                    Log.d("NAME: ", mAllReps.get(i).getName());
//                    Log.d("TITLE: ", mAllReps.get(i).getTitle());
//                    Log.d("STATE: ", mAllReps.get(i).getState());
//                    Log.d("PARTY: ", mAllReps.get(i).getParty());
//                    Log.d("MEMBER ID: ", mAllReps.get(i).getMemberId());
//                    Log.d("COUNT: ", i + "");
//                }
//                int count = mAllReps.size();
//                Log.d("COUNT: ", count + "");



//                try {
//                    String jsonData = response.body().string();
//                    if (response.isSuccessful()) {
//                        //Log.d("API RESPONSE---", jsonData);
//                        mAllReps = propublicaService.processResults(response);
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }


            }
        });
    }

}
