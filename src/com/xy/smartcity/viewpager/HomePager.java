package com.xy.smartcity.viewpager;


import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class HomePager extends BasePager {

	public HomePager(Activity mActivity) {
		super(mActivity);
	}

	@Override
	public void initData() {
		TextView textView = new TextView(mActivity);
		textView.setText("HomePager");
		textView.setGravity(Gravity.CENTER);
		flContent.addView(textView);
		tvTitle.setText("智慧城市");
		btnMenu.setVisibility(View.GONE);
	}
}
