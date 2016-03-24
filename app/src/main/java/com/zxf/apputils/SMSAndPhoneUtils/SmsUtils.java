package com.zxf.apputils.SMSAndPhoneUtils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by zxf on 2015/12/15.
 */
public class SmsUtils {
    /*
    *可参考短信源码
    *调用系统发送短信至指定号码
    * 通过Intent隐士启动
    */
      public static void sendSMSTO(Context context,String number){
          Intent intent = new Intent();
          intent.setAction("android.intent.action.SENDTO");
          intent.setData(Uri.parse("sms:"+number));
          context.startActivity(intent);
      }
}
