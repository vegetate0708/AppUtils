package com.zxf.apputils.OpenSourceFrameWork.Fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxf.apputils.R;

/**
 * Created by Administrator on 2016/5/10.
 */
public class FrescoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frescodemo);
        Uri uri=Uri.parse("http://b.hiphotos.baidu.com/image/pic/item/e78.jpg");
        SimpleDraweeView simpleDraweeView= (SimpleDraweeView) findViewById(R.id.imageview);
        simpleDraweeView.setImageURI(uri);
    }
}
