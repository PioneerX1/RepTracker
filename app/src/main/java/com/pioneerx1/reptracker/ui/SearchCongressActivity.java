package com.pioneerx1.reptracker.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.widget.RecyclerView;

import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.adapters.RepListAdapter;
import com.pioneerx1.reptracker.models.Rep;

import java.util.ArrayList;

import butterknife.Bind;

public class SearchCongressActivity extends AppCompatActivity {

    // get API call from this activity working, then REFACTOR this into a FRAGMENT!!!

    private ArrayList<Rep> mAllReps = new ArrayList<>();
    private RepListAdapter mAdapter;

    @Bind(R.id.congressRepsRecyclerView) RecyclerView mCongressRepsRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_congress);

        Log.d("You have arrived at ", " SEARCH CONGRESS ACTIVITY");
    }
}
