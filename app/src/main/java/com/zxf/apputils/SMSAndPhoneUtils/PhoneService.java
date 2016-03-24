package com.zxf.apputils.SMSAndPhoneUtils;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneService extends Service {

	private static final String TAG = "PhoneService";
	private TelephonyManager tm;
	private MyPhoneStateListener listener;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		//得到电话管理器
		tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		listener = new MyPhoneStateListener();
		//监听电话的呼叫状态
		tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
	}

	private class MyPhoneStateListener extends PhoneStateListener{

		//当电话的呼叫状态改变系统调用该方法
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			switch (state) {
				case TelephonyManager.CALL_STATE_IDLE://闲置
					Log.i(TAG, "闲置");
					break;
				case TelephonyManager.CALL_STATE_RINGING://响铃
					Log.i(TAG, "响铃");
					break;
				case TelephonyManager.CALL_STATE_OFFHOOK://接听
					Log.i(TAG, "接听");
					break;

				default:
					break;
			}
		}

	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//取消电话的监听
		tm.listen(listener, PhoneStateListener.LISTEN_NONE);
	}

}