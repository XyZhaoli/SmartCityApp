package com.smartcityapp.activity;

import com.example.smartcityapp.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.xy.smartcity.fragment.LeftMenuFragment;
import com.xy.smartcity.fragment.MainContentFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActicity extends SlidingFragmentActivity {

	private final static String TAG_LEFT_MENU = "tag left menu";
	private final static String TAG_CONTENT = "tag lcontent";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initFragment();
	}

	private void initFragment() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.replace(R.id.fl_main, new MainContentFragment(), TAG_CONTENT);
		transaction.replace(R.id.fl_sliding_left_menu, new LeftMenuFragment(), TAG_LEFT_MENU);
		transaction.commit();
	}

	private void initView() {
		setBehindContentView(R.layout.left_menu);
		SlidingMenu menu = getSlidingMenu();
		menu.setMode(SlidingMenu.LEFT);
		menu.setTouchModeAbove(SlidingMenu.SLIDING_WINDOW);
		menu.setBehindOffset(300);
	}

	public MainContentFragment getContentFragment() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment = fragmentManager.findFragmentByTag(TAG_CONTENT);
		return (MainContentFragment) fragment;
	}

	public LeftMenuFragment getLeftMenuFragment() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment = fragmentManager.findFragmentByTag(TAG_LEFT_MENU);
		return (LeftMenuFragment) fragment;
	}

}
