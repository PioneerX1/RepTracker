package com.pioneerx1.reptracker.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pioneerx1.reptracker.models.Rep;
import com.pioneerx1.reptracker.ui.RepDetailFragment;

import java.util.ArrayList;

public class RepPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Rep> mReps;

    public RepPagerAdapter(FragmentManager fm, ArrayList<Rep> reps) {
        super(fm);
        mReps = reps;
    }

    @Override
    public Fragment getItem(int position) {
        return RepDetailFragment.newInstance(mReps.get(position));
    }

    @Override
    public int getCount() {
        return mReps.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mReps.get(position).getName();
    }

}
