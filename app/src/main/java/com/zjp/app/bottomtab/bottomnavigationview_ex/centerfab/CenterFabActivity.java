package com.zjp.app.bottomtab.bottomnavigationview_ex.centerfab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.base.BaseFragment;
import com.zjp.app.databinding.ActivityCenterFabBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjp on 2018/9/18 17:02
 */
public class CenterFabActivity extends BaseActivity<ActivityCenterFabBinding> {

    private List<Fragment> fragments;
    private VpAdapter adapter;

    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_center_fab;
    }

    @Override
    public void initView() {
        initDatas();
        initViews();
        initEvent();
    }

    /**
     * create fragments
     */
    private void initDatas() {
        fragments = new ArrayList<>(4);

        // create music fragment and add it
        BaseFragment musicFragment = new BaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", getString(R.string.music));
        musicFragment.setArguments(bundle);

        // create backup fragment and add it
        BaseFragment backupFragment = new BaseFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.backup));
        backupFragment.setArguments(bundle);

        // create friends fragment and add it
        BaseFragment favorFragment = new BaseFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.favor));
        favorFragment.setArguments(bundle);

        // create friends fragment and add it
        BaseFragment visibilityFragment = new BaseFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.visibility));
        visibilityFragment.setArguments(bundle);


        // add to fragments for adapter
        fragments.add(musicFragment);
        fragments.add(backupFragment);
        fragments.add(favorFragment);
        fragments.add(visibilityFragment);
    }


    /**
     * change BottomNavigationViewEx style
     */
    private void initViews() {
        mViewBinding.bnve.enableItemShiftingMode(false);
        mViewBinding.bnve.enableShiftingMode(false);
        mViewBinding.bnve.enableAnimation(false);

        // set adapter
        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        mViewBinding.vp.setAdapter(adapter);
    }

    /**
     * set listeners
     */
    private void initEvent() {
        // set listener to change the current item of view pager when click bottom nav item
        mViewBinding.bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private int previousPosition = -1;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int position = 0;
                switch (item.getItemId()) {
                    case R.id.i_music:
                        position = 0;
                        break;
                    case R.id.i_backup:
                        position = 1;
                        break;
                    case R.id.i_favor:
                        position = 2;
                        break;
                    case R.id.i_visibility:
                        position = 3;
                        break;
                    case R.id.i_empty: {
                        return false;
                    }
                }
                if (previousPosition != position) {
                    mViewBinding.vp.setCurrentItem(position, false);
                    previousPosition = position;
                }

                return true;
            }
        });

        // set listener to change the current checked item of bottom nav when scroll view pager
        mViewBinding.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position >= 2)// 2 is center
                    position++;// if page is 2, need set bottom item to 3, and the same to 3 -> 4
                mViewBinding.bnve.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // center item click listener
        mViewBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CenterFabActivity.this, "Center", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * view pager adapter
     */
    private static class VpAdapter extends FragmentPagerAdapter {
        private List<Fragment> data;

        public VpAdapter(FragmentManager fm, List<Fragment> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }
    }
}
