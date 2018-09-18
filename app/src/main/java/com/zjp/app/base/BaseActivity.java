package com.zjp.app.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by zjp on 2018/9/13 11:06
 */
public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {

    public B mViewBinding;
    protected Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getInflaterLayout() != 0) {
            mViewBinding = DataBindingUtil.setContentView(this, getInflaterLayout());
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        initView();
        initData();
    }

    @LayoutRes
    protected abstract int getInflaterLayout();

    public abstract void initView();

    public void initData() {
    }

    protected void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(this, clz);
        if (ex != null)
            intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity)
            finish();
    }

    public void gotoActivity(Class<?> clz, int requestCode) {
        gotoActivity(clz, false, requestCode);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, int requestCode) {
        gotoActivity(clz, isCloseCurrentActivity, null, requestCode);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex, int requestCode) {
        Intent intent = new Intent(this, clz);
        if (ex != null)
            intent.putExtras(ex);
        startActivityForResult(intent, requestCode);
        if (isCloseCurrentActivity)
            finish();
    }

    public void gotoActivity(Class<?> clz, String key, String value) {
        Intent intent = new Intent(this, clz);
        intent.putExtra(key, value);
        startActivity(intent);
    }
}
