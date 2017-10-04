package com.pioneerx1.reptracker.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.models.Rep;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RepDetailFragment extends Fragment {

    @Bind(R.id.repDetailNameTextView) TextView mRepNameTextView;
    @Bind(R.id.repDetailMemberIdTextView) TextView mRepMemberIdTextView;
    @Bind(R.id.repDetailTitleTextView) TextView mRepTitleTextView;
    @Bind(R.id.repDetailPartyTextView) TextView mRepPartyTextView;
    @Bind(R.id.repDetailStateTextView) TextView mRepStateTextView;
    @Bind(R.id.repDetailPhoneTextView) TextView mRepPhoneTextView;
    @Bind(R.id.repDetailWebsiteTextView) TextView mRepWebsiteTextView;
    @Bind(R.id.repDetailTwitterTextView) TextView mRepTwitterTextView;
    @Bind(R.id.repDetailFacebookTextView) TextView mRepFacebookTextView;
    @Bind(R.id.repDetailMissedVotesTextView) TextView mRepMissedVotesTextView;
    @Bind(R.id.repDetailVotesWithPartyTextView) TextView mRepVotesWithPartyTextView;
    @Bind(R.id.repDetailNextElectionTextView) TextView mRepNextElectionTextView;

    private Rep mRep;


    public static RepDetailFragment newInstance(Rep rep) {
        RepDetailFragment repDetailFragment = new RepDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("rep", Parcels.wrap(rep));
        repDetailFragment.setArguments(args);
        return repDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRep = Parcels.unwrap(getArguments().getParcelable("rep"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rep_detail, container, false);
        ButterKnife.bind(this, view);

        mRepNameTextView.setText("Name: " + mRep.getName());
        // mRepMemberIdTextView.setText(mRep.getMemberId());
        mRepTitleTextView.setText("Title: " + mRep.getTitle());
        mRepPartyTextView.setText("Party: " + mRep.getParty());
        mRepStateTextView.setText("State: " + mRep.getState());
        mRepPhoneTextView.setText("Phone: " + mRep.getPhone());
        mRepWebsiteTextView.setText("Website: " + mRep.getWebsite());
        mRepFacebookTextView.setText("Facebook Account: " + mRep.getFacebookAccount());
        mRepTwitterTextView.setText("Twitter Handle: " + mRep.getTwitterHandle());
        mRepMissedVotesTextView.setText("Percent of Missed Votes: " + mRep.getMissedVotes() + "%");
        mRepVotesWithPartyTextView.setText("Percent of Time Votes with Party: " + mRep.getVotesWithParty() + "%");
        mRepNextElectionTextView.setText("Next Election Year: " + mRep.getNextElection());

        getVotes(mRep.getMemberId());

        return view;
    }

    private void getVotes(String memberId) {

    }

}

