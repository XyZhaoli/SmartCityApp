package com.xy.smartcity.viewpager;

import java.util.Set;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class AffairsPager extends BasePager {

	public AffairsPager(Activity mActivity) {
		super(mActivity);
	}

	@Override
	public void initData() {
		TextView textView = new TextView(mActivity);
		textView.setText("AffairsPager");
		textView.setGravity(Gravity.CENTER);
		flContent.addView(textView);
		tvTitle.setText("政务管理");
		btnMenu.setVisibility(View.GONE);
	}
}
