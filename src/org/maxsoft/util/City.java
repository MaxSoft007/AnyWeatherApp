package org.maxsoft.util;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.maxsoft.db.DBManager;
import org.maxsoft.weather.R;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class City {
	private View view = null;
	public City(View view){
		this.view = view;
	}

	public ArrayList<TextView> init_city_name(){
		ArrayList<TextView> city_name_list = new ArrayList<TextView>();
		city_name_list.add((TextView)view.findViewById(R.id.beijing)); //北京
		city_name_list.add((TextView)view.findViewById(R.id.tianjin)); //天津
		city_name_list.add((TextView)view.findViewById(R.id.shanghai)); //上海
		city_name_list.add((TextView)view.findViewById(R.id.chongqing)); //重庆
		city_name_list.add((TextView)view.findViewById(R.id.shenzhen)); //深圳
		
		city_name_list.add((TextView)view.findViewById(R.id.guangzhou)); //广州
		city_name_list.add((TextView)view.findViewById(R.id.nanjing)); //南京
		city_name_list.add((TextView)view.findViewById(R.id.hangzhou)); //杭州
		city_name_list.add((TextView)view.findViewById(R.id.chengdu)); //成都
		city_name_list.add((TextView)view.findViewById(R.id.wuhan)); //武汉
		
		city_name_list.add((TextView)view.findViewById(R.id.shenyang)); //沈阳
		city_name_list.add((TextView)view.findViewById(R.id.xian)); //西安
		city_name_list.add((TextView)view.findViewById(R.id.dalian)); //大连
		city_name_list.add((TextView)view.findViewById(R.id.qingdao)); //青岛
		city_name_list.add((TextView)view.findViewById(R.id.suzhou)); //苏州
		
		city_name_list.add((TextView)view.findViewById(R.id.ningbo)); //宁波
		city_name_list.add((TextView)view.findViewById(R.id.wuxi)); //无锡
		city_name_list.add((TextView)view.findViewById(R.id.xianggang)); //香港
		city_name_list.add((TextView)view.findViewById(R.id.aomen)); //澳门
		city_name_list.add((TextView)view.findViewById(R.id.xiamen)); //台湾
		
		return city_name_list;
	}
	
	public ArrayList<ImageView> init_city_bg(){
		ArrayList<ImageView> city_bg_list = new ArrayList<ImageView>();
		city_bg_list.add((ImageView)view.findViewById(R.id.beijing_bg)); //北京
		city_bg_list.add((ImageView)view.findViewById(R.id.tianjin_bg)); //天津
		city_bg_list.add((ImageView)view.findViewById(R.id.shanghai_bg)); //上海
		city_bg_list.add((ImageView)view.findViewById(R.id.chongqing_bg)); //重庆
		city_bg_list.add((ImageView)view.findViewById(R.id.shenzhen_bg)); //深圳
		
		city_bg_list.add((ImageView)view.findViewById(R.id.guangzhou_bg)); //广州
		city_bg_list.add((ImageView)view.findViewById(R.id.nanjing_bg)); //南京
		city_bg_list.add((ImageView)view.findViewById(R.id.hangzhou_bg)); //杭州
		city_bg_list.add((ImageView)view.findViewById(R.id.chengdu_bg)); //成都
		city_bg_list.add((ImageView)view.findViewById(R.id.wuhan_bg)); //武汉
		
		city_bg_list.add((ImageView)view.findViewById(R.id.shenyang_bg)); //沈阳
		city_bg_list.add((ImageView)view.findViewById(R.id.xian_bg)); //西安
		city_bg_list.add((ImageView)view.findViewById(R.id.dalian_bg)); //大连
		city_bg_list.add((ImageView)view.findViewById(R.id.qingdao_bg)); //青岛
		city_bg_list.add((ImageView)view.findViewById(R.id.suzhou_bg)); //苏州
		
		city_bg_list.add((ImageView)view.findViewById(R.id.ningbo_bg)); //宁波
		city_bg_list.add((ImageView)view.findViewById(R.id.wuxi_bg)); //无锡
		city_bg_list.add((ImageView)view.findViewById(R.id.xianggang_bg)); //香港
		city_bg_list.add((ImageView)view.findViewById(R.id.aomen_bg)); //澳门
		city_bg_list.add((ImageView)view.findViewById(R.id.xiamen_bg)); //台湾
		return city_bg_list;
	}
	
	private static Map<String, String> map = null;
	
	/**
	 * @function 获取所有已设置的城市信息
	 * @param context Activity
	 * @return String[] 城市code
	 */
	public static String[] getAllCityCode(Context context){
		DBManager manager = new DBManager(context);
		map = manager.getAllCityCode();
		String[] citycodes = null;
		if(map != null){
			Set<String> set = map.keySet();
			citycodes = new String[set.size()];
			citycodes = set.toArray(citycodes);
		}
		DBManager.close();
		return citycodes;
	}
	
	/**
	 * @function 通过城市code获取城市名称
	 * @param citycode 城市code
	 * @return 城市名称
	 */
	public static String getCityName(String citycode){
		String cityname = "";
		if(map != null){
			cityname = map.get(citycode);
		}
		return cityname;
	}
}
