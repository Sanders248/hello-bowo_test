package com.hello_bowo.alex.receptionhelper;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.hello_bowo.alex.receptionhelper.ViewModel.PageAdapter;

public class MainActivity extends AppCompatActivity  implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    boolean _tabSelectedChanged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bindViews();
        populateViews();
    }

    private void bindViews()
    {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Find a Room"));
        tabLayout.addTab(tabLayout.newTab().setText("Find an Activity"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);
    }

    private void populateViews()
    {
        _tabSelectedChanged = false;
        //Creating our pager adapter
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);

        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (position == tabLayout.getSelectedTabPosition())
                _tabSelectedChanged = false;

            if (!_tabSelectedChanged) {
                if (position == 0 && tabLayout.getSelectedTabPosition() == 1)
                    tabLayout.getTabAt(0).select();
                else if (position == 1 && tabLayout.getSelectedTabPosition() == 0)
                    tabLayout.getTabAt(1).select();
            }
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (viewPager.getCurrentItem() != tab.getPosition())
            _tabSelectedChanged = true;

        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
