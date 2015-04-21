package org.maxsoft.custom.toast;

import org.maxsoft.weather.R;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherWaitToast extends Toast {

	public WeatherWaitToast(Context context) {
		super(context);
	}
	
	public static Toast MakeText(Context context,int content,int wait_icon,int duration){
		Toast result = new Toast(context);
		//获取layoutinflater对象
		LayoutInflater lif = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//获取自定义Toast的布局文件
		View view = lif.inflate(R.layout.weather_wait,null);
		
		//设置自定义内容
		TextView toast_content = (TextView)view.findViewById(R.id.wait_content);
		toast_content.setText(context.getString(R.string.wait_conternt));
		
		//设置自定义图标
		ImageView imageView = (ImageView)view.findViewById(R.id.wait_img);
		imageView.setBackgroundResource(wait_icon);
		final AnimationDrawable animationDrawable = (AnimationDrawable)imageView.getBackground();
		imageView.post(new Runnable() {
		    @Override
	        public void run()  {
	            animationDrawable.start();
	        }
		});
		result.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
		result.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		result.setView(view);
		result.setDuration(duration);
		return result;
	}

}
