package org.maxsoft.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.maxsoft.pojo.LifeIndexInfo;
import org.maxsoft.pojo.WeatherAll;
import org.maxsoft.pojo.WeatherInfos;

import com.google.gson.Gson;

import android.os.AsyncTask;
import android.util.Log;

public class ReadJSONTask extends AsyncTask<String ,Void,String>{
	
	public String readJSONFeed(String URL){		
		StringBuilder stringBuilder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(URL);
		try{
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();			
			if(statusCode == 200){
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();				
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));			
				String line;			
				while((line = reader.readLine())!= null){				
					stringBuilder.append(line);				
				}
			}else{
				Log.e("JSON","Failed to download file");
			}
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
	
	@Override
	protected void onPostExecute(String result) {
		
	}
	@Override
	protected String doInBackground(String... urls) {
		return readJSONFeed(urls[0]);
	}	
	
	//自定义函数返回天气预报信息的地址
	public String weatherInfoUrl(String str){
		String url = "http://m.weather.com.cn/atad/"+ str + ".html";
		return url;
	}
	
	public String weatherIndexInfoUrl(String str){
		String url = "http://www.weather.com.cn/data/zs/" + str + ".html";
		return url;
	}
	
	public WeatherAll getWeatherAllInfo() {
		String m_weather_infos;
		String m_weather_index_infos;
		WeatherAll weatherAll = null;
		ReadJSONTask weatherInfo = new ReadJSONTask();
		String weatherInfoUrl = weatherInfo.weatherInfoUrl("101010100");  //获取天气预报的地址
		weatherInfo.execute(weatherInfoUrl);  //开启获取天气预报的线程
		
		ReadJSONTask weatherIndexInfo = new ReadJSONTask();
		String weatherIndexInfoUrl = weatherIndexInfo.weatherIndexInfoUrl("101010100");
		weatherIndexInfo.execute(weatherIndexInfoUrl);
		
		try {
			m_weather_infos = weatherInfo.get();  //天气信息
			m_weather_index_infos = weatherIndexInfo.get();  //生活指数信息
			
			Gson gson = new Gson();
			JSONObject weatherInfoJson ;
			JSONObject weatherIndexInfoJson;
			try {
				weatherInfoJson = new JSONObject(m_weather_infos);
				weatherIndexInfoJson = new JSONObject(m_weather_index_infos);
				JSONObject weatherData = weatherInfoJson.getJSONObject("weatherinfo"); 	//获得JSON对象的数据	
				JSONObject weatherIndexData = weatherIndexInfoJson.getJSONObject("zs");
				WeatherInfos weatherInfos = gson.fromJson(weatherData.toString(), WeatherInfos.class);
				LifeIndexInfo lifeIndexInfo = gson.fromJson(weatherIndexData.toString(), LifeIndexInfo.class);
				weatherAll = new WeatherAll();
				weatherAll.setWeatherInfos(weatherInfos);
				weatherAll.setLifeIndexInfo(lifeIndexInfo);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return weatherAll;
	} 
}
