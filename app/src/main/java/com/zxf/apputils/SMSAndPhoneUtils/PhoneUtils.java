package com.zxf.apputils.SMSAndPhoneUtils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Administrator on 2015/12/15.
 */
public class PhoneUtils {
    /*
    *调用系统的拨号盘
    */
    public static void startPhoneTO(Context context,String number){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+number));
        context.startActivity(intent);
    }
}
