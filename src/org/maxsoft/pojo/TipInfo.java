package org.maxsoft.pojo;

import java.io.Serializable;

import android.widget.Toast;

/**
 * @function 提示信息实体
 * @author MaxSoft
 * @date 2014-12-20
 * @version 1.0.0
 */
public class TipInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String content = "";  //提示内容
	private int title = 0;  //提示标题
	private int index_bg = 0;  //提示信息背景色
	private int duration = Toast.LENGTH_SHORT;  //提示信息停留时间长度
	public TipInfo() {
		super();
	}

	/**
	 * @function 带参数构造函数（显示时间默认为Toast.LENGTH_LONG）
	 * @param String content 显示内容
	 * @param int title 显示标题R.String.xxxx
	 * @param int index_bg 显示背景图片
	 */
	public TipInfo(String content, int title, int index_bg) {
		this.content = content;
		this.title = title;
		this.index_bg = index_bg;
	}
	
	/**
	 * @function 带参数构造函数
	 * @param String content 显示内容
	 * @param int title 显示标题R.String.xxxx
	 * @param int index_bg 显示背景图片
	 * @param int duration 显示信息的时间长度
	 */
	public TipInfo(String content, int title, int index_bg, int duration) {
		this.content = content;
		this.title = title;
		this.index_bg = index_bg;
		this.duration = duration;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	public int getIndex_bg() {
		return index_bg;
	}
	public void setIndex_bg(int index_bg) {
		this.index_bg = index_bg;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
