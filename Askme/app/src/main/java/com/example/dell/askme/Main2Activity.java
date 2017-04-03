package com.example.dell.askme;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//import android.graphics.Color;
//import com.google.firebase.auth.AuthResult;

public class Main2Activity extends AppCompatActivity {
public EditText emailField;
    public EditText passwordField;
    Button signup;

    private  FirebaseAuth Auth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    String TAG ="h";
    private View myview;
    public int color1, color2, red1, red2, blue1, blue2, green1, green2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        emailField = (EditText)findViewById(R.id.emailField);
        passwordField = (EditText)findViewById(R.id.passwordField);
        Auth = FirebaseAuth.getInstance();
        signup = (Button)findViewById(R.id.signup);
        myview =(View)findViewById(R.id.activity_main2);
    signup.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            //startSignIn();
            startActivity(new Intent(Main2Activity.this,UInterface.class));
        }
    });
// Generate color1 before starting the thread
        red1 = (int)(Math.random() * 128 + 127);
        green1 = (int)(Math.random() * 128 + 127);
        blue1 = (int)(Math.random() * 128 + 127);
        color1 = 0xff << 24 | (red1 << 16) |
                (green1 << 8) | blue1;


        new Thread() {
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Main2Activity.this.runOnUiThread(new Runnable() {
                        public void run() {

                            //generate color 2

                            red2 = (int)(Math.random() * 128 + 127);
                            green2 = (int)(Math.random() * 128 + 127);
                            blue2 = (int)(Math.random() * 128 + 127);
                            color2 = 0xff << 24 | (red2 << 16) |
                                    (green2 << 8) | blue2;

                            //start animation
                            View v = findViewById(R.id.activity_main2);
                            ObjectAnimator anim = ObjectAnimator.ofInt(v, "backgroundColor", color1, color2);


                            anim.setEvaluator(new ArgbEvaluator());
                            anim.setRepeatCount(ValueAnimator.INFINITE);
                            anim.setRepeatMode(ValueAnimator.REVERSE);
                            anim.setDuration(3000);
                            anim.start();

                            // Now set color1 to color2
                            // This way, the background will go from
                            // the previous color to the next color
                            // smoothly
                            color1 = color2;

                        }
                    });
                }
            }
        }.start();
            // ...
            mAuthListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user != null) {
                        // User is signed in
                        Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                        startActivity(new Intent(Main2Activity.this,Main3Activity.class));

                    } else {
                        // User is signed out
                        Log.d(TAG, "onAuthStateChanged:signed_out");
                    }
                    // ...
                }
            };
            // ...







    }
    public void onStart() {
        super.onStart();
        Auth.addAuthStateListener(mAuthListener);

    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            Auth.removeAuthStateListener(mAuthListener);
        }
    }
    private void startSignIn() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(Main2Activity.this, "fields are empty!!", Toast.LENGTH_LONG);
        }
        else{
        Auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Main2Activity.this, "your email and password doesn't matcb", Toast.LENGTH_LONG);
                }
                else {
                    startActivity(new Intent(Main2Activity.this,Main3Activity.class));
                }
            }
        });
    }
    }

}
