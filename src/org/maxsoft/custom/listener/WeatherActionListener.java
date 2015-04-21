package org.maxsoft.custom.listener;
import org.maxsoft.weather.HomeActivity;
import org.maxsoft.weather.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * @function ActivityÌø×ª¼àÌýÆ÷
 * @author MaxSoft
 * @date 2014-12-21
 * @version 1.0.0
 */
public class WeatherActionListener implements OnClickListener{
	private Activity activityClass = null;

	public WeatherActionListener(){
	}
	
	public WeatherActionListener(Activity activityClass) {
		this.activityClass = activityClass;
	}
	
	@Override
	public void onClick(View v) {
		createListener(v);
	}

	private void createListener(View view){
		final Intent intent = new Intent();
		ImageView home = (ImageView)view.findViewById(R.id.home_img);
		home.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.setClass(v.getContext(),new HomeActivity().getClass());
				v.getContext().startActivity(intent);
				activityClass.finish();
			}
		});
	}

	public Activity getActivityClass() {
		return activityClass;
	}

	public void setActivityClass(Activity activityClass) {
		this.activityClass = activityClass;
	}
}
