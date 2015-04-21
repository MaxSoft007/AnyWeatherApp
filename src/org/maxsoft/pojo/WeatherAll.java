package org.maxsoft.pojo;

import java.io.Serializable;

public class WeatherAll implements Serializable{
	private static final long serialVersionUID = 1L;
	private WeatherInfos weatherInfos = new WeatherInfos();
	private LifeIndexInfo lifeIndexInfo = new LifeIndexInfo();
	public WeatherInfos getWeatherInfos() {
		return weatherInfos;
	}
	public void setWeatherInfos(WeatherInfos weatherInfos) {
		this.weatherInfos = weatherInfos;
	}
	public LifeIndexInfo getLifeIndexInfo() {
		return lifeIndexInfo;
	}
	public void setLifeIndexInfo(LifeIndexInfo indexInfo) {
		this.lifeIndexInfo = indexInfo;
	}
}
