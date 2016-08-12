package com.zxf.apputils.WidgetDemo.RecycleDemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxf.apputils.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/8/11.
 */
public class MyStaggeredAdapter extends RecyclerView.Adapter<MyStaggerHolder>{
    private List<String> data;
    private Context context;
    LayoutInflater inflater;
    List<Integer> itemHeight;
    public MyStaggeredAdapter (Context context,List<String> data) {
        this.context=context;
        this.data=data;
        inflater=LayoutInflater.from(context);
        itemHeight=new ArrayList<Integer>();
        for (int i='A';i<='z';i++){
            itemHeight.add((int) (100+ Math.random()*300));
        }
    }

    @Override
    public MyStaggerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_recycledemo,parent,false);
        MyStaggerHolder viewHolder=new MyStaggerHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyStaggerHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams=holder.itemView.getLayoutParams();
        layoutParams.height=itemHeight.get(position);
        holder.tv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
class MyStaggerHolder extends RecyclerView.ViewHolder{
    TextView tv;
    public MyStaggerHolder(View itemView) {
        super(itemView);
        tv= (TextView) itemView.findViewById(R.id.tv_itemrecycle);
    }
}
