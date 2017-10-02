package com.pioneerx1.reptracker.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pioneerx1.reptracker.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.searchHouseButton) Button mSearchHouseButton;
    @Bind(R.id.searchSenateButton) Button mSearchSenateButton;
    @Bind(R.id.savedRepsListButton) Button mSavedRepsListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchHouseButton.setOnClickListener(this);
        mSearchSenateButton.setOnClickListener(this);
        mSavedRepsListButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchHouseButton) {
            Intent intent = new Intent(this, SearchCongressActivity.class);
            startActivity(intent);
        }
        if (v == mSearchSenateButton) {
            Intent intent = new Intent(this, SearchCongressActivity.class);
            startActivity(intent);
        }
        if (v == mSavedRepsListButton) {
            Intent intent = new Intent(this, SavedRepsListActivity.class);
            startActivity(intent);
        }
    }
}
