package com.zjp.app.bottomtab.bottomnavigationviewactivity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.bottomtab.bottomtablayout.DataGenerator;
import com.zjp.app.databinding.ActivityBottomNavigationViewAcBinding;

/**
 * Created by zjp on 2018/9/18 15:28
 */
public class BottomNavigationViewActivity extends BaseActivity<ActivityBottomNavigationViewAcBinding> {

    private Fragment[]mFragments;

    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_bottom_navigation_view_ac;
    }

    @Override
    public void initView() {
        mFragments = DataGenerator.getFragments("BottomNavigationView Tab");
        mViewBinding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onTabItemSelected(item.getItemId());
                return true;
            }
        });
        // 由于第一次进来没有回调onNavigationItemSelected，因此需要手动调用一下切换状态的方法
        onTabItemSelected(R.id.tab_menu_home);
    }

    private void onTabItemSelected(int id){
        Fragment fragment = null;
        switch (id){
            case R.id.tab_menu_home:
                fragment = mFragments[0];
                break;
            case R.id.tab_menu_discovery:
                fragment = mFragments[1];
                break;

            case R.id.tab_menu_attention:
                fragment = mFragments[2];
                break;
            case R.id.tab_menu_profile:
                fragment = mFragments[3];
                break;
        }
        if(fragment!=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
        }
    }
}
