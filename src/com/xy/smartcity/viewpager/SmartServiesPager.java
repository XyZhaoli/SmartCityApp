package com.xy.smartcity.viewpager;

import java.util.Set;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SmartServiesPager extends BasePager {

	public SmartServiesPager(Activity mActivity) {
		super(mActivity);
	}

	@Override
	public void initData() {
		TextView textView = new TextView(mActivity);
		textView.setText("SmartServiesPager");
		textView.setGravity(Gravity.CENTER);
		flContent.addView(textView);
		tvTitle.setText("智慧服务");
	}
}
