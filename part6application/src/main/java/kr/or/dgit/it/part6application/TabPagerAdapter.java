package kr.or.dgit.it.part6application;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private int tabCount; //보여줄 fragment의 개수

    public TabPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: Tab1Fragment tab1 = new Tab1Fragment();
                    return tab1;
            case 1: Tab2Fragment tab2 = new Tab2Fragment();
                return  tab2;
            case 2: Tab3Fragment tab3 = new Tab3Fragment();
                return tab3;
                default: return null;

        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
