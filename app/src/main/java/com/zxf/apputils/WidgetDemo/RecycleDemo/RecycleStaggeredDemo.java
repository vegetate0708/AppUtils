package com.zxf.apputils.WidgetDemo.RecycleDemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.zxf.apputils.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/28.
 */
public class RecycleStaggeredDemo extends ActionBarActivity {
    private List<String> data;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycledemo);
        initDatas();
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setAdapter(new MyStaggeredAdapter(this, data));
        //设置recycleview的布局管理
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //设置recycleview的分割线
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
}
    private void initDatas() {
        data=new ArrayList<String>();
        for (int i='A';i<='z';i++){
            data.add(""+(char)i);
        }
    }

}
