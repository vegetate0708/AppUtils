package com.zxf.apputils.WidgetDemo.RecycleDemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zxf.apputils.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/28.
 */
public class RecycleDemo extends Activity{
    private List<String> data;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.recycledemo);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        initDatas();
        recyclerView.setAdapter(new MyAdapter(this, data));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    private void initDatas() {
        for (int i='A';i<='z';i++){
            data=new ArrayList<String>();
            data.add(""+(char)i);
        }
    }

}
