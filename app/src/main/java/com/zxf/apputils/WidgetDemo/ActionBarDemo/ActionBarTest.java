package com.zxf.apputils.WidgetDemo.ActionBarDemo;


import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import com.zxf.apputils.IPCDemo.IPCActivity;
import com.zxf.apputils.R;

/**
 * Created by Administrator on 2016/2/23.
 */
public class ActionBarTest extends Activity implements ActionBar.TabListener, ActionBar.OnNavigationListener {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionbar_test);
        actionBar=getActionBar();

        if(actionBar==null){
            Log.i("actionbar","null");
        }else {
            //actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示应用程序图标
            //actionBar.setHomeButtonEnabled(true);//将应用程序设置为是否可点击的按钮
            //actionBar.setDisplayHomeAsUpEnabled(true);//将应用程序图标设置为可点击的按钮，并在图标上添加向左按钮
            Log.i("actionbar", "notnull");
            //设置TAB导航
//            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//            actionBar.addTab(actionBar.newTab().setText("第一页").setTabListener(this));
//            actionBar.addTab(actionBar.newTab().setText("第二页").setTabListener(this));
//            actionBar.addTab(actionBar.newTab().setText("第三页").setTabListener(this));
            //设置列表项
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
            actionBar.setListNavigationCallbacks(new ArrayAdapter<String>(ActionBarTest.this,
                    android.R.layout.simple_expandable_list_item_1,
                    android.R.id.text1,new String[]{"第一页","第二页","第三页"}),this);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //添加menu
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.clockmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.isCheckable()){
            item.setCheckable(true);
        }
        //判断单击的是哪个菜单项，并有针对性的做出响应
        switch (item.getItemId()){
            case android.R.id.home://此处点击的便是应用程序图标对应的可以
                Intent intent=new Intent(this, IPCActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
        return true;
    }

    public void show(View source){
        actionBar.show();
    }
    public void hide(View source){
        actionBar.hide();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        //进行相应的选中操作
        Log.i("Tab选中的页数",tab.getPosition()+"");
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        //导航项选中激发该方法
        return false;//返回true表示已处理
    }
}
