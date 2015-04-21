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

	// ����ViewPager����
		private ViewPager viewPager;
		private final int size = 4;
		// ����ViewPager������
		private ViewPagerAdapter vpAdapter;

		// ����һ��ArrayList�����View
		private ArrayList<View> views;

		// ����ͼƬ��Դ
		
		// �ײ�С���ͼƬ
		private ImageView[] points;

		// ��¼��ǰѡ��λ��
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
			// ��ʼ�����
			initView();
			// ��ʼ������
			initData();
		}
		
		/**
		 * ��ʼ�����
		 */
		private void initView() {
			// ʵ����ArrayList����
			views = new ArrayList<View>();  
			// ʵ����ViewPager
			viewPager = (ViewPager) findViewById(R.id.viewpager);

			// ʵ����ViewPager������
			vpAdapter = new ViewPagerAdapter(views);
		}

		/**
		 * ��ʼ������
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
	        //��ʼ��adapter��ʱ�� ���������Ǵ�����
			viewPager.setAdapter(vpAdapter);
			// ���ü���
			viewPager.setOnPageChangeListener(this);
			// ��ʼ���ײ�С��
			initPoint();
		}

		/**
		 * ��ʼ���ײ�С��
		 */
		private void initPoint() {
			linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
			points = new ImageView[size];
			// ѭ��ȡ��С��ͼƬ
			for (int i = 0; i < size; i++) {
				// �õ�һ��LinearLayout�����ÿһ����Ԫ��
				points[i] = (ImageView) linearLayout.getChildAt(i);
				// Ĭ�϶���Ϊ��ɫ
				points[i].setEnabled(true);
				// ��ÿ��С�����ü���
				points[i].setOnClickListener(this);
				// ����λ��tag������ȡ���뵱ǰλ�ö�Ӧ
				points[i].setTag(i);
			}
			// ���õ���Ĭ�ϵ�λ��
			currentIndex = 0;
			// ����Ϊ��ɫ����ѡ��״̬
			points[currentIndex].setEnabled(false);
		}

		/**
		 * ������״̬�ı�ʱ����
		 */
		int currentPageScrollStatus = 0;
		@Override
		public void onPageScrollStateChanged(int arg0) {
			currentPageScrollStatus = arg0;
		}

		/**
		 * ����ǰҳ�汻����ʱ����
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
		 * ���µ�ҳ�汻ѡ��ʱ����
		 */

		@Override
		public void onPageSelected(int position) {
			// ���õײ�С��ѡ��״̬
			setCurDot(position);
		}

		/**
		 * ͨ������¼����л���ǰ��ҳ��
		 */
		@Override
		public void onClick(View v) {
			int position = (Integer) v.getTag();
			setCurView(position);
			setCurDot(position);
		}

		/**
		 * ���õ�ǰҳ���λ��
		 */
		private void setCurView(int position) {
			// �ų��쳣���
			if (position < 0 || position >= size){
				return;
			}
			viewPager.setCurrentItem(position);
		}

		/**
		 * ���õ�ǰ��С���λ��
		 */
		private void setCurDot(int positon) {
			// �ų��쳣���
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
