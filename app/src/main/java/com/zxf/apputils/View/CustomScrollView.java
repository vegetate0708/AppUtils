package com.zxf.apputils.View;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.zxf.apputils.R;

public class CustomScrollView extends ScrollView {
	// ��������ͼ
	private View mRootView;
	private int mpreY = 0;
	// ԭʼ����ͼ��Ӧ��λ��
	private Rect mNormalRect;
	private ImageView imgView;
	private int moveY=0;

	public CustomScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		mRootView = getChildAt(0);
		imgView = (ImageView) mRootView.findViewById(R.id.img);
		super.onFinishInflate();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float curY = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			if (mRootView != null) {
				mNormalRect = new Rect(mRootView.getLeft(), mRootView.getTop(),
						mRootView.getRight(), mRootView.getBottom());
			}
		}
			break;
		case MotionEvent.ACTION_MOVE: {
			int delta = (int) ((curY - mpreY) * 0.25);
			if (delta > 0) {
				mRootView.layout(mRootView.getLeft(), mRootView.getTop()
						+ delta, mRootView.getRight(), mRootView.getBottom()
						+ delta);

				moveY+=delta;
				if (moveY>100){
					imgView.setImageDrawable(getResources().getDrawable(R.drawable.upbig));
				}else {
					imgView.setImageDrawable(getResources().getDrawable(R.drawable.up));
				}
			}
		}
			break;
		case MotionEvent.ACTION_UP: {
			int curTop = mRootView.getTop();
			mRootView.layout(mNormalRect.left, mNormalRect.top,
					mNormalRect.right, mNormalRect.bottom);
			TranslateAnimation animation = new TranslateAnimation(0, 0, curTop
					- mNormalRect.top, 0);
			animation.setDuration(200);
			mRootView.startAnimation(animation);
			imgView.setImageDrawable(getResources().getDrawable(R.drawable.up));
			moveY = 0;
		}
			break;
		}
		mpreY = (int) curY;
		return super.onTouchEvent(event);
	}

}
