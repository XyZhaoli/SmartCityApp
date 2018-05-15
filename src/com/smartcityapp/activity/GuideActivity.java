package com.smartcityapp.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.smartcityapp.R;
import com.xy.smartcity.utils.SpUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GuideActivity extends Activity {
	private ViewPager mViewPager;
	private ImageView mReadPointView;
	private LinearLayout ll_coutent;
	private Button tv_enter_home;
	// 引导页图片id数组
	private int[] mImageIds = new int[] { R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3 };
	private List<ImageView> mImageViewList;
	private GuideAdapter mGuideAdapter;
	private int pointsDis; // 两个小点之间的距离

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		initView();
		initData();
	}

	private void initData() {
		mImageViewList = new ArrayList<ImageView>();
		for (int i = 0; i < mImageIds.length; i++) {
			ImageView view = new ImageView(getApplicationContext());
			view.setBackgroundResource(mImageIds[i]);
			mImageViewList.add(view);
			ImageView pointView = new ImageView(getApplicationContext());
			pointView.setImageResource(R.drawable.shape_point_gray);
			// 拿到其父布局linearLayout的布局参数
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			// 给第二个第三个点设置margin边距
			if (i > 0) {
				params.leftMargin = 10;
			}
			pointView.setLayoutParams(params);
			ll_coutent.addView(pointView);
		}
		mGuideAdapter = new GuideAdapter();
		mViewPager.setAdapter(mGuideAdapter);
	}

	@SuppressWarnings("deprecation")
	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.vp_guide);
		mReadPointView = (ImageView) findViewById(R.id.iv_red_point);
		ll_coutent = (LinearLayout) findViewById(R.id.ll_content);
		tv_enter_home = (Button) findViewById(R.id.tv_enter_home);
		// 监听layout方法结束的事件，因为只有当layout（）方法结束以后，我们才能准确的测量出两个小圆点的距离
		mReadPointView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout() {
				mReadPointView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				pointsDis = ll_coutent.getChildAt(1).getLeft() - ll_coutent.getChildAt(0).getLeft();
			}
		});
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			// 当某个页面被选中的时候
			@Override
			public void onPageSelected(int arg0) {
				if (arg0 == mImageIds.length - 1) {
					tv_enter_home.setVisibility(View.VISIBLE);
				} else {
					tv_enter_home.setVisibility(View.INVISIBLE);
				}
			}

			// 当页面滑动的时候
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				int leftMargin = (int) (pointsDis * arg1 + arg0 * pointsDis);
				RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mReadPointView
						.getLayoutParams();
				layoutParams.leftMargin = leftMargin;
				mReadPointView.setLayoutParams(layoutParams);
			}

			// 当我们的
			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		tv_enter_home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActicity.class);
				startActivity(intent);
				SpUtils.setSpBoolean(getApplicationContext(), "is_first_enter", false);
			}
		});
	}

	class GuideAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mImageViewList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView imageView = mImageViewList.get(position);
			container.addView(imageView);
			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
}
