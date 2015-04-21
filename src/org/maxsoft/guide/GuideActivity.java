package org.maxsoft.guide;

import java.util.ArrayList;

import org.maxsoft.page.adapter.ViewPagerAdapter;
import org.maxsoft.util.PhoneStatusUtils;
import org.maxsoft.weather.R;
import org.maxsoft.weather.WeatherActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GuideActivity extends Activity implements OnClickListener,OnPageChangeListener {

	// 定义ViewPager对象
		private ViewPager viewPager;
		private final int size = 4;
		// 定义ViewPager适配器
		private ViewPagerAdapter vpAdapter;

		// 定义一个ArrayList来存放View
		private ArrayList<View> views;

		// 引导图片资源
		
		// 底部小点的图片
		private ImageView[] points;

		// 记录当前选中位置
		private int currentIndex;
		
		private Intent intent;
		private TextView open_weather;
		private ImageView imageView;
		private View guide1;
		private View guide2;
		private View guide3;
		private View guide4;
		private LinearLayout linearLayout;
		private LayoutInflater la;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.guide_main);
			// 初始化组件
			initView();
			// 初始化数据
			initData();
		}
		
		/**
		 * 初始化组件
		 */
		private void initView() {
			// 实例化ArrayList对象
			views = new ArrayList<View>();  
			// 实例化ViewPager
			viewPager = (ViewPager) findViewById(R.id.viewpager);

			// 实例化ViewPager适配器
			vpAdapter = new ViewPagerAdapter(views);
		}

		/**
		 * 初始化数据
		 */
		private void initData() {
			la = getLayoutInflater();
			guide1 = la.inflate(R.layout.guide_1,null);
			views.add(guide1);
			guide2 = la.inflate(R.layout.guide_2,null);
			views.add(guide2);
			guide3 = la.inflate(R.layout.guide_3,null);
			views.add(guide3);
			guide4 = la.inflate(R.layout.guide_4,null);
			imageView = (ImageView) guide4.findViewById(R.id.right_button);
			imageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					boolean openNetwork = PhoneStatusUtils.isOpenNetwork(getWindow().getContext());
					if(!openNetwork){
						Toast.makeText(getWindow().getContext(), getWindow().getContext().getString(R.string.open_network_tip), Toast.LENGTH_LONG).show();
					}
					intent = new Intent();
					intent.setClass(GuideActivity.this,WeatherActivity.class);
					currentPageScrollStatus=0;
					startActivity(intent);
					GuideActivity.this.finish();
					
					//startWeatherActivity();
					v.destroyDrawingCache();
					GuideActivity.this.finish();
				}
			});
			open_weather = (TextView) guide4.findViewById(R.id.open_weather);
			open_weather.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					startWeatherActivity();
				}
			});
			views.add(guide4);
	        //初始化adapter的时候 参数传递是传引用
			viewPager.setAdapter(vpAdapter);
			// 设置监听
			viewPager.setOnPageChangeListener(this);
			// 初始化底部小点
			initPoint();
		}

		/**
		 * 初始化底部小点
		 */
		private void initPoint() {
			linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
			points = new ImageView[size];
			// 循环取得小点图片
			for (int i = 0; i < size; i++) {
				// 得到一个LinearLayout下面的每一个子元素
				points[i] = (ImageView) linearLayout.getChildAt(i);
				// 默认都设为灰色
				points[i].setEnabled(true);
				// 给每个小点设置监听
				points[i].setOnClickListener(this);
				// 设置位置tag，方便取出与当前位置对应
				points[i].setTag(i);
			}
			// 设置当面默认的位置
			currentIndex = 0;
			// 设置为白色，即选中状态
			points[currentIndex].setEnabled(false);
		}

		/**
		 * 当滑动状态改变时调用
		 */
		int currentPageScrollStatus = 0;
		@Override
		public void onPageScrollStateChanged(int arg0) {
			currentPageScrollStatus = arg0;
		}

		/**
		 * 当当前页面被滑动时调用
		 */

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			if(arg0 == views.size()-1){
				if(arg2 == 0 && currentPageScrollStatus == 1){
					//startWeatherActivity();
				}
			}
		}

		public void startWeatherActivity() {
			boolean openNetwork = PhoneStatusUtils.isOpenNetwork(getWindow().getContext());
			if(!openNetwork){
				Toast.makeText(getWindow().getContext(), getWindow().getContext().getString(R.string.open_network_tip), Toast.LENGTH_LONG).show();
			}
			intent = new Intent();
			intent.setClass(this,WeatherActivity.class);
			currentPageScrollStatus=0;
			startActivity(intent);
			this.finish();
		}

		/**
		 * 当新的页面被选中时调用
		 */

		@Override
		public void onPageSelected(int position) {
			// 设置底部小点选中状态
			setCurDot(position);
		}

		/**
		 * 通过点击事件来切换当前的页面
		 */
		@Override
		public void onClick(View v) {
			int position = (Integer) v.getTag();
			setCurView(position);
			setCurDot(position);
		}

		/**
		 * 设置当前页面的位置
		 */
		private void setCurView(int position) {
			// 排除异常情况
			if (position < 0 || position >= size){
				return;
			}
			viewPager.setCurrentItem(position);
		}

		/**
		 * 设置当前的小点的位置
		 */
		private void setCurDot(int positon) {
			// 排除异常情况
			if (positon < 0 || positon > 3 || currentIndex == positon) {
				return;
			}
			points[positon].setEnabled(false);
			points[currentIndex].setEnabled(true);

			currentIndex = positon;
		}

		@Override
		protected void onDestroy() {
			views = null;
			intent = null;
			points = null;
			guide1 = null;
			guide2 = null;
			guide3 = null;
			guide4 = null;
			viewPager = null;
			imageView = null;
			open_weather = null;
			linearLayout = null;
			la = null;
			setContentView(R.layout.null_view);
			super.onDestroy();
		}
}
