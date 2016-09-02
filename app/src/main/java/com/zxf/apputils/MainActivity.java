package com.zxf.apputils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.zxf.apputils.IPCDemo.IPCActivity;
import com.zxf.apputils.WidgetDemo.ActionBarDemo.ActionBarTest;
import com.zxf.apputils.WidgetDemo.RecycleDemo.RecycleDemo;
import com.zxf.apputils.SMSAndPhoneUtils.PhoneUtils;
import com.zxf.apputils.WidgetDemo.WidgetDemoActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Button bt_SMSUtils= (Button) findViewById(R.id.bt_SMSUtils);
        bt_SMSUtils.setOnClickListener(this);
        Button bt_IPCDemo= (Button) findViewById(R.id.bt_IPCDemo);
        bt_IPCDemo.setOnClickListener(this);
        Button bt_recycle= (Button) findViewById(R.id.bt_widgetDemo);
        bt_recycle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_SMSUtils:
                PhoneUtils.startPhoneTO(MainActivity.this, "13827254377");
                break;
            case R.id.bt_IPCDemo:
                Intent ipcdemo=new Intent(MainActivity.this, IPCActivity.class);
                startActivity(ipcdemo);
                break;
            case R.id.bt_widgetDemo:
                Intent widgetdemo=new Intent(MainActivity.this, WidgetDemoActivity.class);
                startActivity(widgetdemo);
                break;
        }
    }
}
