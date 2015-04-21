package org.maxsoft.rss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class RSSFeed extends RSSBase{
	private String webMaster;
	private int itemcount;
	private List<RSSItem> listitem;
	public RSSFeed() {
		listitem = new Vector<RSSItem>();
	}
	
	//Ìí¼ÓRSSItem
	public int addItem(RSSItem item){
		listitem.add(item);
		itemcount++;
		return itemcount;
	}
	
	public RSSItem getRSSItem(int index){
		return listitem.get(index);
	}
	
	public List<RSSItem> getAllItem(){
		return listitem;
	}
	
	public List<Map<String, Object>> getAllItrmsForListView(){
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		int size = listitem.size();
		HashMap<String, Object> map = null;
		for (int i = 0; i < size; i++) {
			map = new HashMap<String, Object>();
			map.put(RSSItem.TITLE, listitem.get(i).getTitle());
			map.put(RSSItem.PUBDATE, listitem.get(i).getPubdate());
			data.add(map);
		}
		return data;
	}

	public String getWebMaster() {
		return webMaster;
	}

	public void setWebMaster(String webMaster) {
		this.webMaster = webMaster;
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}
}
