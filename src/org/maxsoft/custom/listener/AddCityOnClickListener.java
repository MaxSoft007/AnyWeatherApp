package org.maxsoft.custom.listener;

import org.maxsoft.biz.WeatherCityBiz;
import org.maxsoft.util.WeatherConstant;
import org.maxsoft.view.utile.ViewUtil;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class AddCityOnClickListener implements OnClickListener {
	private String city = null;
	private TextView child_view = null;
	private View view = null;
	private WeatherCityBiz weatherCityBiz = null;
	private Context context =null;
	public AddCityOnClickListener(View view,String param,TextView child_view,Context context) {
		this.city = param;
		this.child_view = child_view;
		this.view = view;
		this.context = context;
	}
	@Override
	public void onClick(View v) {
		boolean issuccess = false;
		String temp = child_view.getText().toString();
		weatherCityBiz = new WeatherCityBiz();
		if(temp.contains("√")){
			issuccess = weatherCityBiz.delWeatherCity(city, v);
			if(issuccess){
				city = WeatherConstant.filterCharacters(city);
				child_view.setText(city);
				ViewUtil.initListView(view, context);
				Toast.makeText(v.getContext(),"取消关注【" + city+"】天气信息成功！",Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(v.getContext(),"取消关注【" + city+"】天气信息失败！请重试...",Toast.LENGTH_SHORT).show();
			}
		}else{
			issuccess = weatherCityBiz.addWeatherCity(city, v);
			if(issuccess){
				ViewUtil.initListView(view, context);
				if(!temp.contains("√")){
					child_view.setText(temp + " √");
				}
			}
		}
	}
}
