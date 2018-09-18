package com.zjp.app.bottomtab;


import android.view.View;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.bottomtab.bottomnavigationview_ex.BottomNavigationViewExActivity;
import com.zjp.app.bottomtab.bottomnavigationviewactivity.BottomNavigationViewActivity;
import com.zjp.app.bottomtab.bottomtablayout.BottomTabLayoutActivity;
import com.zjp.app.bottomtab.customtab.CustomTabActivity;
import com.zjp.app.bottomtab.fragmenttabhost.FragmentTabHostActivity;
import com.zjp.app.bottomtab.radiobottom.RadioGroupTabActivity;
import com.zjp.app.databinding.ActivityBottomtabBinding;

/**
 * Created by zjp on 2018/9/18 14:49
 */
public class BottomTabActivity extends BaseActivity<ActivityBottomtabBinding> {

    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_bottomtab;
    }

    @Override
    public void initView() {

        mViewBinding.tabLayoutTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(BottomTabLayoutActivity.class);
            }
        });

        mViewBinding.tabBottomNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(BottomNavigationViewActivity.class);
            }
        });

        mViewBinding.tabFragmentTabHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(FragmentTabHostActivity.class);
            }
        });

        mViewBinding.tabRadioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(RadioGroupTabActivity.class);
            }
        });

        mViewBinding.tabCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(CustomTabActivity.class);
            }
        });

        mViewBinding.tabnavigationViewEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(BottomNavigationViewExActivity.class);
            }
        });
    }
}
