package com.zxf.apputils.IPCDemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zxf.apputils.R;

/**
 * Created by Administrator on 2015/12/15.
 */
public class IPCActivity extends Activity {
    private Messenger messenger;
    private Messenger mainMessenger =new Messenger(new MessengerHandler());
    private String etString;
    private TextView tv;
    private Button bt;
    private EditText et;

    class  MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    StringBuilder sb=new StringBuilder();
                    sb.append(etString);
                    String ss= msg.getData().getString("service");
                    sb.append("+服务端信息：" + ss);
                    Log.i("服务端信息", ss);
                    tv.setText(sb.toString());
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcdemo);
        bt = (Button) findViewById(R.id.bt_activity_IPCDemo);
        et = (EditText) findViewById(R.id.et_activity_IPCDemo);

        tv = (TextView) findViewById(R.id.tv_activity_IPCDemo);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etString = et.getText().toString().trim();
                Intent intent = new Intent(IPCActivity.this, MessengerService.class);
                IPCActivity.this.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }

    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger=new Messenger(service);
            Message msg=Message.obtain(null,0);
            Bundle bundle=new Bundle();
            bundle.putString("main","来自主函数的信息："+etString);
            msg.setData(bundle);
            msg.replyTo=mainMessenger;
            try {
                messenger.send(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
