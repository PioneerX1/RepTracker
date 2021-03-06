package com.pioneerx1.reptracker.adapters;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pioneerx1.reptracker.Constants;
import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.models.Rep;
import com.pioneerx1.reptracker.ui.RepDetailActivity;
import com.pioneerx1.reptracker.util.ItemTouchHelperViewHolder;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseRepViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ItemTouchHelperViewHolder {

    View mView;
    Context mContext;
    //public LinearLayout mRepDragView;
    public ImageView mRepDragView;

    public FirebaseRepViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        //itemView.setOnClickListener(this);
    }

    public void bindRep(Rep rep) {

        mRepDragView = (ImageView) mView.findViewById(R.id.dragIcon);

        // db check these R id's because they are also used for Find Reps
        TextView repNameTextView = (TextView) mView.findViewById(R.id.repNameTextView);
        TextView repTitleTextView = (TextView) mView.findViewById(R.id.repTitleTextView);
        TextView repStateTextView = (TextView) mView.findViewById(R.id.repStateTextView);

        repNameTextView.setText(rep.getName());
        repTitleTextView.setText(rep.getTitle());
        repStateTextView.setText(rep.getState() + "  /  " + rep.getParty());
    }

    @Override
    public void onClick(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        final ArrayList<Rep> reps = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_SAVED_MEMBERS)
                .child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    reps.add(snapshot.getValue(Rep.class));
                    Log.d("snapshot value", snapshot.getValue().toString());
                    Log.d("reps value", reps.get(0).toString());
                }
                Log.d("reps 1st", reps.get(0).getName() + " ");
                Log.d("reps 2nd", reps.get(1).toString());
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, RepDetailActivity.class);
                intent.putExtra("position", itemPosition);  // removed extra " " after itemPosition, was defaulting to the first saved rep
                intent.putExtra("reps", Parcels.wrap(reps));
                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onItemSelected() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, R.animator.drag_scale_on);
        set.setTarget(itemView);
        set.start();
    }

    @Override
    public void onItemClear() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, R.animator.drag_scale_off);
        set.setTarget(itemView);
        set.start();
    }

}
