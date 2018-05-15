package com.xy.smartcity.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.smartcityapp.R;
import com.xy.smartcity.view.NoScrollViewPager;
import com.xy.smartcity.viewpager.AffairsPager;
import com.xy.smartcity.viewpager.BasePager;
import com.xy.smartcity.viewpager.HomePager;
import com.xy.smartcity.viewpager.NewsPager;
import com.xy.smartcity.viewpager.SettingPager;
import com.xy.smartcity.viewpager.SmartServiesPager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainContentFragment extends BaseFragment {
	private NoScrollViewPager viewPager;
	private RadioGroup rgGroup;
	private List<BasePager> mPagers;

	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.fragment_main_content, null);
		viewPager = (NoScrollViewPager) view.findViewById(R.id.vp_content);
		rgGroup = (RadioGroup) view.findViewById(R.id.rg_group);
		
		return view;
	}

	@Override
	public void initData() {
		mPagers = new ArrayList<BasePager>();
		mPagers.add(new HomePager(mActivity));
		mPagers.add(new NewsPager(mActivity));
		mPagers.add(new SmartServiesPager(mActivity));
		mPagers.add(new AffairsPager(mActivity));
		mPagers.add(new SettingPager(mActivity));
		viewPager.setAdapter(new ContentAdapter());
		rgGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_home:
					viewPager.setCurrentItem(0, false);
					break;
				case R.id.rb_news:
					viewPager.setCurrentItem(1, false);
					break;
				case R.id.rb_smart_sevice:
					viewPager.setCurrentItem(2, false);
					break;
				case R.id.rb_affairs:
					viewPager.setCurrentItem(3, false);
					break;
				case R.id.rb_setting:
					viewPager.setCurrentItem(4, false);
					break;
				default:
					break;
				}
			}
		});
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				BasePager basePager = mPagers.get(arg0);
				basePager.initData();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		mPagers.get(0).initData();
	}

	class ContentAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mPagers.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			BasePager basePager = mPagers.get(position);
			View view = basePager.mRootView;
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

	}
}
