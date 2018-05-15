package com.xy.smartcity.viewpager;


import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class SettingPager extends BasePager {

	public SettingPager(Activity mActivity) {
		super(mActivity);
	}

	@Override
	public void initData() {
		TextView textView = new TextView(mActivity);
		textView.setText("SettingPager");
		textView.setGravity(Gravity.CENTER);
		flContent.addView(textView);
		tvTitle.setText("设置");
		btnMenu.setVisibility(View.VISIBLE);
	}
}
