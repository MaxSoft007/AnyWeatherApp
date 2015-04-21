package org.maxsoft.custom.listener;

import org.maxsoft.db.DBManager;
import org.maxsoft.pojo.WeatherInfos;
import org.maxsoft.weather.R;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * @function 分享功能的监听器
 * @author MaxSoft
 * @date 2014-12-21
 * @version 1.0.0
 */
public class WeatherShareListener implements OnClickListener {
	private TextView text_view = null;
	
	public WeatherShareListener(TextView text_view) {
		this.text_view = text_view;
	}

	@Override
	public void onClick(View v) {
		DBManager manager = new DBManager(v.getContext());
		Object[] exists = manager.isExists(text_view.getText().toString().trim());
		StringBuffer buffer = new StringBuffer();
		buffer.append(text_view.getText()).append(" ");
		if(exists != null && exists.length > 0){
			if((Boolean)exists[0]){
				String code = (String)exists[1];
				WeatherInfos infos = new WeatherInfos();
				infos.setCityid(code);
				WeatherInfos weatherInfos = manager.getWeatherInfos(infos);
				buffer.append(weatherInfos.getDate_y()).append(" " +weatherInfos.getFchh() + "点更新  ");
				buffer.append(weatherInfos.getTemp1()).append(" ");
				buffer.append(weatherInfos.getWeather1()).append(" ");
				buffer.append(weatherInfos.getFx1()).append(weatherInfos.getFl1()).append("\n        ");
			}
		}
		//Toast.makeText(v.getContext(),buffer.toString(), Toast.LENGTH_LONG).show();
		Intent intent=new Intent(Intent.ACTION_SEND); 
		intent.setType("text/plain"); //"image/*"
		intent.putExtra(Intent.EXTRA_SUBJECT,v.getContext().getString(R.string.share_title)); 
		intent.putExtra(Intent.EXTRA_TEXT,buffer.append(v.getContext().getString(R.string.share_contnet)).toString() );
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
		v.getContext().startActivity(Intent.createChooser(intent, v.getContext().getString(R.string.share_action)));			
	}
}
