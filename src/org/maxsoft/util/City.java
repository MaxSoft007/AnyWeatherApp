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
		city_name_list.add((TextView)view.findViewById(R.id.beijing)); //����
		city_name_list.add((TextView)view.findViewById(R.id.tianjin)); //���
		city_name_list.add((TextView)view.findViewById(R.id.shanghai)); //�Ϻ�
		city_name_list.add((TextView)view.findViewById(R.id.chongqing)); //����
		city_name_list.add((TextView)view.findViewById(R.id.shenzhen)); //����
		
		city_name_list.add((TextView)view.findViewById(R.id.guangzhou)); //����
		city_name_list.add((TextView)view.findViewById(R.id.nanjing)); //�Ͼ�
		city_name_list.add((TextView)view.findViewById(R.id.hangzhou)); //����
		city_name_list.add((TextView)view.findViewById(R.id.chengdu)); //�ɶ�
		city_name_list.add((TextView)view.findViewById(R.id.wuhan)); //�人
		
		city_name_list.add((TextView)view.findViewById(R.id.shenyang)); //����
		city_name_list.add((TextView)view.findViewById(R.id.xian)); //����
		city_name_list.add((TextView)view.findViewById(R.id.dalian)); //����
		city_name_list.add((TextView)view.findViewById(R.id.qingdao)); //�ൺ
		city_name_list.add((TextView)view.findViewById(R.id.suzhou)); //����
		
		city_name_list.add((TextView)view.findViewById(R.id.ningbo)); //����
		city_name_list.add((TextView)view.findViewById(R.id.wuxi)); //����
		city_name_list.add((TextView)view.findViewById(R.id.xianggang)); //���
		city_name_list.add((TextView)view.findViewById(R.id.aomen)); //����
		city_name_list.add((TextView)view.findViewById(R.id.xiamen)); //̨��
		
		return city_name_list;
	}
	
	public ArrayList<ImageView> init_city_bg(){
		ArrayList<ImageView> city_bg_list = new ArrayList<ImageView>();
		city_bg_list.add((ImageView)view.findViewById(R.id.beijing_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.tianjin_bg)); //���
		city_bg_list.add((ImageView)view.findViewById(R.id.shanghai_bg)); //�Ϻ�
		city_bg_list.add((ImageView)view.findViewById(R.id.chongqing_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.shenzhen_bg)); //����
		
		city_bg_list.add((ImageView)view.findViewById(R.id.guangzhou_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.nanjing_bg)); //�Ͼ�
		city_bg_list.add((ImageView)view.findViewById(R.id.hangzhou_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.chengdu_bg)); //�ɶ�
		city_bg_list.add((ImageView)view.findViewById(R.id.wuhan_bg)); //�人
		
		city_bg_list.add((ImageView)view.findViewById(R.id.shenyang_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.xian_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.dalian_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.qingdao_bg)); //�ൺ
		city_bg_list.add((ImageView)view.findViewById(R.id.suzhou_bg)); //����
		
		city_bg_list.add((ImageView)view.findViewById(R.id.ningbo_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.wuxi_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.xianggang_bg)); //���
		city_bg_list.add((ImageView)view.findViewById(R.id.aomen_bg)); //����
		city_bg_list.add((ImageView)view.findViewById(R.id.xiamen_bg)); //̨��
		return city_bg_list;
	}
	
	private static Map<String, String> map = null;
	
	/**
	 * @function ��ȡ���������õĳ�����Ϣ
	 * @param context Activity
	 * @return String[] ����code
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
	 * @function ͨ������code��ȡ��������
	 * @param citycode ����code
	 * @return ��������
	 */
	public static String getCityName(String citycode){
		String cityname = "";
		if(map != null){
			cityname = map.get(citycode);
		}
		return cityname;
	}
}
