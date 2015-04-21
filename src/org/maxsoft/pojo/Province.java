package org.maxsoft.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @function 省份实体
 * @author MaxSoft
 * @date 2015-01-02
 * @version 1.0.0
 */
public class Province implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id = "";
	private String name = "";
	private ArrayList<City> citys = new ArrayList<City>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<City> getCitys() {
		return citys;
	}
	public void setCitys(ArrayList<City> citys) {
		this.citys = citys;
	}
}
