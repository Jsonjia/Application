package com.zjp.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zjp.app.base.BaseActivity;
import com.zjp.app.bottomtab.BottomTabActivity;
import com.zjp.app.databinding.ActivityMainBinding;
import com.zjp.app.statusbartranslucent.StatusbartranslucentActivity;
import com.zjp.app.wx_ninephotos.WxNinePhotoActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        mViewBinding.btnPhotoClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(WxNinePhotoActivity.class);
            }
        });

        mViewBinding.btnBottomTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(BottomTabActivity.class);
            }
        });

        mViewBinding.chenjinshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(StatusbartranslucentActivity.class);
            }
        });

    }
}
