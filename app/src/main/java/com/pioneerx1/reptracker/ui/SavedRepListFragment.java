package com.pioneerx1.reptracker.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.pioneerx1.reptracker.Constants;
import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.adapters.FirebaseRepListAdapter;
import com.pioneerx1.reptracker.adapters.FirebaseRepViewHolder;
import com.pioneerx1.reptracker.models.Rep;
import com.pioneerx1.reptracker.util.OnStartDragListener;
import com.pioneerx1.reptracker.util.SimpleItemTouchHelperCallback;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedRepListFragment extends Fragment implements OnStartDragListener {

    @Bind(R.id.congressRepsRecyclerView) RecyclerView mRecyclerView;
    private FirebaseRepListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;
    private DatabaseReference mRepReference;

    public SavedRepListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_rep_list, container, false);
        ButterKnife.bind(this, view);
        setUpFirebaseAdapter();
        return view;
    }

    private void setUpFirebaseAdapter() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        Query query = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_SAVED_MEMBERS)
                .child(uid)
                .orderByChild(Constants.FIREBASE_QUERY_INDEX);

        mFirebaseAdapter = new FirebaseRepListAdapter(Rep.class, R.layout.rep_list_item_drag,
                FirebaseRepViewHolder.class, query, this, getActivity());

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mFirebaseAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
