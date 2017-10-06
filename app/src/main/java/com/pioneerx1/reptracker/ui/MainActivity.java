package com.pioneerx1.reptracker.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
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
            intent.putExtra("chamber", "house");
            startActivity(intent);
        }
        if (v == mSearchSenateButton) {
            Intent intent = new Intent(this, SearchCongressActivity.class);
            intent.putExtra("chamber", "senate");
            startActivity(intent);
        }
        if (v == mSavedRepsListButton) {
            Intent intent = new Intent(this, SavedRepsListActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
