package com.zxf.apputils.SMSAndPhoneUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PhoneReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// 但是我现在要中断：分析--》结合源码
        // abortBroadcast();
		//清空数据
        // setResultData(null);
		//外拨号码
		String number = getResultData();
		//黑名单
		if(number.equals("5556")){
			setResultData(null);
		}else if(number.equals("8888")){//拦截号码
			//假设我的号码是9999
			setResultData("9999");
		}else{
			//设置ip拨号
			setResultData("17951"+number);
		}
		
		
		
	}

}
