package com.my.qiushibaike.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.my.qiushibaike.entities.QiuShiType;
import com.my.qiushibaike.fragments.QiuShiFragment;

import java.util.List;

/**
 * Created by RACHEL on 2015/12/30.
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<QiuShiType> list;

    public CommonFragmentPagerAdapter(FragmentManager fm, List<QiuShiType> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return QiuShiFragment.newInstance(list.get(position).getType());
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}
