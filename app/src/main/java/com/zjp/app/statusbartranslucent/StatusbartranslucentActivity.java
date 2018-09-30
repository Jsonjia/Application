package com.zjp.app.statusbartranslucent;


import android.view.View;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.databinding.ActivityStatusbartranslucentBinding;
import com.zjp.app.statusbartranslucent.status_translucent1.StatusbartranslucentActivity1;

/**
 * Created by zjp on 2018/9/30 14:48
 */
public class StatusbartranslucentActivity extends BaseActivity<ActivityStatusbartranslucentBinding> {


    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_statusbartranslucent;
    }

    @Override
    public void initView() {

        mViewBinding.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(StatusbartranslucentActivity1.class);
            }
        });

    }
}
