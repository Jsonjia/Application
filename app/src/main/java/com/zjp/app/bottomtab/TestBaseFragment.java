package com.zjp.app.bottomtab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjp.app.R;
import com.zjp.app.databinding.FragBaseBinding;


/**
 * Created by yu on 2016/11/11.
 */

public class TestBaseFragment extends Fragment {
    private String title;
    FragBaseBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get title
        title = getArguments().getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.frag_base, null);
        // bind view
        binding = DataBindingUtil.bind(view);
        binding.tvTitle.setText(title);
        return view;
    }
}
