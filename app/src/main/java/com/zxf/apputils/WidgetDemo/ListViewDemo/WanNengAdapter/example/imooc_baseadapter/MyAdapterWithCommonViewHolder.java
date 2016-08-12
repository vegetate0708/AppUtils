package com.zxf.apputils.WidgetDemo.ListViewDemo.WanNengAdapter.example.imooc_baseadapter;

import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import com.zxf.apputils.R;
import com.zxf.apputils.WidgetDemo.ListViewDemo.WanNengAdapter.baseadapter.bean.Bean;
import com.zxf.apputils.WidgetDemo.ListViewDemo.WanNengAdapter.baseadapter.utils.CommonAdapter;
import com.zxf.apputils.WidgetDemo.ListViewDemo.WanNengAdapter.baseadapter.utils.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 修改此适配器，使之继承自我们定义的抽象通用的CommonAdapter
 */
public class MyAdapterWithCommonViewHolder extends CommonAdapter<Bean> {
	
	public MyAdapterWithCommonViewHolder(Context context, List<Bean> datas) {
		super(context, datas, R.layout.item);
	}

	@Override
	public void convert(ViewHolder holder, Bean bean) {
		/*TextView title = holder.getView(R.id.id_title);
		title.setText(bean.getTitle());
		//上面的两句话可以合并为((TextView)holder.getView(R.id.id_title)).setText(bean.getTitle());
		TextView desc = holder.getView(R.id.id_desc);
		desc.setText(bean.getDesc());
		TextView time = holder.getView(R.id.id_time);
		time.setText(bean.getTime());
		TextView phone = holder.getView(R.id.id_phone);
		phone.setText(bean.getPhone());*/
		
		holder.setText(R.id.id_title, bean.getTitle())
		.setText(R.id.id_desc, bean.getDesc())
		.setText(R.id.id_time, bean.getTime())
		.setText(R.id.id_phone, bean.getPhone());
	}

}
