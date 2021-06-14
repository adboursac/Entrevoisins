package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position the position of the page
     * @return a Fragment initialized with position parameter
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NeighbourFragment();
            case 1:
                return new FavoriteNeighbourFragment();
            default:
                Log.e("NeighbourPagerAdapter:", "User clicked unknown tab with id:" + position);
                return null;
        }
    }

    /**
     * get the number of pages
     * @return 2 as the tab will always have pages
     */
    @Override
    public int getCount() {
        return 2;
    }
}