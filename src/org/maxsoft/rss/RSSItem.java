package org.maxsoft.rss;

public class RSSItem extends RSSBase{
	private String pubdate;
	public static final String TITLE="title";
	public static final String PUBDATE="pubDate";
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
}
