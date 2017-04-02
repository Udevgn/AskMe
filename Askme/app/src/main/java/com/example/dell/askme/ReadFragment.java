package com.example.dell.askme;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.onClick;
import static android.R.id.list;
import static android.support.v7.widget.AppCompatDrawableManager.get;
import static com.example.dell.askme.ReadFragment.getData;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadFragment extends Fragment {
    private DatabaseReference mDatabase;
    private RecyclerView recyclerView;
    private MyRecycleAdapter myRecycleAdapter;
    public ReadFragment() {
        // Required empty public constructor

        mDatabase = FirebaseDatabase.getInstance().getReference("questions");


        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    {
                        //String e_mail = (String) messageSnapshot.child("email").getValue();
                        String qvalue = (String) messageSnapshot.child("Question").getValue();


                        if ("why?".equals(qvalue)) {
                         //   Toast.makeText(getContext(), "HI", Toast.LENGTH_SHORT).show();
                            //flag=1;
                            break;
                        }
                    }
                }

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_read, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.myrecyclerview);
        recyclerView.setHasFixedSize(true);
        myRecycleAdapter = new MyRecycleAdapter(getActivity(),getData());
        recyclerView.setAdapter(myRecycleAdapter);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        return  view;
    }
    public static List<QDatabase> getData(){
        List<QDatabase> data = new ArrayList<QDatabase>();
        for(int i =0;i<10;i++){
            QDatabase qDatabase = new QDatabase("how many times do you play games in day?", "atleast three","atlest two","atleast one","nothing","utkarshdevgan",76,56,23," dd");
             data.add(qDatabase);
        }
         return data;
    }


}
