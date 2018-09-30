package com.zjp.app.statusbartranslucent.status_translucent1;

import android.view.View;

import com.zjp.app.R;
import com.zjp.app.base.BaseFragment;
import com.zjp.app.databinding.FragmentDiscoverLayoutBinding;

/**
 * Created by zjp on 2018/9/30 15:27
 */
public class DiscoverTabFragment extends BaseFragment<FragmentDiscoverLayoutBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discover_layout;
    }

    @Override
    protected void initView() {
//        mViewBinding
//        back.setVisibility(View.INVISIBLE);
//        titleName.setText(R.string.discover_title);
//
//        getActivity().getWindow()
//                .getDecorView()
//                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        ViewColor.FlymeSetStatusBarLightMode(getActivity().getWindow(), true); //不加这一步，在魅族手机状态栏适配失败
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            getActivity().getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            ViewColor.FlymeSetStatusBarLightMode(getActivity().getWindow(), true); //不加这一步，在魅族手机状态栏适配失败
//        ViewColor.MIUISetStatusBarLightMode(getActivity().getWindow(), false); //设置miui状态栏字体颜色
        }
    }
}
