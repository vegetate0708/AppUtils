package com.zxf.apputils.WidgetDemo.UserDefinedDemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.zxf.apputils.R;
import com.zxf.apputils.View.MyLockView;

/**
 * Created by Administrator on 2016/4/12.
 */
public class LockDemo extends Activity {

    private MyLockView myLockView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockdemo);
        myLockView = (MyLockView) findViewById(R.id.mylock);
        myLockView.setStateChangeListener(new MyLockView.onStateChangeListener() {
            @Override
            public void onState(int i) {
                if(i==1){
                  Log.i("zhuangtai", 1+"");

                }else if(i==0){
                    Log.i("zhuangtai", 0+"");
                }
                if(i==2){
                    Log.i("zhuangtai", 2+"");
                }
            }
        });
    }
}
