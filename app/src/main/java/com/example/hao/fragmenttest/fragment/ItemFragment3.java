package com.example.hao.fragmenttest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hao.fragmenttest.R;

/**
 * Created by 012 on 2016/1/8.
 */
public class ItemFragment3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_pager, null);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("2");
        return view;
    }
}
