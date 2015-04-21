package org.maxsoft.view.utile;

import java.util.ArrayList;
import java.util.Map;

import org.maxsoft.biz.WeatherCityBiz;
import org.maxsoft.location.GetLocationInfo;
import org.maxsoft.page.adapter.DeletableAdapter;
import org.maxsoft.weather.R;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ViewUtil {
	public static void initListView(View view,Context context) {
		DeletableAdapter adapter = null;
		ListView list_view = null;
		WeatherCityBiz weatherCityBiz = null;
		try {
			list_view = (ListView) view.findViewById(R.id.already_set_list_view);
			weatherCityBiz = new WeatherCityBiz();
			Map<Integer, ArrayList<String>> map = weatherCityBiz.getAllWeatherCity(view);
			adapter = new DeletableAdapter(context,map,view);
			list_view.setAdapter(adapter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @function 获取当前位置
	 * @param view
	 */
	public static void locationInfo(final View view) {
		final GetLocationInfo getLocationInfo = new GetLocationInfo();
		final TextView city_value = (TextView) view.findViewById(R.id.location_info_city_name_value);
		final TextView area_value = (TextView) view.findViewById(R.id.location_info_code_name_value);
		final TextView sub_area_value = (TextView) view.findViewById(R.id.location_info_sub_area_name_value);
		final TextView address_value = (TextView) view.findViewById(R.id.location_info_address_name_value);
		Address add = null;
		add = getLocationInfo.getLocation(view.getContext());
		if(add != null){
			city_value.setTextColor(Color.BLACK);
			area_value.setTextColor(Color.BLACK);
			sub_area_value.setTextColor(Color.BLACK);
			address_value.setTextColor(Color.BLACK);
			city_value.setText(add.getLocality());
			area_value.setText(add.getAdminArea());
			sub_area_value.setText(add.getSubLocality());
			address_value.setText(add.getAddressLine(0));
		}else{
			String tip = "网络异常，更新失败...";
			city_value.setTextColor(Color.GRAY);
			area_value.setTextColor(Color.GRAY);
			sub_area_value.setTextColor(Color.GRAY);
			address_value.setTextColor(Color.GRAY);
			city_value.setText(tip);
			area_value.setText(tip);
			sub_area_value.setText(tip);
			address_value.setText(tip);
		}
	}
}
