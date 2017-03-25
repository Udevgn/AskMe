package com.example.dell.askme;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by DELL on 2/19/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

  ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabTiltles = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm){
       super(fm);
    }
    public void addFragments(Fragment fragment,String titles){
        this.fragments.add(fragment);
        this.tabTiltles.add(titles);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTiltles.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
}