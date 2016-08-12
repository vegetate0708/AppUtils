package com.zxf.apputils.WidgetDemo.ListViewDemo.WanNengAdapter.baseadapter.bean;
/**
 * 新建一个Java Bean类，用于描述listview中每一个item的信息
 * 每一个item包括一个标题，一个描述信息，一个日期，一个电话
 */
public class Bean {
	private String title;
	private String desc;
	private String time;
	private String phone;
	
	public Bean()
	{
		
	}
	public Bean(String title, String desc, String time, String phone)
	{
		super();
		this.title = title;
		this.desc = desc;
		this.time = time;
		this.phone = phone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
