package com.zjp.app.bottomtab.radiobottom;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.bottomtab.bottomtablayout.DataGenerator;
import com.zjp.app.databinding.ActivityRadiogroupTabLayoutBinding;

/**
 * Created by zjp on 2018/9/18 15:44
 */
public class RadioGroupTabActivity extends BaseActivity<ActivityRadiogroupTabLayoutBinding> {

    private Fragment[]mFragments;

    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_radiogroup_tab_layout;
    }

    @Override
    public void initView() {
        mFragments = DataGenerator.getFragments("RadioGroup Tab");

        mViewBinding.radioGroupButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            Fragment mFragment = null;
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radio_button_home:
                        mFragment = mFragments[0];
                        break;
                    case R.id.radio_button_discovery:
                        mFragment = mFragments[1];
                        break;
                    case R.id.radio_button_attention:
                        mFragment = mFragments[2];
                        break;
                    case R.id.radio_button_profile:
                        mFragment = mFragments[3];
                        break;
                }
                if (mFragments != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_container, mFragment).commit();
                }
            }
        });
        // 保证第一次会回调OnCheckedChangeListener
        mViewBinding.radioButtonHome.setChecked(true);
    }
}
