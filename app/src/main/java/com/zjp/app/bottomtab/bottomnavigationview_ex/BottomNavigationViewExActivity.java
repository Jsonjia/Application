package com.zjp.app.bottomtab.bottomnavigationview_ex;

import android.view.View;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.bottomtab.bottomnavigationview_ex.centerfab.CenterFabActivity;
import com.zjp.app.databinding.ActivityBottomnavigationexBinding;

/**
 * Created by zjp on 2018/9/18 16:38
 */
public class BottomNavigationViewExActivity extends BaseActivity<ActivityBottomnavigationexBinding> {

    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_bottomnavigationex;
    }

    @Override
    public void initView() {

        mViewBinding.btnCenterFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(CenterFabActivity.class);
            }
        });

    }
}
