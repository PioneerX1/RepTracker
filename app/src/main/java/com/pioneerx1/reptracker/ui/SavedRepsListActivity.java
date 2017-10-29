package com.pioneerx1.reptracker.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
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

public class SavedRepsListActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_reps_list);

    }


}
