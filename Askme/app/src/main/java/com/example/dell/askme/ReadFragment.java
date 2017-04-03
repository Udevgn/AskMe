package com.example.dell.askme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


import static android.R.attr.onClick;
import static android.R.attr.version;
import static android.R.id.list;
import static android.support.v7.widget.AppCompatDrawableManager.get;
import static com.example.dell.askme.R.id.downvote_count;
import static com.example.dell.askme.R.string.one;
import static com.example.dell.askme.ReadFragment.getData;
import static com.example.dell.askme.WriteFragment.versionw;



/**
 * A simple {@link Fragment} subclass.
 */


public class ReadFragment extends Fragment {
    public static List<QDatabase> data = new ArrayList<QDatabase>();
    public static DatabaseReference mDatabase;

    private RecyclerView recyclerView;
    private MyRecycleAdapter myRecycleAdapter;
    public static  int versionr=0;

    public ReadFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       // requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        //setProgressBarIndeterminateVisibility(true);
        View view = inflater.inflate(R.layout.fragment_read, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.myrecyclerview);
        recyclerView.setHasFixedSize(true);
        myRecycleAdapter = new MyRecycleAdapter(getActivity(),getData());
        recyclerView.setAdapter(myRecycleAdapter);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //progressBar=(ProgressBar)view.findViewById((R.id.progress_bar)) ;
        //mycardview=(CardView)view.findViewById(R.id.mycardview);
        return  view;


    }

    public static List<QDatabase> getData() {
        if (versionr == WriteFragment.versionw-1){
            mDatabase = FirebaseDatabase.getInstance().getReference("questions");
           versionr++;


        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //mycardview.setVisibility(View.VISIBLE);
               //progressBar.setVisibility(View.GONE);
               //recyclerView.setVisibility(View.VISIBLE);

                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    {
                        //String e_mail = (String) messageSnapshot.child("email").getValue();
                        String qvalue = (String) messageSnapshot.child("Question").getValue();
                        String opt1 = (String) messageSnapshot.child("option1").getValue();
                        String opt2 = (String) messageSnapshot.child("option2").getValue();
                        String opt3 = (String) messageSnapshot.child("option3").getValue();
                        String opt4 = (String) messageSnapshot.child("option4").getValue();

                        // System.out.println("ppppppppppppppppppppppppp\n"+opt1+"\n"+opt2+"\n"+opt3+"\n"+opt4);
                        long comm_count = (long) messageSnapshot.child("comm_count").getValue();
                        long upvote_count = (long) messageSnapshot.child("upvote_count").getValue();
                        long downvote_count = (long) messageSnapshot.child("downvote_count").getValue();
                        String comment = "dummy";
                        QDatabase qDatabase = new QDatabase(qvalue, opt1, opt2, opt3, opt4, 76, 56, 23, comment);


                    }
                }

            }
        });
    }
         return data;
    }


}
