package com.zxf.apputils.WidgetDemo.Animator;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.zxf.apputils.R;

/**
 * Created by Administrator on 2016/9/1.
 */
public class AnimatorDemoActivity extends Activity implements View.OnClickListener {

    private TextView tv;
    private ValueAnimator animator;
    private MyPointView myPointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatordemo);
        tv = (TextView) findViewById(R.id.tv_animatordemo);
        findViewById(R.id.bt_animator_execute).setOnClickListener(this);
        findViewById(R.id.bt_animator_cancle).setOnClickListener(this);
        findViewById(R.id.bt_animator_checkbac).setOnClickListener(this);
        findViewById(R.id.bt_animator_checktext).setOnClickListener(this);
        findViewById(R.id.bt_animator_checkCircle).setOnClickListener(this);
        myPointView = (MyPointView) findViewById(R.id.mypointview_animatordemo);
    }

    private ValueAnimator doRepeatAnim(){
        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.layout(tv.getLeft(), curValue, tv.getRight(), curValue + tv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("qijian", "animation start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("qijian", "animation end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("qijian", "animation cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("qijian", "animation repeat");
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new MyInterpolator());
        animator.setEvaluator(new MyEvaluator());
        animator.setDuration(1000);
        animator.start();
        return animator;
    }

    private void setBackColor(){
        ValueAnimator animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(3000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                tv.setBackgroundColor(curValue);

            }
        });

        animator.start();
    }
    private void setText(){
        ValueAnimator animator = ValueAnimator.ofObject(new CharecterEvaluator(),new Character('A'),new Character('Z'));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char text = (char)animation.getAnimatedValue();
                tv.setText(String.valueOf(text));
            }
        });
        animator.setDuration(10000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatMode(ValueAnimator.INFINITE);
        animator.start();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_animator_execute:
                animator = doRepeatAnim();
                ValueAnimator animator1=animator.clone();
                break;
            case R.id.bt_animator_cancle:
                if (animator!=null){
                    animator.cancel();
                    animator.removeAllListeners();
                }
                break;
            case R.id.bt_animator_checkbac:
                setBackColor();
                break;
            case R.id.bt_animator_checktext:
                setText();
                break;
            case R.id.bt_animator_checkCircle:
                myPointView.doPointAnim();
                break;
        }
    }
}
