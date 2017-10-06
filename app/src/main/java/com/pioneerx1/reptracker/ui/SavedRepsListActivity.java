package com.pioneerx1.reptracker.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pioneerx1.reptracker.Constants;
import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.adapters.FirebaseRepViewHolder;
import com.pioneerx1.reptracker.models.Rep;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedRepsListActivity extends AppCompatActivity {

    private DatabaseReference mRepReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.congressRepsRecyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_congress);  // re-using search congress layout
        Log.d("You have arrived at ", " SAVED REPS LIST ACTIVITY");
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mRepReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_SAVED_MEMBERS)
                .child(uid);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Rep, FirebaseRepViewHolder>
                (Rep.class, R.layout.rep_list_item, FirebaseRepViewHolder.class, mRepReference) {

            @Override
            protected void populateViewHolder(FirebaseRepViewHolder viewHolder, Rep model, int position) {
                viewHolder.bindRep(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

}
