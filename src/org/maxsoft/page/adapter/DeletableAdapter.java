package org.maxsoft.page.adapter;

import java.util.ArrayList;
import java.util.Map;
import org.maxsoft.biz.WeatherCityBiz;
import org.maxsoft.util.City;
import org.maxsoft.util.WeatherConstant;
import org.maxsoft.weather.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DeletableAdapter extends BaseAdapter {
	private View c_view;
	private Context context;
	private ArrayList<String> province_list;
	private ArrayList<String> city_list;
	private ArrayList<String> temp_weather;
	private WeatherCityBiz weatherCityBiz = null;
	
	/**
	 * @function 带参构造
	 * @param context
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public DeletableAdapter(Context context,Map<?, ?> map,View view) {
		this.context = context;
		this.c_view = view;
		if(map != null){
			city_list = (ArrayList<String>) map.get(0);
			province_list = (ArrayList<String>) map.get(1);
			temp_weather = (ArrayList<String>) map.get(2);
		}
	}

	/**
	 * @function 获取数据总数
	 */
	@Override
	public int getCount() {
		return city_list.size();
	}

	/**
	 * @function 获取当前条目
	 */
	@Override
	public Object getItem(int position) {
		return city_list.get(position);
	}

	/**
	 * 获取当前条目ID
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * @function 获取当前的视图
	 */
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final int index = position;
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.list_view, null);
		}
		final TextView textView = (TextView) view.findViewById(R.id.simple_item_1);
		textView.setText(city_list.get(position)+"("+province_list.get(position)+")");
		TextView textView2 = (TextView) view.findViewById(R.id.simple_item_3);
		textView2.setText(temp_weather.get(position));
		final ImageView imageView = (ImageView) view.findViewById(R.id.simple_item_2);
		imageView.setBackgroundResource(R.drawable.del);
		imageView.setTag(position);
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String city = city_list.get(index);
				boolean issuccess = false;
				weatherCityBiz = new WeatherCityBiz();
				issuccess = weatherCityBiz.delWeatherCity(city, v);
				if(issuccess){
					city = WeatherConstant.filterCharacters(city);
					City city_list_ = new City(c_view);
					String temp = "";
					TextView t_view = null;
					ArrayList<TextView> city_name_list = city_list_.init_city_name();
					if(city_name_list != null){
						for (int i = 0 ; i < city_name_list.size(); i++) {
							t_view = city_name_list.get(i);
							temp = t_view.getText().toString();
							temp = WeatherConstant.filterCharacters(temp);
							city = WeatherConstant.filterCharacters(city);
							if(temp.equals(city)){
								t_view.setText(city);
							}
						}
					}
					city_list.remove(index);
					province_list.remove(index);
					temp_weather.remove(index);
					notifyDataSetChanged();
					Toast.makeText(v.getContext(),"取消关注【" + city+"】天气信息成功！",Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(v.getContext(),"取消关注【" + city+"】天气信息失败！请重试...",Toast.LENGTH_SHORT).show();
				}
			}
		});
		return view;
	}

}
