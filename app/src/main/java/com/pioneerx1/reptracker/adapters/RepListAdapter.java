package com.pioneerx1.reptracker.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.models.Rep;
import com.pioneerx1.reptracker.ui.RepDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RepListAdapter extends RecyclerView.Adapter<RepListAdapter.RepViewHolder> {

    private ArrayList<Rep> mReps = new ArrayList<>();
    private Context mContext;

    public RepListAdapter(Context context, ArrayList<Rep> reps) {
        mContext = context;
        mReps = reps;
    }

    @Override
    public RepListAdapter.RepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rep_list_item, parent, false);
        RepViewHolder viewHolder = new RepViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RepListAdapter.RepViewHolder holder, int position) {
        holder.bindRep(mReps.get(position));
    }

    @Override
    public int getItemCount() {
        return mReps.size();
    }

    public class RepViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.repNameTextView) TextView mRepNameTextView;
        @Bind(R.id.repTitleTextView) TextView mRepTitleTextView;
        @Bind(R.id.repStateTextView) TextView mRepStateTextView;

        private Context mContext;

        public RepViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, RepDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("reps", Parcels.wrap(mReps));
            mContext.startActivity(intent);
        }

        public void bindRep(Rep rep) {
            mRepNameTextView.setText(rep.getName());
            mRepTitleTextView.setText(rep.getTitle());
            mRepStateTextView.setText(rep.getState());
        }
    }

}
