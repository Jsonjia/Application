package com.zjp.app.wx_ninephotos;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by zjp on 2018/9/19 13:16
 */
public class ImageActivity extends BaseActivity {

    private PhotoViewPager viewpage;

    private String[] list;
//    private int position;

    private PopAdapter popAdapter;

    public static void startActivity(Context context, Pair<View, String> imageView, int position, String[] list) {
        Intent intent = new Intent(context, ImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArray("STRLIST", list);
        intent.putExtra("IMG", position);
        intent.putExtras(bundle);
        if (Build.VERSION.SDK_INT > 21) {
            context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context, imageView).toBundle());
        } else {
            context.startActivity(intent);
        }
    }


    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_image;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initView() {
        Intent intent = getIntent();
        list = intent.getStringArrayExtra("STRLIST");
//        position = intent.getIntExtra("IMG", 0);

        viewpage = findViewById(R.id.viewpage);
        viewpage.setTransitionName("img" + intent.getIntExtra("IMG", 0));

        popAdapter = new PopAdapter(list);
        viewpage.setAdapter(popAdapter);
        viewpage.setCurrentItem(intent.getIntExtra("IMG", 0));

        viewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                viewpage.setTransitionName("img" + position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    class PopAdapter extends PagerAdapter {

        String[] look_imgs;

        public PopAdapter(String[] look_imgs) {
            this.look_imgs = look_imgs;
        }

        @Override
        public int getCount() {
            return look_imgs.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ((ViewPager) container).removeView((View) object);
        }


        @NonNull
        @Override
        public Object instantiateItem(@NonNull final ViewGroup container, int position) {
            View view = View.inflate(container.getContext(), R.layout.item_pic_show, null);
            PhotoView pic_photoview = view.findViewById(R.id.pic_photoview);
            Glide.with(container.getContext()).load(look_imgs[position]).into(pic_photoview);

            pic_photoview.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    ((ImageActivity) container.getContext()).supportFinishAfterTransition();
                }

                @Override
                public void onOutsidePhotoTap() {

                }
            });
            container.addView(view);
            return view;
        }

    }
}
