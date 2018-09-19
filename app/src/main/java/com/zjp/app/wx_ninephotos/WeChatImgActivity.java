package com.zjp.app.wx_ninephotos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zjp.app.R;
import com.zjp.app.base.BaseActivity;
import com.zjp.app.databinding.ActivityWxninePhotoBinding;

import java.util.ArrayList;

/**
 * Created by zjp on 2018/9/19 11:26
 */
public class WeChatImgActivity extends BaseActivity<ActivityWxninePhotoBinding> {

    private RecyclerView act_recyclerview;

    @Override
    protected int getInflaterLayout() {
        return R.layout.activity_wechatimg;
    }

    @Override
    public void initView() {
        act_recyclerview = findViewById(R.id.act_recyclerview);
        act_recyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        String[] array = getResources().getStringArray(R.array.array);
        act_recyclerview.setAdapter(new ImageAdapter(array, WeChatImgActivity.this));
    }

    public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHoder> {

        String[] list;

        Context contex;

        public ImageAdapter(String[] list, Context context) {
            this.list = list;
            this.contex = context;
        }

        @NonNull
        @Override
        public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false);
            return new ViewHoder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHoder holder, final int position) {

            final Pair<View, String> pair = new Pair<View, String>(holder.item_imgview, "img" + position);
            Glide.with(contex).load(list[position]).thumbnail(0.4f).into(holder.item_imgview);
            holder.item_imgview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageActivity.startActivity(contex, pair, position, list);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.length;
        }

        class ViewHoder extends RecyclerView.ViewHolder {
            ImageView item_imgview;

            public ViewHoder(View itemView) {
                super(itemView);
                item_imgview = itemView.findViewById(R.id.item_imgview);
            }
        }
    }
}
