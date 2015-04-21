package org.maxsoft.weather;

import java.util.ArrayList;
import java.util.Date;
import org.maxsoft.custom.listener.WeatherInfoOnPageChangeListener;
import org.maxsoft.custom.listener.WeatherShareListener;
import org.maxsoft.fragment.util.WeatherFragmentPagerAdapter;
import org.maxsoft.fragment.util.WeatherInfoFragment;
import org.maxsoft.util.City;
import org.maxsoft.util.DateUtils;
import org.maxsoft.util.WeatherConstant;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherActivity extends FragmentActivity {
	private WeatherFragmentPagerAdapter weatherInfoAdapter;
	private WeatherInfoOnPageChangeListener listener;
	private WeatherInfoFragment fragment;
	private ViewPager mViewPager;
	private String m_update_time; //更新时间
	private SharedPreferences settings;
	private Editor edit;
	private TextView cityName;
	private ImageView home_img;
	private ImageView share_img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather_main);
		String[] city_code = City.getAllCityCode(this);
		if(city_code == null || city_code.length == 0){
			city_code = new String[]{"101010100"};
		}
		ArrayList<Fragment> list = new ArrayList<Fragment>();
		//开始校验配置文件是否存在否则创建
		settings = getSharedPreferences(WeatherConstant.CONFIG_NAME,Context.MODE_PRIVATE);//取得活动的Pre对象
		String temp = DateUtils.formatDate(DateUtils.getYesterdayDate(new Date(),1),DateUtils.FMT_DATE_YYYYMMDD);
		m_update_time = settings.getString(WeatherConstant.M_UPDATE_TIME,temp);
		
		if(m_update_time.equals(DateUtils.formatDate(DateUtils.getYesterdayDate(new Date(),1),DateUtils.FMT_DATE_YYYYMMDD))){
			edit = settings.edit();
			edit.putString(WeatherConstant.M_UPDATE_TIME, m_update_time);
			edit.commit();
		}
		
		for(int i=0; i<city_code.length;i++){
			fragment = new WeatherInfoFragment();
			fragment = fragment.newInstance(city_code[i]);
			fragment.setM_update_time(m_update_time);
			list.add(fragment);
		}
		
		cityName = (TextView)findViewById(R.id.CityName);
		String city_name = City.getCityName(city_code[0]);
		if(city_name == null ||city_name.trim().length() == 0){
			city_name = "北京";
		}
		cityName.setText(city_name);
		TextView today_date = (TextView)findViewById(R.id.TodayDate);
		today_date.setText(DateUtils.formatDate(new Date(), DateUtils.FMT_DATE_CHINESE));
		home_img = (ImageView) findViewById(R.id.home_img);
		home_img.setImageResource(R.drawable.home);
		TextView home = (TextView) findViewById(R.id.home_button_1);
		home.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent( WeatherActivity.this, HomeActivity.class);
				v.getContext().startActivity(intent);
			//	this.startActivity(intent);
				v.destroyDrawingCache();
				WeatherActivity.this.finish();
			}
		});

		share_img = (ImageView)findViewById(R.id.share_img);
		share_img.setImageResource(R.drawable.share);
		share_img.setOnClickListener(new WeatherShareListener(cityName));	
		weatherInfoAdapter = new WeatherFragmentPagerAdapter(getSupportFragmentManager(), list);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(weatherInfoAdapter);
		
		int hour = DateUtils.getHour(); 
		int month = DateUtils.getMonth();
		if(month > 10 || month < 4 ){
			if(hour >= 6 && hour <18){
				mViewPager.setBackgroundResource(R.drawable.winter_day);
			}else{
				mViewPager.setBackgroundResource(R.drawable.winter_night);
			}
		}else{
			if(hour >= 6 && hour <18){
				mViewPager.setBackgroundResource(R.drawable.fine_day);
			}else{
				mViewPager.setBackgroundResource(R.drawable.fine_night);
			}
		}
		TextView textView = (TextView)findViewById(R.id.first_text_date);
		listener = new WeatherInfoOnPageChangeListener();
		listener.setBarText(textView);
		listener.setCityname(cityName);
		listener.setContext(this.getApplicationContext());
		listener.setView(this.getWindow().getDecorView());
		listener.setCitycode(city_code);
		mViewPager.setOnPageChangeListener(listener);
	}

	@Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {  
            dialog();  
            return true;  
        }  
        return true;  
    }  
	
	protected void dialog() {  
        AlertDialog.Builder builder = new Builder(this);  
        builder.setMessage(R.string.quit_tip);  
        builder.setIcon(R.drawable.weathericon);
        builder.setTitle(R.string.quit_title);  
        builder.setPositiveButton(R.string.quit_yes, 
        new android.content.DialogInterface.OnClickListener() {  
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();  
				android.os.Process.killProcess(android.os.Process.myPid());  
			}  
        });  
        builder.setNegativeButton(R.string.quit_no,  
        new android.content.DialogInterface.OnClickListener() {  
			@Override
			public void onClick(DialogInterface dialog, int which){
				dialog.dismiss();  
			}  
        });  
        
        builder.create().show();  
	}  

}
