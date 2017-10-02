package com.pioneerx1.reptracker.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pioneerx1.reptracker.R;

public class SavedRepsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_reps_list);
        Log.d("You have arrived at ", " SAVED REPS LIST ACTIVITY");
    }
}
