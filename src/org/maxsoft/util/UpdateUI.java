package org.maxsoft.util;

import org.maxsoft.pojo.LifeIndexInfo;
import org.maxsoft.pojo.WeatherInfos;
import android.widget.ImageView;
import android.widget.TextView;

public class UpdateUI implements Runnable{
	private WeatherInfos info = null;
	private LifeIndexInfo indexInfo = null;
	private TextView[] weatherinfos; 
	private ImageView[] weatherinfoicons;
	private TextView[] lifeinfos;
	private ImageView[] lifeinfosicon;
	private TextView[] dateTextView;
	public UpdateUI(WeatherInfos info, TextView[] weatherinfos,ImageView[] weatherinfoicons) {
		this.info = info;
		this.weatherinfos = weatherinfos;
		this.weatherinfoicons = weatherinfoicons;
	}

	public UpdateUI(WeatherInfos info, LifeIndexInfo indexInfo,TextView[] weatherinfos, ImageView[] weatherinfoicons,TextView[] lifeinfos, ImageView[] lifeinfosicon,TextView[] dateTextView) {
		this.info = info;
		this.indexInfo = indexInfo;
		this.weatherinfos = weatherinfos;
		this.weatherinfoicons = weatherinfoicons;
		this.lifeinfos = lifeinfos;
		this.lifeinfosicon = lifeinfosicon;
		this.dateTextView = dateTextView;
	}

	public UpdateUI(LifeIndexInfo indexInfo, TextView[] lifeinfos,ImageView[] lifeinfosicon) {
		this.indexInfo = indexInfo;
		this.lifeinfos = lifeinfos;
		this.lifeinfosicon = lifeinfosicon;
	}

	@Override
	public void run() {
		initWeatherInfo();
		initLifeIndexInfo();
	}
	ReadWeatherInfo readWeatherInfo = new ReadWeatherInfo();
	public void initWeatherInfo() {
		
		readWeatherInfo.setWeatherinfos(weatherinfos);
		readWeatherInfo.setWeatherinfoicons(weatherinfoicons);
		readWeatherInfo.setDateTextView(dateTextView);
		readWeatherInfo.initWeatherInfo(info);
	}
	
	public void initLifeIndexInfo(){
		readWeatherInfo.setLifeinfos(lifeinfos);
		readWeatherInfo.setLifeinfosicon(lifeinfosicon);
		readWeatherInfo.initLifeIndexInfo(indexInfo);
	}
}
