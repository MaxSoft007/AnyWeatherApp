package org.maxsoft.biz;

import java.util.ArrayList;
import java.util.Map;
import org.maxsoft.db.DBManager;
import org.maxsoft.util.WeatherConstant;
import android.view.View;
import android.widget.Toast;

public class WeatherCityBiz {
	private boolean is_exists = false;
	/**
	 * @function ������������
	 * @param city ��������
	 * @param v ��ǰ��View����
	 */
	public boolean addWeatherCity(String city, View v) {
		boolean issuccess = false;
		DBManager manager = new DBManager(v.getContext());
		city = WeatherConstant.filterCharacters(city);
		Object[] obj = manager.isExists(city);
		if((Boolean)obj[0]){
			String code = (String)obj[1];
			Toast.makeText(v.getContext(), city + "-" + code, Toast.LENGTH_LONG).show();
			boolean isExists = manager.addWeatherCityBeforCheck(city);
			if(isExists){
				Toast.makeText(v.getContext(),"�Ѿ���ӹ�ע��"+city+"��������Ϣ�������ظ���ӣ�", Toast.LENGTH_LONG).show();
			}else{
				issuccess = manager.addWeatherCity(code, city);
				if(issuccess){
					Toast.makeText(v.getContext(), "��ӹ�ע��" + city +"��������Ϣ�ɹ���", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(v.getContext(), "��ӹ�ע��" +city+ "��������Ϣʧ�ܣ�", Toast.LENGTH_LONG).show();
				}
			}
		}else{
			//Toast.makeText(v.getContext(), city, Toast.LENGTH_LONG).show();
			Toast.makeText(v.getContext(),"�������ĳ��в����ڣ�", Toast.LENGTH_LONG).show();
		}
		DBManager.close();
		return issuccess;
	}
	
	/**
	 * @function ɾ������
	 * @param city ��������
	 * @param v ��ǰView����
	 * @return �Ƿ�ɹ�
	 */
	public boolean delWeatherCity(String city,View v){
		city = WeatherConstant.filterCharacters(city);
		DBManager manager = new DBManager(v.getContext());
		boolean issuccess = manager.delWeatherCity(city);
		DBManager.close();
		return issuccess;
	}
	
	/**
	 * @function ��ȡ���������õ���������
	 * @return Map<Integer, List<String>> ������Ϣ
	 */
	public Map<Integer, ArrayList<String>> getAllWeatherCity(View v){
		DBManager manager = new DBManager(v.getContext());
		Map<Integer, ArrayList<String>> allWeatherCity = manager.getAllWeatherCity();
		DBManager.close();
		return allWeatherCity;
	}
	
	/**
	 * @function У�����õĳ���
	 * @param city
	 * @param v
	 * @return
	 */
	public boolean isExistsWeatherCity(String city,View v){
		city = WeatherConstant.filterCharacters(city);
		DBManager manager = new DBManager(v.getContext());
		is_exists = manager.addWeatherCityBeforCheck(city);
		DBManager.close();
		return is_exists;
	}
	
	/**
	 * @function ���ݳ��д����ȡ���һ�θ���������Ϣ��ʱ���
	 * @param code ���д���
	 * @param v View ��ǰ����ͼ
	 * @return int ���һ�θ��µ�ʱ���
	 */
	public int getLastUpdateWeatherInfoTime(String code,View v){
		int last_time = -1;
		DBManager manager = new DBManager(v.getContext());
		String fchh = manager.getFCHH(code);
		if(fchh != null && fchh.trim().length() >0){
			last_time = Integer.valueOf(fchh).intValue();
		}
		DBManager.close();
		return last_time;
	}
}
