package org.maxsoft.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.maxsoft.custom.listener.WeatherIndexListener;
import org.maxsoft.db.DBManager;
import org.maxsoft.pojo.LifeIndexInfo;
import org.maxsoft.pojo.TipInfo;
import org.maxsoft.pojo.WeatherAll;
import org.maxsoft.pojo.WeatherInfos;
import org.maxsoft.weather.R;

import com.google.gson.Gson;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ReadWeatherInfo extends AsyncTask<Object, Object, Object>{
	private String weather = "天气：";
	private String temperature = "温度：";
	private String windpower = "风力：";
	private String nbsp = "         ";
	
	private String m_weatherInfoUrl;
	private String m_lifeIndexUrl;
	private TextView[] weatherinfos; 
	private ImageView[] weatherinfoicons;
	private TextView[] lifeinfos;
	private ImageView[] lifeinfosicon;
	private TextView[] dateTextView;
	
	private WeatherAll weatherAll;
//	ProgressDialog mProgressDialog = null;
	private Context context;
	@Override
	protected void onPreExecute() {
//		mProgressDialog = ProgressDialog.show(context, "请等待", "正在更新信息...", true);
	}	
	
	@Override
	protected Object doInBackground(Object ... params) {
		this.weatherinfos = (TextView[])params[0];//天气信息【天气】【温度】【风力】
		this.weatherinfoicons = (ImageView[])params[1];//天气信息图标
		this.lifeinfos = (TextView[])params[2];
		this.lifeinfosicon = (ImageView[])params[3];
		String code_params = (String)params[4];
		this.dateTextView = (TextView[])params[5];
		
		m_weatherInfoUrl = this.weatherInfoUrl(code_params);//天气信息Url
		m_lifeIndexUrl = this.lifeIndexInfoUrl(code_params);//生活指数Url
		String weatherInfos = readJSONFeed(m_weatherInfoUrl);
		String lifeIndexInfos = readJSONFeed(m_lifeIndexUrl);
		weatherAll = getWeatherAllInfo(weatherInfos,lifeIndexInfos);
		DBManager dbManager = null;
		if(weatherAll != null && weatherAll.getWeatherInfos() != null && weatherAll.getWeatherInfos().getDate_y() != null && weatherAll.getLifeIndexInfo() != null && weatherAll.getLifeIndexInfo().getDate() != null){
			dbManager = new DBManager(context);
			dbManager.addWeatherInfo(weatherAll.getWeatherInfos());
			dbManager.addLifeIndexInfo(weatherAll.getLifeIndexInfo(),code_params);
			DBManager.close();
		}
		return weatherAll;
	}

	@Override
	protected void onPostExecute(Object result) {
//		mProgressDialog.cancel();
		WeatherAll weatherAll = (WeatherAll) result;
		WeatherInfos infos = null;
		if(weatherAll == null){
			weatherAll = new  WeatherAll();
			weatherAll.setLifeIndexInfo(new LifeIndexInfo());
			weatherAll.setWeatherInfos(new WeatherInfos());
		}
		infos = weatherAll.getWeatherInfos();
		LifeIndexInfo indexInfo = weatherAll.getLifeIndexInfo();
		if(infos!=null && infos.getFl1()!=null && infos.getFl1().trim().length() > 0){
			initWeatherInfo(infos);
		}
		if(indexInfo!=null && indexInfo.getCt_des()!=null){
			initLifeIndexInfo(indexInfo);
		}
	}

	public void initLifeIndexInfo(LifeIndexInfo indexInfo) {
		lifeinfos[0].setText(indexInfo.getCt_hint());//穿衣指数
		lifeinfosicon[0].setOnClickListener(new WeatherIndexListener(new TipInfo(nbsp + indexInfo.getCt_des(),R.string.dress_title, R.drawable.toast_dress_index,Toast.LENGTH_LONG)));
		lifeinfos[1].setText(indexInfo.getPp_hint());//化妆指数
		lifeinfosicon[1].setOnClickListener(new WeatherIndexListener(new TipInfo(nbsp + indexInfo.getPp_des(),R.string.makeup_title, R.drawable.toast_makeup_index,Toast.LENGTH_LONG)));
		lifeinfos[2].setText(indexInfo.getGm_hint());//感冒指数
		lifeinfosicon[2].setOnClickListener(new WeatherIndexListener(new TipInfo(nbsp + indexInfo.getGm_des(),R.string.cold_title, R.drawable.toast_cold_index,Toast.LENGTH_LONG)));
		
		lifeinfos[3].setText(indexInfo.getYd_hint());//运动指数
		lifeinfosicon[3].setOnClickListener(new WeatherIndexListener(new TipInfo(nbsp + indexInfo.getYd_des(),R.string.sport_title, R.drawable.toast_sport_index,Toast.LENGTH_LONG)));
		lifeinfos[4].setText(indexInfo.getXc_hint());//洗车指数
		lifeinfosicon[4].setOnClickListener(new WeatherIndexListener(new TipInfo(nbsp + indexInfo.getXc_des(),R.string.carwash_title, R.drawable.toast_carwash_index,Toast.LENGTH_LONG)));
		lifeinfos[5].setText(indexInfo.getTr_hint());//旅游指数
		lifeinfosicon[5].setOnClickListener(new WeatherIndexListener(new TipInfo(nbsp + indexInfo.getTr_des(),R.string.travel_title, R.drawable.toast_travel_index,Toast.LENGTH_LONG)));
		
		lifeinfos[6].setText(indexInfo.getGl_hint());//太阳镜指数
		lifeinfosicon[6].setOnClickListener(new WeatherIndexListener(new TipInfo(nbsp + indexInfo.getGl_des(),R.string.glass_title, R.drawable.toast_glass_index,Toast.LENGTH_LONG)));
		lifeinfos[7].setText(indexInfo.getUv_hint());//UV指数
		lifeinfosicon[7].setOnClickListener(new WeatherIndexListener(new TipInfo(nbsp + indexInfo.getUv_des(),R.string.uv_title, R.drawable.toast_uv_index,Toast.LENGTH_LONG)));
		lifeinfos[8].setText(indexInfo.getCo_hint());//舒适度指数
		lifeinfosicon[8].setOnClickListener(new WeatherIndexListener(new TipInfo(nbsp + indexInfo.getCo_des(),R.string.comfort_title, R.drawable.toast_comfort_index ,Toast.LENGTH_LONG)));
	}

	public void initWeatherInfo(WeatherInfos infos) {
		
		weatherinfos[0].setText(weather + infos.getWeather1());
		weatherinfos[1].setText(weather + infos.getWeather2());
		weatherinfos[2].setText(weather + infos.getWeather3());
		weatherinfos[3].setText(weather + infos.getWeather4());
		weatherinfos[4].setText(weather + infos.getWeather5());
		
		weatherinfos[5].setText(temperature + infos.getTemp1());
		weatherinfos[6].setText(temperature + infos.getTemp2());
		weatherinfos[7].setText(temperature + infos.getTemp3());
		weatherinfos[8].setText(temperature + infos.getTemp4());
		weatherinfos[9].setText(temperature + infos.getTemp5());
		
		weatherinfos[10].setText(windpower + infos.getWind1());
		weatherinfos[11].setText(windpower + infos.getWind2());
		weatherinfos[12].setText(windpower + infos.getWind3());
		weatherinfos[13].setText(windpower + infos.getWind4());
		weatherinfos[14].setText(windpower + infos.getWind5());
		
		weatherinfoicons[0].setImageResource(WeatherIcons.getLargeIcon(infos.getImg1()));
		weatherinfoicons[1].setImageResource(WeatherIcons.getSmallIcon(infos.getImg3()));
		weatherinfoicons[2].setImageResource(WeatherIcons.getSmallIcon(infos.getImg5()));
		weatherinfoicons[3].setImageResource(WeatherIcons.getSmallIcon(infos.getImg7()));
		weatherinfoicons[4].setImageResource(WeatherIcons.getSmallIcon(infos.getImg9()));
		
		Date result = null;
		try {
			if(infos != null && infos.getDate_y() != null && infos.getDate_y().length()==11){
				result = DateUtils.parseDate(DateUtils.formatStringFromChinese(infos.getDate_y()), DateUtils.FMT_DATE_YYYYMMDD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result == null){
			result = new Date();
		}
		dateTextView[0].setText(DateUtils.formatDate(DateUtils.getNextDate(result, 1), DateUtils.FMT_DATE_CHINESE));
		dateTextView[1].setText(DateUtils.formatDate(DateUtils.getNextDate(result, 2), DateUtils.FMT_DATE_CHINESE));
		dateTextView[2].setText(DateUtils.formatDate(DateUtils.getNextDate(result, 3), DateUtils.FMT_DATE_CHINESE));
		dateTextView[3].setText(DateUtils.formatDate(DateUtils.getNextDate(result, 4), DateUtils.FMT_DATE_CHINESE));
	}
	
	//获取指定地址的互联网资源（JSON）
	protected String readJSONFeed(String str){		
		StringBuilder stringBuilder = new StringBuilder();
		InputStream inputStream = null;
		BufferedReader br = null;
		try {
			URL url = new URL(str);
			inputStream = url.openStream();
			String result_info = null;
			
			br = new BufferedReader(new InputStreamReader(inputStream));
			while ((result_info = br.readLine())!= null) {
				stringBuilder.append(result_info);
			}
			Log.d("WeatherInfo", stringBuilder.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return stringBuilder.toString();
	}
	
	//通过城市编码获取天气信息URL
	protected String weatherInfoUrl(String str){
		String url = "http://m.weather.com.cn/atad/"+ str + ".html";
		return url;
	}
	
	//通过城市编码获取生活指数URL
	protected String lifeIndexInfoUrl(String str){
		String url = "http://www.weather.com.cn/data/zs/" + str + ".html";
		return url;
	}
	
	//通过传入的JSON信息解析成对应的对象
	protected WeatherAll getWeatherAllInfo(String ... params) {
		WeatherAll weatherAll = null;
		Gson gson = new Gson();
		JSONObject weatherInfoJson ;
		JSONObject weatherIndexInfoJson;
		WeatherInfos weatherInfos = null;
		LifeIndexInfo lifeIndexInfo = null;
		weatherAll = new WeatherAll();
		try {
			weatherInfoJson = new JSONObject(params[0]);
			JSONObject weatherData = weatherInfoJson.getJSONObject("weatherinfo"); 	//获得JSON对象的数据	
			System.out.println("天气信息：" + weatherData);
			System.out.println("生活指数信息：" + lifeinfos);
			if(weatherData == null){
				weatherInfos = new WeatherInfos();
			}else{
				weatherInfos = gson.fromJson(weatherData.toString(), WeatherInfos.class);
			}
			weatherAll.setWeatherInfos(weatherInfos);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			weatherIndexInfoJson = new JSONObject(params[1]);
			JSONObject weatherIndexData = weatherIndexInfoJson.getJSONObject("zs");
			lifeIndexInfo = gson.fromJson(weatherIndexData.toString(), LifeIndexInfo.class);
		} catch (JSONException e) {
			if(lifeIndexInfo == null && weatherInfos!=null){
				
				lifeIndexInfo = new LifeIndexInfo();
				lifeIndexInfo.setCt_hint(weatherInfos.getIndex());
				lifeIndexInfo.setCt_des(weatherInfos.getIndex_d());
				
				lifeIndexInfo.setGm_hint(weatherInfos.getIndex_ag());
				lifeIndexInfo.setGm_des(weatherInfos.getIndex_ag());
				
				lifeIndexInfo.setYd_hint(weatherInfos.getIndex_cl());
				lifeIndexInfo.setYd_des(weatherInfos.getIndex_cl());
				
				lifeIndexInfo.setXc_hint(weatherInfos.getIndex_xc());
				lifeIndexInfo.setXc_des(weatherInfos.getIndex_xc());
				
				lifeIndexInfo.setTr_hint(weatherInfos.getIndex_tr());
				lifeIndexInfo.setTr_des(weatherInfos.getIndex_tr());
				
				lifeIndexInfo.setGl_hint(weatherInfos.getIndex_ls());
				lifeIndexInfo.setGl_des(weatherInfos.getIndex_ls());
				
				lifeIndexInfo.setUv_hint(weatherInfos.getIndex_uv());
				lifeIndexInfo.setUv_des(weatherInfos.getIndex_uv());
				
				lifeIndexInfo.setCo_hint(weatherInfos.getIndex_co());
				lifeIndexInfo.setCo_des(weatherInfos.getIndex_co());
				
				lifeIndexInfo.setPp_hint("暂无");
				lifeIndexInfo.setPp_des("暂无");
			}
			
			e.printStackTrace();
		}
		weatherAll.setLifeIndexInfo(lifeIndexInfo);
		return weatherAll;
	}

	public WeatherAll getWeatherAll() {
		return weatherAll;
	}

	public void setWeatherAll(WeatherAll weatherAll) {
		this.weatherAll = weatherAll;
	}

	public Context getContext() {
		return context;
	}
	
	public void setContext(Context context) {
		this.context = context;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindpower() {
		return windpower;
	}

	public void setWindpower(String windpower) {
		this.windpower = windpower;
	}

	public TextView[] getWeatherinfos() {
		return weatherinfos;
	}

	public void setWeatherinfos(TextView[] weatherinfos) {
		this.weatherinfos = weatherinfos;
	}

	public ImageView[] getWeatherinfoicons() {
		return weatherinfoicons;
	}

	public void setWeatherinfoicons(ImageView[] weatherinfoicons) {
		this.weatherinfoicons = weatherinfoicons;
	}

	public TextView[] getLifeinfos() {
		return lifeinfos;
	}

	public void setLifeinfos(TextView[] lifeinfos) {
		this.lifeinfos = lifeinfos;
	}

	public ImageView[] getLifeinfosicon() {
		return lifeinfosicon;
	}

	public void setLifeinfosicon(ImageView[] lifeinfosicon) {
		this.lifeinfosicon = lifeinfosicon;
	}

	public TextView[] getDateTextView() {
		return dateTextView;
	}

	public void setDateTextView(TextView[] dateTextView) {
		this.dateTextView = dateTextView;
	}
}
