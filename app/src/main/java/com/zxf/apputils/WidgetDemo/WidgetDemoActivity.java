package com.zxf.apputils.WidgetDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zxf.apputils.R;
import com.zxf.apputils.WidgetDemo.ActionBarDemo.ActionBarTest;
import com.zxf.apputils.WidgetDemo.Animator.AnimatorDemoActivity;
import com.zxf.apputils.WidgetDemo.RecycleDemo.RecycleDemo;

/**
 * Created by Administrator on 2016/9/1.
 */
public class WidgetDemoActivity extends Activity implements View.OnClickListener {

    private Button bt_recycle;
    private Button bt_actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgetdemo);
        bt_recycle = (Button) findViewById(R.id.bt_recycleDemo);
        bt_recycle.setOnClickListener(this);
        bt_actionbar = (Button) findViewById(R.id.bt_actionbarDemo);
        bt_actionbar.setOnClickListener(this);
        findViewById(R.id.bt_animatorDemo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_recycleDemo:
                Intent recycle =new Intent(WidgetDemoActivity.this, RecycleDemo.class);
                startActivity(recycle);
                break;
            case R.id.bt_actionbarDemo:
                Intent actionBar =new Intent(WidgetDemoActivity.this, ActionBarTest.class);
                startActivity(actionBar);
                break;
            case R.id.bt_animatorDemo:
                Intent animator =new Intent(WidgetDemoActivity.this, AnimatorDemoActivity.class);
                startActivity(animator);
                break;
        }
    }
}
