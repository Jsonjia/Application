package com.zjp.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zjp.app.base.BaseActivity;
import com.zjp.app.bottomtab.BottomTabActivity;
import com.zjp.app.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {


        mViewBinding.btnBottomTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(BottomTabActivity.class);
            }
        });

    }
}
