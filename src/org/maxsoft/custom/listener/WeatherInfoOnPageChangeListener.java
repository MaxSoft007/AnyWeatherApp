package org.maxsoft.custom.listener;
import org.maxsoft.util.City;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherInfoOnPageChangeListener implements OnPageChangeListener {
	private int currIndex = 0;
	private Context context;
	private TextView barText;
	private String[] citycode;
	private View view;
	private TextView cityname;

	@Override
	public void onPageScrollStateChanged(int arg0) {	
		
	}

	@Override
	public void onPageSelected(int arg0) {
		this.setCurrIndex(arg0);
		int i = this.getCurrIndex();
		cityname.setText(City.getCityName(getCitycode()[i]));
		Toast.makeText(this.getContext(), "ƒ˙—°‘Ò¡À[" + City.getCityName(getCitycode()[i])+ "] –£°", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	public int getCurrIndex() {
		return currIndex;
	}

	public void setCurrIndex(int currIndex) {
		this.currIndex = currIndex;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public TextView getBarText() {
		return barText;
	}

	public void setBarText(TextView barText) {
		this.barText = barText;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public String[] getCitycode() {
		return citycode;
	}

	public void setCitycode(String[] citycode) {
		this.citycode = citycode;
	}

	public TextView getCityname() {
		return cityname;
	}

	public void setCityname(TextView cityname) {
		this.cityname = cityname;
	}

}
