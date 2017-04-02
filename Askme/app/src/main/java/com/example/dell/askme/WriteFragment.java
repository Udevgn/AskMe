package com.example.dell.askme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.dell.askme.R.id.upload;
import static com.example.dell.askme.R.string.one;


/**
 * A simple {@link Fragment} subclass.
 */
public class WriteFragment extends Fragment {
    static DatabaseReference mDatabase;
    String userid;
    Button uploadpost ;
    EditText uploadquestion;
    EditText uploadoption1;
    EditText uploadoption2;
    EditText uploadoption3;
    EditText uploadoption4;
    QDatabase question;
    public WriteFragment() {
        // Required empty public constructor



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //

        Toast.makeText(getContext()," i am alive",Toast.LENGTH_LONG).show();
        View view  =inflater.inflate(R.layout.fragment_write, container, false);
        uploadquestion = (EditText) view.findViewById(R.id.uploadquestion);
        uploadoption1 = (EditText) view.findViewById(R.id.uploadoption1);
        uploadoption2 = (EditText) view.findViewById(R.id.uploadoption2);
        uploadoption3 = (EditText) view.findViewById(R.id.uploadoption3);
        uploadoption4 = (EditText) view.findViewById(R.id.uploadoption4);
        uploadpost = (Button)view.findViewById(R.id.uploadpost);
       // uploadpost.setOnClickListener(new View.OnClickListener(){
        uploadpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writePost(v);

            }
        });
//         this.writePost(container);


        //});

        return view;
    }
  public void writePost(View view){
           mDatabase= FirebaseDatabase.getInstance().getReference("questions");
          if(uploadquestion.getText().toString().isEmpty()|| uploadoption1.getText().toString().isEmpty()||uploadoption2.getText().toString().isEmpty()){
              Toast.makeText(getContext(),"required fields are empty!!",Toast.LENGTH_LONG).show();
          }
          else{

              userid = mDatabase.push().getKey();
              question = new QDatabase(uploadquestion.getText().toString(), uploadoption1.getText().toString(),uploadoption2.getText().toString(),uploadoption3.getText().toString(),uploadoption4.getText().toString(),0,0,0,"dummy");
              mDatabase.child(userid).setValue(question);
          }

  }


}
