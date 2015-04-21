package org.maxsoft.pojo;

import java.io.Serializable;
/**
 * @function 县区实体
 * @author MaxSoft
 * @date 2015-01-02
 * @version 1.0.0
 */
public class County implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id = "";
	private String name = "";
	private String weatherCode = "";
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
	public String getWeatherCode() {
		return weatherCode;
	}
	public void setWeatherCode(String weatherCode) {
		this.weatherCode = weatherCode;
	}
}
