package com.zxf.apputils.WidgetDemo.ListViewDemo.WanNengAdapter.example.imooc_baseadapter;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;

import com.zxf.apputils.R;
import com.zxf.apputils.WidgetDemo.ListViewDemo.WanNengAdapter.baseadapter.bean.Bean;

public class WanNengActivity extends Activity {

	private ListView mListView;
	private List<Bean> mDatas;//这里我们设置了多个item，因此需要存放4个Bean对象的list
	//private MyAdapter mAdapter;//声明自定义的适配器
	private MyAdapterWithCommonViewHolder mAdapterWithCommonViewHolder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wanneng);

		initDatas();//先调用这个方法，因为我们在这里给adapter设置了数据
		initView();//在这里我们初始化了view，为listview设置了适配器
	}

	private void initView() {
		mListView = (ListView) findViewById(R.id.id_listview);
		//mListView.setAdapter(mAdapter);
		mListView.setAdapter(mAdapterWithCommonViewHolder);
	}
	private void initDatas() {
		//构造我们listview上的数据
		mDatas = new ArrayList<Bean>();
		Bean bean1 = new Bean("小白兔的故事1","第一天，小白兔去河边钓鱼，什么也没钓到，"
				+ "回家了。第二天，小白兔又去河边钓鱼，还是什么也没钓到，回家了。第三天，小白兔刚到河边，"
				+ "一条大鱼从河里跳出来，冲着小白兔大叫：你他妈的要是再敢用胡箩卜当鱼饵，我就扁死你！",
				"2015-12-31","10086");
		mDatas.add(bean1);
		Bean bean2 = new Bean("小白兔的故事2","狼崽喜欢素食，狼爸妈很苦恼。一日，见狼崽狂追兔子，甚喜，"
				+ "最终狼崽摁住兔子，恶狠狠地说：兔崽子，把胡萝卜交出来！",
				"2015-12-31","10086");
		mDatas.add(bean2);
		Bean bean3 = new Bean("小白兔的故事3","一只青蛙偷亲了兔子一口撒腿就跑，兔子紧追不舍。青蛙情急之下跳进池塘，"
				+ "不一会儿，一只癞蛤蟆爬了出来。兔子忍不住大笑：“哈哈，小样儿，皮肤过敏了吧！",
				"2015-12-31","10086");
		mDatas.add(bean3);
		Bean bean4 = new Bean("小白兔的故事4","小白兔跑在大森林里，结果又迷路了，这时，它碰上一只小花兔，这回小白兔可学乖了，"
				+ "跑过去说：“小花兔哥哥，小花兔哥哥，你要是告诉我怎样才能走出大森林，我就让你舒服舒服。”小花兔一听，"
				+ "登时抡圆了给小白兔一个大嘴巴，说：“我靠，你丫是问路呐，还是找办呐？”",
				"2015-12-31","10086");
		mDatas.add(bean4);
		Bean bean5 = new Bean("小白兔的故事5","蚂蚁在森林里走，突然遇到一只大象，蚂蚁连忙一头钻进土里，伸出一只腿。"
				+ "小白兔见了很好奇，问：你在干什么?蚂蚁悄悄对它说：嘘……别出声，看我绊丫一跟头……",
				"2015-12-31","10086");
		mDatas.add(bean5);

		//mAdapter = new MyAdapter(this, mDatas);
		mAdapterWithCommonViewHolder = new MyAdapterWithCommonViewHolder(this, mDatas);

	}


}
