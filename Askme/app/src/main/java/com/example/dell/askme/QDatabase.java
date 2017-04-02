package com.example.dell.askme;

/**
 * Created by DELL on 2/24/2017.
 */

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import static android.R.attr.name;

@IgnoreExtraProperties
public class QDatabase {

    public String Question;
    public String option1;
    public String option2;
    public String option3;
    public String option4;

    public int comm_count;
    public int upvote_count;
    public int downvote_count;
    String comment;
    private DatabaseReference mDatabase;


    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public QDatabase() {
    }

    public QDatabase(String Question, String option1,String option2,String option3,String option4,int upvote_count,int downvote_count,int comm_count,String comment) {
        this.Question = Question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3= option3;
        this.option4 = option4;
        this.comm_count = comm_count;
        this.upvote_count = upvote_count;
        this.downvote_count = downvote_count;
        this.comment = comment;

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
}
