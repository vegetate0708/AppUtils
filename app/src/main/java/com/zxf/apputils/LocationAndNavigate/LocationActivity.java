package com.zxf.apputils.LocationAndNavigate;

import android.app.Activity;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2015/12/21.
 */
public class LocationActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        LocationManager locationManager= (LocationManager) getSystemService(LOCATION_SERVICE);
    }
}
