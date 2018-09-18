package com.zjp.app.bottomtab.bottomtablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.databinding.ActivityBottomTabLayoutAcBinding;

/**
 * Created by zjp on 2018/9/18 15:06
 */
public class BottomTabLayoutActivity extends BaseActivity<ActivityBottomTabLayoutAcBinding> {

    private Fragment[] mFragmensts;

    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_bottom_tab_layout_ac;
    }

    @Override
    public void initView() {
        mFragmensts = DataGenerator.getFragments("TabLayout Tab");

        mViewBinding.bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());

                for (int i = 0; i < mViewBinding.bottomTabLayout.getTabCount(); i++) {
                    View view = mViewBinding.bottomTabLayout.getTabAt(i).getCustomView();
                    ImageView icon = (ImageView) view.findViewById(R.id.tab_content_image);
                    TextView text = (TextView) view.findViewById(R.id.tab_content_text);
                    if (i == tab.getPosition()) {
                        icon.setImageResource(DataGenerator.mTabResPressed[i]);
                        text.setTextColor(getResources().getColor(android.R.color.black));
                    } else {
                        icon.setImageResource(DataGenerator.mTabRes[i]);
                        text.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        for (int i = 0; i < 4; i++) {
            mViewBinding.bottomTabLayout.addTab(mViewBinding.bottomTabLayout.newTab().setCustomView(DataGenerator.getTabView(this, i)));
        }
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
