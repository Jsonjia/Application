package com.zjp.app.statusbartranslucent.status_translucent1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.databinding.ActivityStatusbartranslucent1Binding;

/**
 * Created by zjp on 2018/9/30 15:07
 */
public class StatusbartranslucentActivity1 extends BaseActivity<ActivityStatusbartranslucent1Binding> {

    @DrawableRes
    private int mImages[] = {R.drawable.tab_main_selector, R.drawable.tab_discover_selector, R.drawable.tab_my_selector};
    private String mFragmentTags[] = {"首页", "发现", "我的"};
    private String mTags[] = {"main_id", "find_id", "mine_id"};
    private Class mFragmentClasses[] = {MainTabFragment.class, DiscoverTabFragment.class, MyTabFragment.class};
    private String mCurrentSelectTab;
    private boolean isBackFind = false;

    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_statusbartranslucent1;
    }

    @Override
    public void initView() {
        initState();
        mViewBinding.tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        mViewBinding.tabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE); //去掉分割线
        for (int i = 0; i < mImages.length; i++) {
            // Tab按钮添加文字和图片
            TabHost.TabSpec tabSpec = mViewBinding.tabhost.newTabSpec(mTags[i]).setIndicator(getImageView(i));
            // 添加Fragment
            mViewBinding.tabhost.addTab(tabSpec, mFragmentClasses[i], null);
            // 设置Tab按钮的背景
            mViewBinding.tabhost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.tab_bar_color);
        }

        mViewBinding.tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                mCurrentSelectTab = tabId;
            }
        });
    }

    // 获得图片资源
    private View getImageView(int index) {
        @SuppressLint("InflateParams")
        View view = getLayoutInflater().inflate(R.layout.view_tab_indicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_iv_image);
        TextView textView = (TextView) view.findViewById(R.id.tab_tv_text);
        imageView.setImageResource(mImages[index]);
        textView.setText(mFragmentTags[index]);
        return view;
    }

    /**
     * 沉浸式状态栏
     */
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { //透明状态栏
          /*  getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);*/
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //透明导航栏
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mViewBinding.tabhost != null && mCurrentSelectTab != null) {
            mViewBinding.tabhost.onTabChanged(mCurrentSelectTab);
            if (isBackFind) {
                mViewBinding.tabhost.setCurrentTab(1);
                isBackFind = false;
            }
        }
    }

}
