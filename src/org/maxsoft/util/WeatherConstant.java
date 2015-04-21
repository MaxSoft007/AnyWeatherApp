package org.maxsoft.util;

public class WeatherConstant {
	public static final String M_UPDATE_TIME = "M_UPDATE_TIME";
	public static final String CONFIG_NAME = "config.ini";
	
	//中国气象局更新气象信息的时间节点
	public static final int UPDATE_FIRST_TIME = 8;
	public static final int UPDATE_SECOND_TIME = 11;
	public static final int UPDATE_THREE_TIME = 18;
	public static final String UPDATE_FIRST_TIME_K = "8";
	public static final String UPDATE_SECOND_TIME_K = "11";
	public static final String UPDATE_THREE_TIME_K = "18";
	
	public static String filterCharacters(String city) {
		city = city.trim();
		if(city.contains(" ")){
			city = city.replaceAll(" ", "");
		}
		if(city.contains("√")){
			city = city.replace("√", "");
		}
		if(city.contains("-")){
			city = city.trim().split("-")[0];
		}
		return city;
	}
}
