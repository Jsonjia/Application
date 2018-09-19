package com.zjp.app.wx_ninephotos;

import android.view.View;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.databinding.ActivityWxninePhotoBinding;

/**
 * Created by zjp on 2018/9/19 11:18
 */
public class WxNinePhotoActivity extends BaseActivity<ActivityWxninePhotoBinding> {


    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_wxnine_photo;
    }

    @Override
    public void initView() {
        mViewBinding.tvWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity(WeChatImgActivity.class);
            }
        });
    }
}
