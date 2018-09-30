package com.zjp.app.statusbartranslucent.status_translucent1;

import android.view.View;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.zjp.app.R;
import com.zjp.app.base.BaseFragment;
import com.zjp.app.bottomtab.TestBaseFragment;
import com.zjp.app.databinding.FragmentMainTabLayoutBinding;

/**
 * Created by zjp on 2018/9/30 15:08
 */
public class MainTabFragment extends BaseFragment<FragmentMainTabLayoutBinding> {

    private boolean isFirst = true;
    private String images[] = {"file:///android_asset/1.jpg", "file:///android_asset/2.jpg", "file:///android_asset/3.jpg"};

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_tab_layout;
    }

    @Override
    protected void initView() {
        getActivity().getWindow()
                .getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        mStatusBarView.setVisibility(View.GONE);

        //        ViewColor.MIUISetStatusBarLightMode(getActivity().getWindow(), false); //设置miui状态栏字体颜色
        ViewColor.FlymeSetStatusBarLightMode(getActivity().getWindow(), false); //不加这一步，在魅族手机状态栏适配失败
    }

    @Override
    protected void initData() {
        initSliderLayout(images);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (!hidden) {
            getActivity().getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            mStatusBarView.setVisibility(View.GONE);

//        ViewColor.MIUISetStatusBarLightMode(getActivity().getWindow(), false); //设置miui状态栏字体颜色
            ViewColor.FlymeSetStatusBarLightMode(getActivity().getWindow(), false); //不加这一步，在魅族手机状态栏适配失败
        }

    }

    private void initSliderLayout(String[] promotionList) {
        if (isFirst) {
            for (int i = 0; i < promotionList.length; i++) {
                final String promotionsBean = promotionList[i];
                DefaultSliderView textSliderView = new DefaultSliderView(getContext());
//            textSliderView.description(item.getInfo());//标题
                textSliderView.image(promotionsBean);//加载图片
                textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {

                    }
                });

                mViewBinding.layoutSlider.addSlider(textSliderView);
            }
            isFirst = false;
        }
    }

    @Override
    protected void initListener() {

    }
}
