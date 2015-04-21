package org.maxsoft.custom.toast;

import org.maxsoft.weather.R;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherToast extends Toast {

	public WeatherToast(Context context) {
		super(context);
	}
	
	public static Toast makeText(Context context,int title,String content,int bg,int duration){
		Toast result = new Toast(context);
		//��ȡlayoutinflater����
		LayoutInflater lif = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//��ȡ�Զ���Toast�Ĳ����ļ�
		View view = lif.inflate(R.layout.weather_toast,null);
		//�����Զ���Toast����
		ImageView toast_img = (ImageView)view.findViewById(R.id.toast_img);
		toast_img.setImageResource(bg);
		//�����Զ���Toast����
		TextView toast_title = (TextView)view.findViewById(R.id.toast_title);
		toast_title.setText(title);
		//�����Զ�������
		TextView toast_content = (TextView)view.findViewById(R.id.toast_content);
		toast_content.setText(content);
		
		result.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
		result.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		result.setView(view);
		result.setDuration(duration);
		
		return result;
	}

}
