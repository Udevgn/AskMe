package com.example.dell.askme;

/**
 * Created by DELL on 4/1/2017.
 */

public class UserDatabase {
    String username;
    String following ;
    String follows ;
    String name;
    String sirname;
    int profile_pic;
    public static UserDatabase userDatabase;
    public UserDatabase(String following, String name, String follows, String sirname, String username) {
        this.following = following;
        this.name = name;
        this.follows = follows;
        this.sirname = sirname;
        this.username = username;
    }
    public void setImage(int profile_pic){
        this.profile_pic = profile_pic;
    }

}
