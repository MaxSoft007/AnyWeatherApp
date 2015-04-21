package org.maxsoft.fragment.util;

import java.util.Date;

import org.maxsoft.biz.WeatherCityBiz;
import org.maxsoft.custom.toast.WeatherWaitToast;
import org.maxsoft.db.DBHelper;
import org.maxsoft.db.DBManager;
import org.maxsoft.pojo.LifeIndexInfo;
import org.maxsoft.pojo.WeatherInfos;
import org.maxsoft.util.DateUtils;
import org.maxsoft.util.GetInternetDate;
import org.maxsoft.util.ReadWeatherInfo;
import org.maxsoft.util.UpdateUI;
import org.maxsoft.util.WeatherConstant;
import org.maxsoft.weather.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherInfoFragment extends Fragment{
	private final String TAG = "WeatherInfoFragment";
	private TextView[] weatherinfos = null; 
	private ImageView[] weatherinfoicons = null;
	private TextView[] dateTextView = null;
	private TextView[] lifeinfos = null;
	private ImageView[] lifeinfosicon = null;
	private Context context = null;
	private String citycode;
	private String m_update_time = ""; //更新时间
	private SharedPreferences sp = null;
	private Editor edit = null;
	private WeatherInfoFragment weatherInfoFragment = null;
	public WeatherInfoFragment newInstance(String citycode){
		weatherInfoFragment = new WeatherInfoFragment();
		Bundle weather = new Bundle();
		weather.putString("citycode", citycode);
		weatherInfoFragment.setArguments(weather);
		return weatherInfoFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Log.d(TAG, "The WeatherInfoFragment is creating ...");
		weatherinfos = new TextView[15]; 
		weatherinfoicons = new ImageView[5];
		dateTextView = new TextView[4];
		lifeinfos = new TextView[9];
		lifeinfosicon = new ImageView[9];
		View view = inflater.inflate(R.layout.weather_main,container,false);
		context = view.getContext();
		/*****************************************************************/
		ImageView home_img = (ImageView) view.findViewById(R.id.home_img);
		home_img.setImageResource(R.drawable.temp);
		ImageView share_img = (ImageView)view.findViewById(R.id.share_img);
		share_img.setImageResource(R.drawable.temp);
		/****************************************************************/
		Bundle args =getArguments();
		citycode = args.getString("citycode");
		//生活指数信息
		ImageView dress_index_img = (ImageView)view.findViewById(R.id.A);
		dress_index_img.setImageResource(R.drawable.index);
		lifeinfosicon[0] = dress_index_img;
		TextView dress_index = (TextView)view.findViewById(R.id.dress_index);
		dress_index.setText(R.string.dress_title);
		TextView dress_index_tip = (TextView)view.findViewById(R.id.dress_index_tip);//穿衣指数描述
		lifeinfos[0] = dress_index_tip;
		
		ImageView make_up_index_img = (ImageView)view.findViewById(R.id.B);
		make_up_index_img.setImageResource(R.drawable.makeup);
		lifeinfosicon[1] = make_up_index_img;
		TextView make_up_index = (TextView)view.findViewById(R.id.make_up_index);
		make_up_index.setText(R.string.makeup_title);
		TextView make_up_index_tip = (TextView)view.findViewById(R.id.make_up_index_tip);//化妆指数描述
		lifeinfos[1] = make_up_index_tip;
		
		ImageView cold_index_img = (ImageView)view.findViewById(R.id.C);
		cold_index_img.setImageResource(R.drawable.cold);
		lifeinfosicon[2] = cold_index_img;
		TextView cold_index = (TextView)view.findViewById(R.id.cold_index);
		cold_index.setText(R.string.cold_title);
		TextView cold_index_tip = (TextView)view.findViewById(R.id.cold_index_tip);//感冒指数描述
		lifeinfos[2] = cold_index_tip;
		
		ImageView sport_index_img = (ImageView)view.findViewById(R.id.D);
		sport_index_img.setImageResource(R.drawable.sport);
		lifeinfosicon[3] = sport_index_img;
		TextView sport_index = (TextView)view.findViewById(R.id.sport_index);
		sport_index.setText(R.string.sport_title);
		TextView sport_index_tip = (TextView)view.findViewById(R.id.sport_index_tip);//运动指数描述
		lifeinfos[3] = sport_index_tip;
		
		ImageView car_wash_img = (ImageView)view.findViewById(R.id.E);
		car_wash_img.setImageResource(R.drawable.car_wash);
		lifeinfosicon[4] = car_wash_img;
		TextView car_wash_index = (TextView)view.findViewById(R.id.car_wash_index);
		car_wash_index.setText(R.string.carwash_title);
		TextView car_wash_index_tip = (TextView)view.findViewById(R.id.car_wash_index_tip);//洗车指数描述
		lifeinfos[4] = car_wash_index_tip;
		
		ImageView travel_img = (ImageView)view.findViewById(R.id.F);
		travel_img.setImageResource(R.drawable.travel);
		lifeinfosicon[5] = travel_img;
		TextView travel_index = (TextView)view.findViewById(R.id.travel_index);
		travel_index.setText(R.string.travel_title);
		TextView travel_index_tip = (TextView)view.findViewById(R.id.travel_index_tip);//旅游指数描述
		lifeinfos[5] = travel_index_tip;
		
		ImageView glass_img = (ImageView)view.findViewById(R.id.G);
		glass_img.setImageResource(R.drawable.glass);
		lifeinfosicon[6] = glass_img;
		TextView glass_index = (TextView)view.findViewById(R.id.glass_index);
		glass_index.setText(R.string.glass_title);
		TextView glass_index_tip = (TextView)view.findViewById(R.id.glass_index_tip);//太阳镜指数描述
		lifeinfos[6] = glass_index_tip;
		
		ImageView uv_img = (ImageView)view.findViewById(R.id.H);
		uv_img.setImageResource(R.drawable.uv);
		lifeinfosicon[7] = uv_img;
		TextView uv_index = (TextView)view.findViewById(R.id.uv_index);
		uv_index.setText(R.string.uv_title);
		TextView uv_index_tip = (TextView)view.findViewById(R.id.uv_index_tip);//紫外线指数描述
		lifeinfos[7] = uv_index_tip;
		
		ImageView comfort_img = (ImageView)view.findViewById(R.id.I);
		comfort_img.setImageResource(R.drawable.comfort);
		lifeinfosicon[8] = comfort_img;
		TextView comfort_index = (TextView)view.findViewById(R.id.comfort_index);
		comfort_index.setText(R.string.comfort_title);
		TextView comfort_index_tip = (TextView)view.findViewById(R.id.comfort_index_tip);//舒适度指数描述
		lifeinfos[8] = comfort_index_tip;
		
		//今天天气信息
		ImageView today_weather_img = (ImageView)view.findViewById(R.id.today_weather_icon);
		weatherinfoicons[0] = today_weather_img;
		TextView today_weather_info = (TextView)view.findViewById(R.id.today_weather_info);
		weatherinfos[0] = today_weather_info;
		TextView today_temperature_info = (TextView)view.findViewById(R.id.today_temperature_info);
		weatherinfos[5] = today_temperature_info;
		TextView today_wind_info = (TextView)view.findViewById(R.id.today_wind_info);
		weatherinfos[10] = today_wind_info;
		
		//第一天
		TextView first_weather_info = (TextView)view.findViewById(R.id.first_weather_info);
		weatherinfos[1] = first_weather_info;
		ImageView first_weather_icon = (ImageView)view.findViewById(R.id.first_weather_icon);
		weatherinfoicons[1] = first_weather_icon;
		TextView first_temperature_info = (TextView)view.findViewById(R.id.first_temperature_info);
		weatherinfos[6] = first_temperature_info;
		TextView first_wind_info = (TextView)view.findViewById(R.id.first_wind_info);
		weatherinfos[11] = first_wind_info;
		TextView first_text_date = (TextView)view.findViewById(R.id.first_text_date);
		dateTextView[0] = first_text_date;
		
		//第二天
		TextView second_text_date = (TextView)view.findViewById(R.id.second_text_date);
		dateTextView[1] = second_text_date;
		TextView second_weather_info = (TextView)view.findViewById(R.id.second_weather_info);
		weatherinfos[2] = second_weather_info;
		ImageView second_weather_icon = (ImageView)view.findViewById(R.id.second_weather_icon);
		weatherinfoicons[2] = second_weather_icon;
		TextView second_temperature_info = (TextView)view.findViewById(R.id.second_temperature_info);
		weatherinfos[7] = second_temperature_info;
		TextView second_wind_info = (TextView)view.findViewById(R.id.second_wind_info);
		weatherinfos[12] = second_wind_info;
		
		//第三天
		TextView thirdly_text_date = (TextView)view.findViewById(R.id.thirdly_text_date);
		dateTextView[2] = thirdly_text_date;
		TextView thirdly_weather_info = (TextView)view.findViewById(R.id.thirdly_weather_info);
		weatherinfos[3] = thirdly_weather_info;
		ImageView thirdly_weather_icon = (ImageView)view.findViewById(R.id.thirdly_weather_icon);
		weatherinfoicons[3] = thirdly_weather_icon;
		TextView thirdly_temperature_info = (TextView)view.findViewById(R.id.thirdly_temperature_info);
		weatherinfos[8] = thirdly_temperature_info;
		TextView thirdly_wind_info = (TextView)view.findViewById(R.id.thirdly_wind_info);
		weatherinfos[13] = thirdly_wind_info;
		
		//第四天
		TextView fourthly_text_date = (TextView)view.findViewById(R.id.fourthly_text_date);
		dateTextView[3] = fourthly_text_date;
		TextView fourthly_weather_info = (TextView)view.findViewById(R.id.fourthly_weather_info);
		weatherinfos[4] = fourthly_weather_info;
		ImageView fourthly_weather_icon = (ImageView)view.findViewById(R.id.fourthly_weather_icon);
		weatherinfoicons[4] = fourthly_weather_icon;
		TextView fourthly_temperature_info = (TextView)view.findViewById(R.id.fourthly_temperature_info);
		weatherinfos[9] = fourthly_temperature_info;
		TextView fourthly_wind_info = (TextView)view.findViewById(R.id.fourthly_wind_info);
		weatherinfos[14] = fourthly_wind_info;
		
		//天气信息内容区域
		ImageView first_day_weather_content = (ImageView)view.findViewById(R.id.first_day_weather_content);
		ImageView secont_day_weather_content = (ImageView)view.findViewById(R.id.second_day_weather_content);
		ImageView thirdly_day_weather_content = (ImageView)view.findViewById(R.id.thirdly_day_weather_content);
		ImageView fourthly_day_weather_content = (ImageView)view.findViewById(R.id.fourthly_day_weather_content);
		first_day_weather_content.setImageResource(R.drawable.border_bg);
		first_day_weather_content.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				updateWeatherInfo(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,dateTextView);
				WeatherWaitToast.MakeText(v.getContext(), R.string.wait_conternt,R.anim.gif , Toast.LENGTH_LONG).show();
			}
		});
		secont_day_weather_content.setImageResource(R.drawable.border_bg);
		secont_day_weather_content.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				updateWeatherInfo(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,dateTextView);
				WeatherWaitToast.MakeText(v.getContext(), R.string.wait_conternt,R.anim.gif , Toast.LENGTH_LONG).show();
			}
		});
		thirdly_day_weather_content.setImageResource(R.drawable.border_bg);
		thirdly_day_weather_content.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				updateWeatherInfo(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,dateTextView);
				WeatherWaitToast.MakeText(v.getContext(), R.string.wait_conternt,R.anim.gif , Toast.LENGTH_LONG).show();
			}
		});
		fourthly_day_weather_content.setImageResource(R.drawable.border_bg);
		fourthly_day_weather_content.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				updateWeatherInfo(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,dateTextView);
				WeatherWaitToast.MakeText(v.getContext(), R.string.wait_conternt,R.anim.gif , Toast.LENGTH_LONG).show();
			}
		});
		WeatherCityBiz biz = new WeatherCityBiz();
		int fchh = biz.getLastUpdateWeatherInfoTime(citycode,view);
		int hour = DateUtils.getHour();
		sp = getActivity().getSharedPreferences(WeatherConstant.CONFIG_NAME, Context.MODE_PRIVATE);
		String temp = sp.getString(WeatherConstant.M_UPDATE_TIME,DateUtils.formatDate(new Date(),DateUtils.FMT_DATE_YYYYMMDD));
		if(temp.equals(m_update_time) && fchh == WeatherConstant.UPDATE_THREE_TIME && (hour > WeatherConstant.UPDATE_THREE_TIME)){
			initWeatherInfo(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,dateTextView);
		}else if(temp.equals(m_update_time) && fchh == WeatherConstant.UPDATE_SECOND_TIME && hour > WeatherConstant.UPDATE_SECOND_TIME && hour <= WeatherConstant.UPDATE_THREE_TIME){
			initWeatherInfo(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,dateTextView);
		}else if(temp.equals(m_update_time) && fchh == WeatherConstant.UPDATE_FIRST_TIME && hour > WeatherConstant.UPDATE_FIRST_TIME && hour <= WeatherConstant.UPDATE_SECOND_TIME){
			initWeatherInfo(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,dateTextView);
		}else if(temp.equals(m_update_time) && fchh == WeatherConstant.UPDATE_THREE_TIME && (hour <= WeatherConstant.UPDATE_FIRST_TIME )){
			initWeatherInfo(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,dateTextView);
		}else{
			updateWeatherInfo(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,dateTextView);
			edit = sp.edit();
			edit.putString(WeatherConstant.M_UPDATE_TIME, DateUtils.formatDate(new Date(),DateUtils.FMT_DATE_YYYYMMDD));
			edit.commit();
		}
		return view;
	}
	final Handler handler = new Handler();
	public void initWeatherInfo(final TextView[] weatherinfos,final ImageView[] weatherinfoicons,final TextView[] lifeinfos,final ImageView[] lifeinfosicon,final String citycode,final TextView[] date) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				ReadWeatherInfo readWeatherInfo = new ReadWeatherInfo();
				DBManager manager = new DBManager(context);
				WeatherInfos w = new WeatherInfos();
				w.setCityid(citycode);
				readWeatherInfo.setWeatherinfos(weatherinfos);
				readWeatherInfo.setWeatherinfoicons(weatherinfoicons);
				w = manager.getWeatherInfos(w);
				LifeIndexInfo l = new LifeIndexInfo();
				readWeatherInfo.setLifeinfos(lifeinfos);
				readWeatherInfo.setLifeinfosicon(lifeinfosicon);
				l = manager.getLifeIndexInfo(citycode);
				//由于生活指数接口关闭无法查询数据所以在此调用了天气信息接口中的生活数据
				if(l.getCt_des().trim().length()==0){
					
					l = new LifeIndexInfo();
					
					l.setCt_hint(w.getIndex());
					l.setCt_des(w.getIndex_d());
					
					l.setGm_hint(w.getIndex_ag());
					l.setGm_des(w.getIndex_ag());
					
					l.setYd_hint(w.getIndex_cl());
					l.setYd_des(w.getIndex_cl());
					
					l.setXc_hint(w.getIndex_xc());
					l.setXc_des(w.getIndex_xc());
					
					l.setTr_hint(w.getIndex_tr());
					l.setTr_des(w.getIndex_tr());
					
					l.setGl_hint(w.getIndex_ls());
					l.setGl_des(w.getIndex_ls());
					
					l.setUv_hint(w.getIndex_uv());
					l.setUv_des(w.getIndex_uv());
					
					l.setCo_hint(w.getIndex_co());
					l.setCo_des(w.getIndex_co());
					
					l.setPp_hint("暂无");
					l.setPp_des("暂无");
				}
				DBManager.close();
				if(w.getCity()!=null && w.getCity().trim().length()>0 && l.getCt_des() != null && l.getCt_des().trim().length() > 0){
					handler.post(new UpdateUI(w,l, weatherinfos, weatherinfoicons,lifeinfos,lifeinfosicon,date));
				}else{
					ReadWeatherInfo info = new ReadWeatherInfo();
					info.setContext(context);
					info.execute(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,date);
				}
			}
		}).start();
	}

	public void updateDateInfo(final TextView[] date) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				new GetInternetDate().execute(date);
			}
		}).start();
	}
	
	public void updateWeatherInfo(final TextView[] weatherinfos,final ImageView[] weatherinfoicons,final TextView[] lifeinfos,final ImageView[] lifeinfosicon,final String citycode,final TextView[] date){
		new Thread(new Runnable() {
			@Override
			public void run() {
				DBManager manager = new DBManager(context);
				manager.delInfo(DBHelper.WEATHERINFOS,citycode);
				manager.delInfo(DBHelper.LIFEINDEXINFO, citycode);
				DBManager.close();
				ReadWeatherInfo info = new ReadWeatherInfo();
				info.setContext(context);
				info.execute(weatherinfos,weatherinfoicons,lifeinfos,lifeinfosicon,citycode,date);
			}
		}).start();
	}

	public String getM_update_time() {
		return m_update_time;
	}

	public void setM_update_time(String m_update_time) {
		this.m_update_time = m_update_time;
	}

	@Override
	public void onDestroy() {
		weatherinfos = null; 
		weatherinfoicons = null;
		dateTextView = null;
		lifeinfos = null;
		lifeinfosicon = null;
		context = null;
		sp = null;
		edit = null;
		weatherInfoFragment = null;
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}
	
}
