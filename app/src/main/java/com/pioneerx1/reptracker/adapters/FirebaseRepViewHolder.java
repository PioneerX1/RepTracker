package com.pioneerx1.reptracker.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pioneerx1.reptracker.Constants;
import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.models.Rep;
import com.pioneerx1.reptracker.ui.RepDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseRepViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseRepViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindRep(Rep rep) {

        // db check these R id's because they are also used for Find Reps
        TextView repNameTextView = (TextView) mView.findViewById(R.id.repNameTextView);
        TextView repTitleTextView = (TextView) mView.findViewById(R.id.repTitleTextView);
        TextView repStateTextView = (TextView) mView.findViewById(R.id.repStateTextView);

        repNameTextView.setText(rep.getName());
        repTitleTextView.setText(rep.getTitle());
        repStateTextView.setText(rep.getState());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Rep> reps = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_SAVED_MEMBERS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    reps.add(snapshot.getValue(Rep.class));
                }
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, RepDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("reps", Parcels.wrap(reps));
                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
