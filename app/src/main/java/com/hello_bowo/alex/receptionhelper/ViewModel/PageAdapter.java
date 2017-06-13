package com.hello_bowo.alex.receptionhelper.ViewModel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hello_bowo.alex.receptionhelper.FindActivityPage;
import com.hello_bowo.alex.receptionhelper.FindRoomPage;

/**
 * Created by Alex on 13/06/2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int _tabCount;

    public PageAdapter(FragmentManager fm, int tabCount)
    {
        super(fm);
        this._tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FindRoomPage();
            case 1:
                return new FindActivityPage();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return _tabCount;
    }
}
