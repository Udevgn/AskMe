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
    public String Username;
    private DatabaseReference mDatabase;


    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public QDatabase() {
    }

    public QDatabase(String Question, String option1,String option2,String option3,String option4,String Username) {
        this.Question = Question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3= option3;
        this.option4 = option4;
        this.Username = Username;
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
}
