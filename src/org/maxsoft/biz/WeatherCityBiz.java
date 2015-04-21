package org.maxsoft.biz;

import java.util.ArrayList;
import java.util.Map;
import org.maxsoft.db.DBManager;
import org.maxsoft.util.WeatherConstant;
import android.view.View;
import android.widget.Toast;

public class WeatherCityBiz {
	private boolean is_exists = false;
	/**
	 * @function 增加天气城市
	 * @param city 城市名称
	 * @param v 当前的View对象
	 */
	public boolean addWeatherCity(String city, View v) {
		boolean issuccess = false;
		DBManager manager = new DBManager(v.getContext());
		city = WeatherConstant.filterCharacters(city);
		Object[] obj = manager.isExists(city);
		if((Boolean)obj[0]){
			String code = (String)obj[1];
			Toast.makeText(v.getContext(), city + "-" + code, Toast.LENGTH_LONG).show();
			boolean isExists = manager.addWeatherCityBeforCheck(city);
			if(isExists){
				Toast.makeText(v.getContext(),"已经添加关注【"+city+"】天气信息，无须重复添加！", Toast.LENGTH_LONG).show();
			}else{
				issuccess = manager.addWeatherCity(code, city);
				if(issuccess){
					Toast.makeText(v.getContext(), "添加关注【" + city +"】天气信息成功！", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(v.getContext(), "添加关注【" +city+ "】天气信息失败！", Toast.LENGTH_LONG).show();
				}
			}
		}else{
			//Toast.makeText(v.getContext(), city, Toast.LENGTH_LONG).show();
			Toast.makeText(v.getContext(),"额，您输入的城市不存在！", Toast.LENGTH_LONG).show();
		}
		DBManager.close();
		return issuccess;
	}
	
	/**
	 * @function 删除城市
	 * @param city 城市名称
	 * @param v 当前View对象
	 * @return 是否成功
	 */
	public boolean delWeatherCity(String city,View v){
		city = WeatherConstant.filterCharacters(city);
		DBManager manager = new DBManager(v.getContext());
		boolean issuccess = manager.delWeatherCity(city);
		DBManager.close();
		return issuccess;
	}
	
	/**
	 * @function 获取所有已设置的天气城市
	 * @return Map<Integer, List<String>> 城市信息
	 */
	public Map<Integer, ArrayList<String>> getAllWeatherCity(View v){
		DBManager manager = new DBManager(v.getContext());
		Map<Integer, ArrayList<String>> allWeatherCity = manager.getAllWeatherCity();
		DBManager.close();
		return allWeatherCity;
	}
	
	/**
	 * @function 校验设置的城市
	 * @param city
	 * @param v
	 * @return
	 */
	public boolean isExistsWeatherCity(String city,View v){
		city = WeatherConstant.filterCharacters(city);
		DBManager manager = new DBManager(v.getContext());
		is_exists = manager.addWeatherCityBeforCheck(city);
		DBManager.close();
		return is_exists;
	}
	
	/**
	 * @function 根据城市代码获取最后一次更新天气信息的时间点
	 * @param code 城市代码
	 * @param v View 当前的视图
	 * @return int 最后一次更新的时间点
	 */
	public int getLastUpdateWeatherInfoTime(String code,View v){
		int last_time = -1;
		DBManager manager = new DBManager(v.getContext());
		String fchh = manager.getFCHH(code);
		if(fchh != null && fchh.trim().length() >0){
			last_time = Integer.valueOf(fchh).intValue();
		}
		DBManager.close();
		return last_time;
	}
}
