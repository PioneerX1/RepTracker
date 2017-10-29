package com.pioneerx1.reptracker.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.support.v7.widget.RecyclerView;

import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.adapters.RepListAdapter;
import com.pioneerx1.reptracker.models.Rep;
import com.pioneerx1.reptracker.services.ProPublicaService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchCongressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_congress);
    }

}
