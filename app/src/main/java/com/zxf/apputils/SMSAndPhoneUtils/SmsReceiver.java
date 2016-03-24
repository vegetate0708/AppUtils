package com.zxf.apputils.SMSAndPhoneUtils;
/*
*短信拦截广播
*
*/
import java.text.SimpleDateFormat;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
public class SmsReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		//查看短信的数据
		Object[] objects = (Object[]) intent.getExtras().get("pdus");
		for(Object obj:objects){
			//obj  转换为  短信对象
			SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])obj);
			//号码
			String address = smsMessage.getDisplayOriginatingAddress();
			//内容
			String body = smsMessage.getDisplayMessageBody();
			//时间
			long millis = smsMessage.getTimestampMillis();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String dateStr = format.format(millis);

			System.out.println("address:"+address);
			System.out.println("body:"+body);
			System.out.println("dateStr:"+dateStr);
			//SmsManager
			//监听号码进行中断拦截
			if(address.equals("8888")){
				//中断广播   abort 中断
				abortBroadcast();
			}
			
		}

	}

}
