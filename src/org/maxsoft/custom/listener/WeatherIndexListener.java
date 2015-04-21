package org.maxsoft.custom.listener;

import org.maxsoft.custom.toast.WeatherToast;
import org.maxsoft.pojo.TipInfo;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * @function 自定义Toast
 * @author MaxSoft
 * @date 2014-12-20
 * @version 1.0.0
 */
public class WeatherIndexListener implements OnClickListener{
	private TipInfo tipInfo = null;  //Toast显示信息实体
	public WeatherIndexListener() {
		//TODO
	}
	public WeatherIndexListener(TipInfo tipInfo) {
		this.tipInfo = tipInfo;
	}
	@Override
	public void onClick(View v) {
		WeatherToast.makeText(v.getContext(), tipInfo.getTitle(), tipInfo.getContent(),tipInfo.getIndex_bg(), tipInfo.getDuration()).show();
	}
	
}
