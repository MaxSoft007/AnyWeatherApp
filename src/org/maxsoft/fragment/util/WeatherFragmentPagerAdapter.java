package org.maxsoft.fragment.util;

import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class WeatherFragmentPagerAdapter extends FragmentPagerAdapter{
	private ArrayList<Fragment> list = null; //���Fragment������
	private Fragment fragment = null; //fragmentʵ��
	private int count = 0; //fragment����

	public WeatherFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> list) {
		super(fm);
		this.setList(list);
	}

	@Override
	public Fragment getItem(int arg0) {
		if(this.getList() != null && this.getList().size() > 0){
			fragment = this.getList().get(arg0);
		}
		return fragment; 
	}

	@Override
	public int getCount() {
		ArrayList<Fragment> list = this.getList();
		if(list != null && list.size() > 0){
			count = list.size();
		}
		return count;
	}

	public ArrayList<Fragment> getList() {
		return list;
	}
	
	public void setList(ArrayList<Fragment> list) {
		this.list = list;
	}
}
