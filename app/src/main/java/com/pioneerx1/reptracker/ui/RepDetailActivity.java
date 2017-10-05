package com.pioneerx1.reptracker.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.pioneerx1.reptracker.R;
import com.pioneerx1.reptracker.adapters.RepPagerAdapter;
import com.pioneerx1.reptracker.models.Rep;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RepDetailActivity extends AppCompatActivity {

    @Bind(R.id.repViewPager) ViewPager mViewPager;
    private RepPagerAdapter adapterViewPager;
    ArrayList<Rep> mReps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_detail);
        ButterKnife.bind(this);

        mReps = Parcels.unwrap(getIntent().getParcelableExtra("reps"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new RepPagerAdapter(getSupportFragmentManager(), mReps);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
