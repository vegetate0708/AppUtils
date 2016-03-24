package com.zxf.apputils.IPCDemo;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * Created by Administrator on 2015/11/30.
 */
public class MessengerService extends Service {
    class  MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    String ss= msg.getData().getString("main");
                    Log.i("客户端信息",ss);
                    Messenger messenger1=msg.replyTo;
                    Message msg1=Message.obtain(null,1);
                    Bundle bundle=new Bundle();
                    bundle.putString("service","来自service的信息");
                    msg1.setData(bundle);
                    try {
                        messenger1.send(msg1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    Messenger messenger=new Messenger(new MessengerHandler());
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }
}
