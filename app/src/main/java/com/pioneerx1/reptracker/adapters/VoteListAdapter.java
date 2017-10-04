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
import com.pioneerx1.reptracker.models.Vote;
import com.pioneerx1.reptracker.ui.RepDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VoteListAdapter extends RecyclerView.Adapter<VoteListAdapter.VoteViewHolder> {

    private ArrayList<Vote> mVotes = new ArrayList<>();
    private Context mContext;

    public VoteListAdapter(Context context, ArrayList<Vote> votes) {
        mContext = context;
        mVotes = votes;
    }

    @Override
    public VoteListAdapter.VoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vote_list_item, parent, false);
        VoteListAdapter.VoteViewHolder viewHolder = new VoteListAdapter.VoteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VoteListAdapter.VoteViewHolder holder, int position) {
        holder.bindVote(mVotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mVotes.size();
    }

    public class VoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // need a bunch of @Bind statements here based on whats in vote_list_item
        @Bind(R.id.voteQuestionTextView) TextView mVoteQuestion;
        @Bind(R.id.voteDescriptionTextView) TextView mVoteDescription;
        @Bind(R.id.votePositionTextView) TextView mVotePosition;
        @Bind(R.id.voteDateAndIdTextView) TextView mVoteDateAndId;

        private Context mContext;

        public VoteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            // don't really need a click listener for votes

        }

        public void bindVote(Vote vote) {

            mVoteQuestion.setText(vote.getQuestion());
            mVoteDescription.setText(vote.getDescription());
            mVotePosition.setText(vote.getPosition());
            mVoteDateAndId.setText(vote.getVoteDate() + " / " + vote.getBillId() + " / " + vote.getMemberId());

        }
    }


}
