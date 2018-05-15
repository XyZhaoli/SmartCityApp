package com.xy.smartcity.fragment;

import java.util.List;

import com.example.smartcityapp.R;
import com.xy.smartcity.domain.NewsMenu;
import com.xy.smartcity.domain.NewsMenu.NewsMenuData;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LeftMenuFragment extends BaseFragment {
	public ListView lv_content;
	public List<NewsMenuData> mNewsMenuData;
	private MyAdapter adapter;
	private int mCurrentPos;
	public int[] ImageResId = new int[] { R.drawable.interact, R.drawable.news, R.drawable.icon, R.drawable.interact,
			R.drawable.interact, R.drawable.back, R.drawable.interact, R.drawable.back, R.drawable.interact,
			R.drawable.interact, R.drawable.subject };

	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.fragment_leftmenu, null);
		lv_content = (ListView) view.findViewById(R.id.lv_content);
		return view;
	}

	@Override
	public void initData() {

	}

	public void setMenuData(List<NewsMenuData> data) {
		mCurrentPos = 0;
		mNewsMenuData = data;
		adapter = new MyAdapter();
		lv_content.setAdapter(adapter);
		lv_content.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mCurrentPos = position;
				adapter.notifyDataSetChanged();
			}
		});
	}

	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return mNewsMenuData.size();
		}

		@Override
		public NewsMenuData getItem(int position) {
			return mNewsMenuData.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = View.inflate(mActivity, R.layout.item_leftmenu_list, null);
				holder = new ViewHolder();
				holder.im_icon = (ImageView) convertView.findViewById(R.id.im_icon);
				holder.tv_message = (TextView) convertView.findViewById(R.id.tv_message);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			if (position == mCurrentPos) {
				convertView.setEnabled(true);
			} else {
				convertView.setEnabled(false);
			}
			NewsMenuData newsMenu = getItem(position);
			holder.im_icon.setBackgroundResource(ImageResId[newsMenu.type]);
			holder.tv_message.setText(newsMenu.title);
			return convertView;
		}

		class ViewHolder {
			TextView tv_message;
			ImageView im_icon;
		}
	}
}
