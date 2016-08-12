package com.zxf.apputils.WidgetDemo.RecycleDemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.zxf.apputils.IPCDemo.IPCActivity;
import com.zxf.apputils.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/28.
 */
public class RecycleDemo extends ActionBarActivity {
    private List<String> data;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycledemo);
        initDatas();
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        adapter=new MyAdapter(this,data);
        recyclerView.setAdapter(adapter);
        //设置recycleview的布局管理
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置recycleview的分割线
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu_recycle, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                adapter.addItem(1);
                break;
            case R.id.action_Delete:
                adapter.deleteItem(1);
                break;
            case R.id.action_listview:
                //设置recycleview的分割线
                recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
                recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                break;
            case R.id.action_GridView:
                recyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.action_horizontalGridView:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered:
                 Intent intent=new Intent(this,RecycleStaggeredDemo.class);
                startActivity(intent);
                break;
        }
        return true;
    }
    private void initDatas() {
        data=new ArrayList<String>();
        for (int i='A';i<='z';i++){
            data.add(""+(char)i);
        }
    }

}
