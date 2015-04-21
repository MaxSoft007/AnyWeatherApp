package org.maxsoft.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @function 城市实体
 * @author MaxSoft
 * @date 2015-01-02
 * @version 1.0.0
 */
public class City implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id = "";
	private String name = "";
	private ArrayList<County> county = new ArrayList<County>();
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
	public ArrayList<County> getCounty() {
		return county;
	}
	public void setCounty(ArrayList<County> county) {
		this.county = county;
	}
}
