package com.pioneerx1.reptracker.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pioneerx1.reptracker.R;

public class SearchCongressActivity extends AppCompatActivity {

    // get API call from this activity working, then REFACTOR this into a FRAGMENT!!!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_congress);

        Log.d("You have arrived at ", " SEARCH CONGRESS ACTIVITY");
    }
}
