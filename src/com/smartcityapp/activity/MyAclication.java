package com.smartcityapp.activity;

import org.xutils.x;

import android.app.Application;

public class MyAclication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		x.Ext.init(this);
	}
}
