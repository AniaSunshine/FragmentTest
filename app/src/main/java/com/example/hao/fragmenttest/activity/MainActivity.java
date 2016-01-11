package com.example.hao.fragmenttest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.example.hao.fragmenttest.R;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button tv_scroll;
    private Button tv_to_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
        tv_scroll=(Button)findViewById(R.id.tv_scroll);
        tv_scroll.setOnClickListener(this);
        tv_to_demo=(Button)findViewById(R.id.tv_scroll);
        tv_to_demo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_scroll:
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_to_demo:
                intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
