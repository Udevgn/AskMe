package com.example.dell.askme;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import static android.R.attr.onClick;
import static android.R.id.list;
import static android.support.v7.widget.AppCompatDrawableManager.get;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadFragment extends Fragment {
    private DatabaseReference mDatabase;
  private ListView feedlist;
    public ReadFragment() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_read, container, false);
        feedlist = (ListView)view.findViewById(R.id.feed);
        feedlist.setAdapter(new SingleRowAdapter(getContext()));
        return  view;
    }
class SingleRow{
    public String Question;
    public String opt1;
    public String opt2;
    public String opt3;
    public String opt4;
    public int comm_count;
    public int upvote_count;
    public int downvote_count;
    SingleRow(String Question,String opt1,String opt2,String opt3,String opt4,int comm_count,int upvote_count,int downvote_count){
        this.Question = Question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.comm_count = comm_count;
        this.upvote_count = upvote_count;
        this.downvote_count = downvote_count;

    }
}
    class SingleRowAdapter extends BaseAdapter{
        ArrayList<SingleRow> postlist ;
        Context context;
        SingleRowAdapter(Context c){
            postlist = new ArrayList<SingleRow>();
        String[] Qs  = new String[]{"hello how are you buddy whats going on?","hello can u do this huhhh?"};
            String f_options[][] = new  String[][]{{"a"},{"a"}};
            String s_options[][] = new String[][]{{"b"},{"b"}};
            String t_options[][] = new String[][]{{"c"},{"c"}};
            String fo_options[][] = new String[][]{{"d"},{"d"}};
            context = c;
            for(int i=0;i<2;i++){

                    postlist.add(new SingleRow(Qs[i],"a","b","c","d",23,45,67));

            }

        }

        @Override
        public long getItemId(int position) {
             return  position;
        }

        @Override
        public Object getItem(int position) {
            return  postlist.get(position);
        }

        @Override
        public int getCount() {
            return postlist.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
          LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          View row = layoutInflater.inflate(R.layout.post,parent,false);
            TextView Ques = (TextView)row.findViewById(R.id.Ques);
            TextView opt1 = (TextView)row.findViewById(R.id.opt1);
            TextView opt2 = (TextView)row.findViewById(R.id.opt2);
            TextView opt3 = (TextView)row.findViewById(R.id.opt3);
            TextView opt4 = (TextView)row.findViewById(R.id.opt4);
            TextView downvote = (TextView)row.findViewById(R.id.downvote);
            TextView upvote = (TextView)row.findViewById(R.id.upvote);
            TextView comment = (TextView)row.findViewById(R.id.comment);
            SingleRow prow = postlist.get(position);
            Ques.setText(prow.Question);
            opt1.setText(prow.opt1);
            opt2.setText(prow.opt2);
            opt3.setText(prow.opt3);
            opt4.setText(prow.opt4);
            downvote.setText(prow.downvote_count+"");
            upvote.setText(prow.upvote_count+"");
            comment.setText(prow.comm_count+"");
            comment.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    
                }
            });
        return row;
        }
    }

}
