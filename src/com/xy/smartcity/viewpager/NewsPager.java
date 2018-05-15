package com.xy.smartcity.viewpager;

import org.xutils.x;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.http.RequestParams;

import com.google.gson.Gson;
import com.smartcityapp.activity.MainActicity;
import com.xy.smartcity.domain.NewsMenu;
import com.xy.smartcity.fragment.LeftMenuFragment;
import com.xy.smartcity.global.GolbalConstants;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

public class NewsPager extends BasePager {

	private NewsMenu newsMenuData;

	public NewsPager(Activity mActivity) {
		super(mActivity);
	}

	@Override
	public void initData() {
		TextView textView = new TextView(mActivity);
		textView.setText("NewsPager");
		textView.setGravity(Gravity.CENTER);
		flContent.addView(textView);
		tvTitle.setText("新闻中心");
		getDataFromSever();
	}

	private void getDataFromSever() {
		//这个东西真的好用啊
		RequestParams params = new RequestParams(GolbalConstants.CATEGORY_URL);
		x.http().get(params, new CommonCallback<String>() {

			@Override
			public void onCancelled(CancelledException arg0) {

			}

			@Override
			public void onError(Throwable arg0, boolean arg1) {
				Log.e("onError", "onError");
			}

			@Override
			public void onFinished() {

			}

			@Override
			public void onSuccess(String arg0) {
				// 在请求数据成功的情况下，我们对数据进行解析
				processData(arg0);
			}
		});
	}

	protected void processData(String arg0) {
		Gson gson = new Gson();
		// 我们现在已经获取到了数据，现在是如何将数据传递给leftFragment.然后将数据显示出来
		newsMenuData = gson.fromJson(arg0, NewsMenu.class);
		MainActicity acticity = (MainActicity) mActivity;
		LeftMenuFragment leftMenuFragment = acticity.getLeftMenuFragment();
		leftMenuFragment.setMenuData(newsMenuData.data);
	}
}
