package com.zxf.apputils.WidgetDemo.RecycleDemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxf.apputils.R;

import java.util.List;

/**
 * Created by Administrator on 2015/12/28.
 */
public  class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> data;
    private Context context;
    LayoutInflater inflater;
    public MyAdapter(Context context,List<String> data) {
         this.context=context;
        this.data=data;
        inflater=LayoutInflater.from(context);
    }
    public interface OnItemClickListener{
       void OnItemClickListener(View view,int poi);
       void OnItemLongClickListener(View view,int poi);
    }
    private OnItemClickListener onItemClickListener;
    public void setItemClickListener(OnItemClickListener listener){
        this.onItemClickListener=listener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_recycledemo,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
          holder.tv.setText(data.get(position));
        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int poi=holder.getLayoutPosition();
                    onItemClickListener.OnItemClickListener(holder.itemView,poi);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int poi=holder.getLayoutPosition();
                    onItemClickListener.OnItemLongClickListener(holder.itemView,poi);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addItem(int pos){
        data.add(pos,"AddItem");
        notifyItemInserted(pos);
    }
    public void deleteItem(int pos){
        data.remove(pos);
        notifyItemRemoved(pos);
    }

}
class MyViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);
        tv= (TextView) itemView.findViewById(R.id.tv_itemrecycle);
    }
}
