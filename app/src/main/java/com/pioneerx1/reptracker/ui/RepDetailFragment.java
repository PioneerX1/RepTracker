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

        mRepNameTextView.setText(mRep.getName());
        mRepMemberIdTextView.setText(mRep.getMemberId());
        Log.d("Missed Votes: ", mRep.getMissedVotes());

        return view;
    }

}

