package com.zjp.app.statusbartranslucent.status_translucent1;

import android.view.View;

import com.zjp.app.R;
import com.zjp.app.base.BaseFragment;
import com.zjp.app.databinding.FragmentTaskLayoutBinding;

/**
 * Created by zjp on 2018/9/30 15:31
 */
public class MyTabFragment extends BaseFragment<FragmentTaskLayoutBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_task_layout;
    }

    @Override
    protected void initView() {

        mViewBinding.titleName.setText("我的");
        mViewBinding.back.setVisibility(View.INVISIBLE);

        getActivity().getWindow()
                .getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        ViewColor.FlymeSetStatusBarLightMode(getActivity().getWindow(), true); //设置miui状态栏字体颜色
        ViewColor.MIUISetStatusBarLightMode(getActivity().getWindow(), true); //设置miui状态栏字体颜色

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {

            getActivity().getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        mStatusBarView.setBackgroundColor(Color.WHITE);


            ViewColor.FlymeSetStatusBarLightMode(getActivity().getWindow(), true); //设置miui状态栏字体颜色
            ViewColor.MIUISetStatusBarLightMode(getActivity().getWindow(), true); //设置miui状态栏字体颜色
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
