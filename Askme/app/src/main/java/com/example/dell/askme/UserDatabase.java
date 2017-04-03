package com.example.dell.askme;

import static com.example.dell.askme.R.id.following;

/**
 * Created by DELL on 4/1/2017.
 */

public class UserDatabase {
    String username;
   public static long following=0 ;
    public static  long  followers=0 ;
    public static  String name;
    String sirname;
    int profile_pic;
    public static UserDatabase userDatabase;
   public void assignuserName(String username){
       UserDatabase.name = username;
   }

    public void incrementFollowers(){
        UserDatabase.followers ++;
    }
    public void incrementFollowing(){
        UserDatabase.following++;
    }
}
