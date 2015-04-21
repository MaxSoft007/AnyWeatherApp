package org.maxsoft.rss;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSSHandler extends DefaultHandler{
	private static final String CHANNEL = "channel";
	private static final String ITEM = "item";
	private static final String TITLE = "title";
	private static final String LINK = "link";
	private static final String PUBDATE = "pubDate";
	private static final String DESCRIPTION = "description"; 
	private RSSFeed rssFeed;
	private RSSItem rssItem;
	private final int RSS_TITLE = 1;
	private final int RSS_LINK = 2;
	private final int RSS_PUBDATE = 3;
	private final int RSS_DESCRIPTION = 4;
	StringBuffer temp = new StringBuffer();
	private int currentstate = 0;
	public RSSHandler(){
	}
	public RSSFeed getFeed(){
		return rssFeed;
	}
	@Override
	public void startDocument() throws SAXException {
		rssFeed = new RSSFeed();
		rssItem = new RSSItem();
	}
	@Override
	public void endDocument() throws SAXException {
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		temp.setLength(0);
		if(localName.equals(CHANNEL)){
			currentstate = 0;
			return ;
		}
		if(localName.equals(ITEM)){
			rssItem = new RSSItem();
			return;
		}
		if(localName.endsWith(TITLE)){
			currentstate = RSS_TITLE;
			return;
		}
		if(localName.equals(LINK)){
			currentstate = RSS_LINK;
			return;
		}
		if(localName.equals(PUBDATE)){
			currentstate = RSS_PUBDATE;
			return;
		}
		if(localName.equals(DESCRIPTION)){
			currentstate = RSS_DESCRIPTION;
			return;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName.equals(ITEM)){
			rssItem.setDescription(temp.toString());
			rssFeed.addItem(rssItem);
			return;
		}
	}
	final int CHARACTERS_MAX_LENGTH = 2048; 
	String preMaxLengthCharacters = "";  
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		switch (currentstate) {
		case RSS_TITLE:
			rssItem.setTitle(content);
			currentstate = 0;
			break;
		case RSS_LINK:
			rssItem.setLink(content);
			currentstate = 0;
			break;
		case RSS_PUBDATE:
			rssItem.setPubdate(content);
			break;
		case RSS_DESCRIPTION:
			temp.append(content);
			break;
		default:
			return;
		}
	}
}
