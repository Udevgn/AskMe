package com.example.dell.askme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Created by DELL on 3/31/2017.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
    LayoutInflater inflater;
    List<QDatabase> data = Collections.emptyList();
    public MyRecycleAdapter(Context context,List<QDatabase> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(parent.getContext()).inflate(R.layout.post,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
   QDatabase qdatabase = data.get(position);
        holder.Ques.setText(qdatabase.Question);
        holder.opt1.setText(qdatabase.option1);
        holder.opt2.setText(qdatabase.option2);
        holder.opt3.setText(qdatabase.option3);
        holder.opt4.setText(qdatabase.option4);
        holder.downvote_count.setText(qdatabase.downvote_count+"");
        holder.upvote_count.setText(qdatabase.upvote_count+"");
        holder.comm_count.setText(qdatabase.comm_count+"");


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Ques ;
        TextView opt1 ;
        TextView opt2 ;
        TextView opt3 ;
        TextView opt4 ;
        TextView downvote_count ;
        TextView upvote_count ;
        TextView comm_count;
        public MyViewHolder(View itemView) {
            super(itemView);
            Ques = (TextView)itemView.findViewById(R.id.Ques);
            opt1 = (TextView)itemView.findViewById(R.id.opt1);
            opt2 = (TextView)itemView.findViewById(R.id.opt2);
            opt3 = (TextView)itemView.findViewById(R.id.opt3);
            opt4 = (TextView)itemView.findViewById(R.id.opt4);
            downvote_count = (TextView)itemView.findViewById(R.id.downvote_count);
            upvote_count = (TextView)itemView.findViewById(R.id.upvote_count);
            comm_count = (TextView)itemView.findViewById(R.id.comm_count);
        }
    }
}
