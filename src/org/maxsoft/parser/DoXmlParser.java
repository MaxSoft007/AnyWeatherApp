package org.maxsoft.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.maxsoft.pojo.City;
import org.maxsoft.pojo.County;
import org.maxsoft.pojo.Province;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.Context;

public class DoXmlParser{
	private InputStream inputStream = null;
	public DoXmlParser(Context context,int resource_id) {
//		inputStream = context.getResources().openRawResource(resource_id);
		try {
			inputStream =context.getAssets().open("weather_code.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Province> parserXML(){
		ArrayList<Province> provinces = new ArrayList<Province>();
		Province province = null;
		City city = null;
		County county = null;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputStream);
			Element root = doc.getDocumentElement();
			NodeList nodes = root.getElementsByTagName("province");
			for(int i=0;i<nodes.getLength();i++){
				province = new Province();
				Node node = nodes.item(i);
				
				province.setId(node.getAttributes().getNamedItem("id").getNodeValue());
				province.setName(node.getAttributes().getNamedItem("name").getNodeValue());
				NodeList citynodes = node.getChildNodes();
				for(int j=0;j<citynodes.getLength(); j++){
					city = new City();
					Node node1 = citynodes.item(j);
					city.setId(node1.getAttributes().getNamedItem("id").getNodeValue());
					city.setName(node1.getAttributes().getNamedItem("name").getNodeValue());
					NodeList countylist = node1.getChildNodes();
					for(int k=0; k<countylist.getLength(); k++){
						county = new County();
						Node node2 = countylist.item(k);
						county.setId(node2.getAttributes().getNamedItem("id").getNodeValue());
						county.setName(node2.getAttributes().getNamedItem("name").getNodeValue());
						county.setWeatherCode(node2.getAttributes().getNamedItem("weatherCode").getNodeValue());
						city.getCounty().add(county);
					}
					province.getCitys().add(city);
				}
				provinces.add(province);
			}
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return provinces;
	}
}
