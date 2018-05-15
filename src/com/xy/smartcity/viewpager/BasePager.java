package com.xy.smartcity.viewpager;

import com.example.smartcityapp.R;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class BasePager {
	public Activity mActivity;
	public FrameLayout flContent;
	public ImageView btnMenu;
	public TextView tvTitle;
	//当前页面的布局对象
	public View mRootView;

	public BasePager(Activity mActivity) {
		this.mActivity = mActivity;
		mRootView = initView();
	}

	public View initView() {
		Log.e("BasePager", "initView");
		View view = View.inflate(mActivity, R.layout.base_pager, null);
		flContent = (FrameLayout) view.findViewById(R.id.fl_content);
		btnMenu = (ImageView) view.findViewById(R.id.btn_menu);
		tvTitle = (TextView) view.findViewById(R.id.tv_title);
		return view;
	}

	public void initData() {

	}
}
