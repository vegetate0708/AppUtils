package com.zxf.apputils.View;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zxf.apputils.R;

/**
 * Created by Administrator on 2016/4/12.
 */
public class MyLockView extends ScrollView{
    ;
    private View viewCentre;
    private Rect rect;
    private int moveY=0;
    private onStateChangeListener state;
    private ImageView imageViewup;
    private ImageView imageViewupbig;
    private ImageView imageViewdown;
    private ImageView imageViewdownbig;
    private TextView text_up;
    private TextView text_upbig;
    private int mpreY=0;

    public interface onStateChangeListener{
        public abstract void onState(int i);
    }
    public MyLockView(Context context,AttributeSet attrs) {
        super(context,attrs);
    }
    public void setStateChangeListener(onStateChangeListener stateChangeListener) {
        this.state = stateChangeListener;
    }

    @Override
    protected void onFinishInflate() {
        viewCentre = getChildAt(0);
        imageViewup = (ImageView) viewCentre.findViewById(R.id.iv_up);
        imageViewupbig = (ImageView) viewCentre.findViewById(R.id.iv_upbig);
        imageViewdown = (ImageView) viewCentre.findViewById(R.id.iv_down);
        imageViewdownbig = (ImageView) viewCentre.findViewById(R.id.iv_downbig);
        text_up= (TextView) viewCentre.findViewById(R.id.tv_lock);
        text_upbig= (TextView) viewCentre.findViewById(R.id.tv_lockbig);
        super.onFinishInflate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float y=ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (viewCentre != null) {
                    rect = new Rect(viewCentre.getLeft(), viewCentre.getTop(),
                            viewCentre.getRight(), viewCentre.getBottom());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int delta = (int)((y - mpreY) * 0.25);
                if (delta>0) {
                    viewCentre.layout(viewCentre.getLeft(),
                            viewCentre.getTop() + delta, viewCentre.getRight(),
                            viewCentre.getBottom() + delta);
                    moveY+=delta;
                    if(moveY>100){
                        state.onState(1);
                        imageViewup.setVisibility(INVISIBLE);
                        imageViewupbig.setVisibility(VISIBLE);
                        text_up.setVisibility(INVISIBLE);
                        text_upbig.setVisibility(VISIBLE);
                    }else {
                        imageViewup.setVisibility(VISIBLE);
                        imageViewupbig.setVisibility(INVISIBLE);
                        text_up.setVisibility(VISIBLE);
                        text_upbig.setVisibility(INVISIBLE);
                    }
                }
                else if(delta<0){
                    viewCentre.layout(viewCentre.getLeft(), viewCentre.getTop() + delta, viewCentre.getRight(), viewCentre.getBottom() + delta);
                    moveY+=delta;
                    if(moveY<-100) {
                        state.onState(0);
                        imageViewdown.setVisibility(INVISIBLE);
                        imageViewdownbig.setVisibility(VISIBLE);
                    }else {
                        imageViewdown.setVisibility(VISIBLE);
                        imageViewdownbig.setVisibility(INVISIBLE);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                int curTop = viewCentre.getTop();
                viewCentre.layout(rect.left, rect.top, rect.right, rect.bottom);
                TranslateAnimation animation = new TranslateAnimation(0, 0, curTop - rect.top, 0);
                animation.setDuration(200);
                viewCentre.startAnimation(animation);
                state.onState(2);
                imageViewup.setVisibility(VISIBLE);
                imageViewupbig.setVisibility(INVISIBLE);
                text_up.setVisibility(VISIBLE);
                text_upbig.setVisibility(INVISIBLE);
                imageViewdown.setVisibility(VISIBLE);
                imageViewdownbig.setVisibility(INVISIBLE);
                moveY=0;
                break;
        }
        mpreY = (int)y;
        return super.onTouchEvent(ev);
    }

}
