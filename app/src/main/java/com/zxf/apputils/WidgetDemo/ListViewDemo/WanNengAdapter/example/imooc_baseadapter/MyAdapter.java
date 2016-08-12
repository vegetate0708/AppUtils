package com.zxf.apputils.WidgetDemo.ListViewDemo.WanNengAdapter.example.imooc_baseadapter;

import java.util.List;

import javax.security.auth.PrivateCredentialPermission;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zxf.apputils.R;
import com.zxf.apputils.WidgetDemo.ListViewDemo.WanNengAdapter.baseadapter.bean.Bean;


/**
 *
 *新建一个listview的适配器，需要的参数有，Context,数据源即List<Bean>，
 * 以及用LayoutInflater加载我们的item布局文件
 */
public class MyAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Bean> mDatas;
	
	public MyAdapter(Context context, List<Bean> datas) {
		mInflater = LayoutInflater.from(context);
		mDatas = datas;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//初始化viewholder
		ViewHolder holder = null;
		
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item, parent, false);//����item�����ļ�
			holder = new ViewHolder();
			//初始化我们的item中的控件
			holder.mTitle = (TextView) convertView.findViewById(R.id.id_title);
			holder.mDesc = (TextView) convertView.findViewById(R.id.id_desc);
			holder.mTime = (TextView) convertView.findViewById(R.id.id_time);
			holder.mPhone = (TextView) convertView.findViewById(R.id.id_phone);
			
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
		//为控件赋值
		Bean bean = mDatas.get(position);
		
		holder.mTitle.setText(bean.getTitle());
		holder.mDesc.setText(bean.getDesc());
		holder.mTime.setText(bean.getTime());
		holder.mPhone.setText(bean.getPhone());
		return convertView;
	}
	private class ViewHolder
	{
		//item中的四个控件
		TextView mTitle;
		TextView mDesc;
		TextView mTime;
		TextView mPhone;
	}

}
