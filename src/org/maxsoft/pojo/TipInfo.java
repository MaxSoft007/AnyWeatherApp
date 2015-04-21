package org.maxsoft.pojo;

import java.io.Serializable;

import android.widget.Toast;

/**
 * @function ��ʾ��Ϣʵ��
 * @author MaxSoft
 * @date 2014-12-20
 * @version 1.0.0
 */
public class TipInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String content = "";  //��ʾ����
	private int title = 0;  //��ʾ����
	private int index_bg = 0;  //��ʾ��Ϣ����ɫ
	private int duration = Toast.LENGTH_SHORT;  //��ʾ��Ϣͣ��ʱ�䳤��
	public TipInfo() {
		super();
	}

	/**
	 * @function ���������캯������ʾʱ��Ĭ��ΪToast.LENGTH_LONG��
	 * @param String content ��ʾ����
	 * @param int title ��ʾ����R.String.xxxx
	 * @param int index_bg ��ʾ����ͼƬ
	 */
	public TipInfo(String content, int title, int index_bg) {
		this.content = content;
		this.title = title;
		this.index_bg = index_bg;
	}
	
	/**
	 * @function ���������캯��
	 * @param String content ��ʾ����
	 * @param int title ��ʾ����R.String.xxxx
	 * @param int index_bg ��ʾ����ͼƬ
	 * @param int duration ��ʾ��Ϣ��ʱ�䳤��
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
