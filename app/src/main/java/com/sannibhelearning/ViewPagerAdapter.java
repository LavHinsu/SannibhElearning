package com.sannibhelearning;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public ViewPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
//Returning the current tabs
        switch (position) {
            case 0:
                Tab2 tab2 = new Tab2();
                return tab2;
            case 1:
                Tab1 tab1 = new Tab1();
                return tab1;
            default:
                return null;
        }
    }

    //Overridden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}