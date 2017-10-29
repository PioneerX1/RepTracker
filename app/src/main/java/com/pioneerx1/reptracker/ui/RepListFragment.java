package com.pioneerx1.reptracker.ui;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class RepListFragment extends Fragment {

    @Bind(R.id.congressRepsRecyclerView) RecyclerView mCongressRepsRecyclerView;
    private RepListAdapter mAdapter;
    private ArrayList<Rep> mAllReps = new ArrayList<>();
    private ProgressDialog mRetrieveProgressDialog;
    String congressChamber = "not specified";



    public RepListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rep_list, container, false);
        ButterKnife.bind(this, view);

        createRetrieveProgressDialog();
        mRetrieveProgressDialog.show();

        Intent intent = getActivity().getIntent();
        congressChamber = intent.getStringExtra("chamber");
        getCongressMembers(congressChamber);

        return view;
    }

    private void createRetrieveProgressDialog() {
        mRetrieveProgressDialog = new ProgressDialog(getActivity());
        mRetrieveProgressDialog.setTitle("Loading...");
        mRetrieveProgressDialog.setMessage("Retrieving Congress Members...");
        mRetrieveProgressDialog.setCancelable(false);
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
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new RepListAdapter(getActivity(), mAllReps);
                        mCongressRepsRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        mCongressRepsRecyclerView.setLayoutManager(layoutManager);
                        mCongressRepsRecyclerView.setHasFixedSize(true);
                        mRetrieveProgressDialog.dismiss();

                    }
                });

            }

        });
    }
}