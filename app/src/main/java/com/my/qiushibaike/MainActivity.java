package com.my.qiushibaike;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.my.qiushibaike.adapters.CommonFragmentPagerAdapter;
import com.my.qiushibaike.entities.QiuShiType;
import com.my.qiushibaike.widgets.PagerEnabledSlidingPaneLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private PagerEnabledSlidingPaneLayout sliding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliding = (PagerEnabledSlidingPaneLayout) findViewById(R.id.drawer);
        NavigationView menu = (NavigationView) findViewById(R.id.menu);
        menu.setNavigationItemSelectedListener(this);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        pager.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(), QiuShiType.getList()));

        tab.setupWithViewPager(pager);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        sliding.closePane();

        return true;

    }
}
