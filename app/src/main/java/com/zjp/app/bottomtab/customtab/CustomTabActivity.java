package com.zjp.app.bottomtab.customtab;

import android.support.v4.app.Fragment;
import android.view.View;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.bottomtab.bottomtablayout.DataGenerator;
import com.zjp.app.databinding.ActivityCustomTabAcLayoutBinding;

/**
 * Created by zjp on 2018/9/18 15:48
 */
public class CustomTabActivity extends BaseActivity<ActivityCustomTabAcLayoutBinding> implements CustomTabView.OnTabCheckListener {

    private Fragment[] mFragmensts;

    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_custom_tab_ac_layout;
    }

    @Override
    public void initView() {
        mFragmensts = DataGenerator.getFragments("CustomTabView Tab");

        CustomTabView.Tab tabHome = new CustomTabView.Tab().setText("首页")
                .setColor(getResources().getColor(android.R.color.darker_gray))
                .setCheckedColor(getResources().getColor(android.R.color.black))
                .setNormalIcon(R.mipmap.ic_tab_strip_icon_feed)
                .setPressedIcon(R.mipmap.ic_tab_strip_icon_feed_selected);
        mViewBinding.customTabContainer.addTab(tabHome);
        CustomTabView.Tab tabDis = new CustomTabView.Tab().setText("发现")
                .setColor(getResources().getColor(android.R.color.darker_gray))
                .setCheckedColor(getResources().getColor(android.R.color.black))
                .setNormalIcon(R.mipmap.ic_tab_strip_icon_category)
                .setPressedIcon(R.mipmap.ic_tab_strip_icon_category_selected);
        mViewBinding.customTabContainer.addTab(tabDis);
        CustomTabView.Tab tabAttention = new CustomTabView.Tab().setText("管制")
                .setColor(getResources().getColor(android.R.color.darker_gray))
                .setCheckedColor(getResources().getColor(android.R.color.black))
                .setNormalIcon(R.mipmap.ic_tab_strip_icon_pgc)
                .setPressedIcon(R.mipmap.ic_tab_strip_icon_pgc_selected);
        mViewBinding.customTabContainer.addTab(tabAttention);
        CustomTabView.Tab tabProfile = new CustomTabView.Tab().setText("我的")
                .setColor(getResources().getColor(android.R.color.darker_gray))
                .setCheckedColor(getResources().getColor(android.R.color.black))
                .setNormalIcon(R.mipmap.ic_tab_strip_icon_profile)
                .setPressedIcon(R.mipmap.ic_tab_strip_icon_profile_selected);
        mViewBinding.customTabContainer.addTab(tabProfile);

        mViewBinding.customTabContainer.setOnTabCheckListener(this);

        mViewBinding.customTabContainer.setCurrentItem(0);
    }

    @Override
    public void onTabSelected(View v, int position) {
        onTabItemSelected(position);
    }

    private void onTabItemSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = mFragmensts[0];
                break;
            case 1:
                fragment = mFragmensts[1];
                break;

            case 2:
                fragment = mFragmensts[2];
                break;
            case 3:
                fragment = mFragmensts[3];
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
        }
    }
}
