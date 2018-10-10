package com.zjp.app.base;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjp.app.statusbartranslucent.status_translucent1.ViewColor;

/**
 * Created by zjp on 2018/9/30 15:11
 */
public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

    protected Context mContext;
    private ViewGroup mView;
    public B mViewBinding;
    protected View mStatusBarView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            managerArguments(getArguments());
        }

       /* if (savedInstanceState != null) {
            mBundle = savedInstanceState.getBundle("bundle");
        } else {
            mBundle = getArguments() == null ? new Bundle() : getArguments();
        }*/

        Log.d("fragment", "Fragment……………………" + getClass().getSimpleName());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView != null) {
            ViewGroup parent = (ViewGroup) mView.getParent();
            if (parent != null) {
                parent.removeView(mView);
            }
        } else {
            mView = getCreateView(inflater, container);
            initView();
        }
        return mView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addStatusBar();
        initView();
        initData();
        initListener();
    }

    private void addStatusBar() {
        if (mStatusBarView == null) {
            mStatusBarView = new View(getContext());
            int screenWidth = getResources().getDisplayMetrics().widthPixels;
            int statusBarHeight = ViewColor.getStatusBarHeight(getActivity());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(screenWidth, statusBarHeight);
            mStatusBarView.setLayoutParams(params);
            mStatusBarView.requestLayout();
            if (mView != null)
                mView.addView(mStatusBarView, 0);
        }
    }


    /**
     * 如果Fragment创建需要数据，在这里接收传进来的数据。
     */
    protected void managerArguments(Bundle arguments) {
    }

    /**
     * 获取Fragment布局文件的View
     *
     * @param inflater
     * @param container
     * @return
     */
    private ViewGroup getCreateView(LayoutInflater inflater, ViewGroup container) {
        mViewBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return (ViewGroup) mViewBinding.getRoot();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(mContext, clz);
        if (ex != null)
            intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) {
            getActivity().finish();
        }
    }

    public void gotoActivity(Class<?> clz, String key, String value) {
        Intent intent = new Intent(mContext, clz);
        intent.putExtra(key, value);
        startActivity(intent);
    }

}
