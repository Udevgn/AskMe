package com.example.dell.askme;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;



public class UInterface extends AppCompatActivity {
BottomBar bottombar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uinterface);
        bottombar = BottomBar.attach(this,savedInstanceState);
        bottombar.setItemsFromMenu(R.menu.menu_main4, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch(menuItemId){
                    case R.id.home:
                                HomeFragment homeFragment = new HomeFragment();
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame,homeFragment).commit();
                           break;
                    case  R.id.read:
                             ReadFragment readFragment =new ReadFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,readFragment).commit();
                           break;
                    case R.id.write:
                              WriteFragment writeFragment=new WriteFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,writeFragment).commit();
                           break;
                    case R.id.profile:
                        ProfileFragment profileFragment =new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,profileFragment).commit();
                           break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }

        });
       bottombar.mapColorForTab(0,"#f44336");
        bottombar.mapColorForTab(1,"#e91e63");
        bottombar.mapColorForTab(2,"#9c27b0");
        bottombar.mapColorForTab(3,"#673ab7");


    }


}
