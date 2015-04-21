package org.maxsoft.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.maxsoft.pojo.LifeIndexInfo;
import org.maxsoft.pojo.WeatherInfos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	private DBHelper dbhelper;
	private static SQLiteDatabase db;
	private boolean is_success = false;
	private Cursor cursor = null;
	public DBManager(Context context){
		dbhelper = new DBHelper(context);
		db = dbhelper.getWritableDatabase();
		db.execSQL(dbhelper.initCreateWeatherCitySQL());
	}
	
	public String test(){
		cursor = db.rawQuery("SELECT * FROM WEATHER_CODE WC ,WEATHER_PROVINCE WP WHERE WC.",null);
		String aaa = "";
		while(cursor.moveToNext()){
			aaa +=  cursor.getString(cursor.getColumnIndex("PROVINCE"));
		}
		cursor.close();
		return aaa;
	}

	//插入天气信息
	public boolean addWeatherInfo(WeatherInfos info){
		try {
			db.beginTransaction(); //开启事物
			db.execSQL(addWeatherInfoSQL(info),getWeatherAttributes(info));
			db.setTransactionSuccessful();
			is_success = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.endTransaction();
		}
		return is_success;
	}
	
	public WeatherInfos getWeatherInfos(WeatherInfos infos){
		WeatherInfos weatherInfos = null;
		try {
			cursor = db.rawQuery("SELECT * FROM WEATHERINFOS W WHERE W.CITYID=? ORDER BY _ID DESC", new String[]{infos.getCityid()});
			weatherInfos = new WeatherInfos();
			if(cursor.moveToNext()) {
				weatherInfos.setCity(cursor.getString(cursor.getColumnIndex("CITY")));
				weatherInfos.setDate_y(cursor.getString(cursor.getColumnIndex("DATE_Y")));
				weatherInfos.setFl1(cursor.getString(cursor.getColumnIndex("FL1")));
				weatherInfos.setFl2(cursor.getString(cursor.getColumnIndex("FL2")));
				weatherInfos.setFl3(cursor.getString(cursor.getColumnIndex("FL3")));
				weatherInfos.setFl4(cursor.getString(cursor.getColumnIndex("FL4")));
				weatherInfos.setFl5(cursor.getString(cursor.getColumnIndex("FL5")));
				
				weatherInfos.setWind1(cursor.getString(cursor.getColumnIndex("WIND1")));
				weatherInfos.setWind2(cursor.getString(cursor.getColumnIndex("WIND2")));
				weatherInfos.setWind3(cursor.getString(cursor.getColumnIndex("WIND3")));
				weatherInfos.setWind4(cursor.getString(cursor.getColumnIndex("WIND4")));
				weatherInfos.setWind5(cursor.getString(cursor.getColumnIndex("WIND5")));
				
				weatherInfos.setImg1(cursor.getString(cursor.getColumnIndex("IMG1")));
				weatherInfos.setImg3(cursor.getString(cursor.getColumnIndex("IMG3")));
				weatherInfos.setImg5(cursor.getString(cursor.getColumnIndex("IMG5")));
				weatherInfos.setImg7(cursor.getString(cursor.getColumnIndex("IMG7")));
				weatherInfos.setImg9(cursor.getString(cursor.getColumnIndex("IMG9")));
				
				weatherInfos.setTemp1(cursor.getString(cursor.getColumnIndex("TEMP1")));
				weatherInfos.setTemp2(cursor.getString(cursor.getColumnIndex("TEMP2")));
				weatherInfos.setTemp3(cursor.getString(cursor.getColumnIndex("TEMP3")));
				weatherInfos.setTemp4(cursor.getString(cursor.getColumnIndex("TEMP4")));
				weatherInfos.setTemp5(cursor.getString(cursor.getColumnIndex("TEMP5")));
				
				weatherInfos.setWeather1(cursor.getString(cursor.getColumnIndex("WEATHER1")));
				weatherInfos.setWeather2(cursor.getString(cursor.getColumnIndex("WEATHER2")));
				weatherInfos.setWeather3(cursor.getString(cursor.getColumnIndex("WEATHER3")));
				weatherInfos.setWeather4(cursor.getString(cursor.getColumnIndex("WEATHER4")));
				weatherInfos.setWeather5(cursor.getString(cursor.getColumnIndex("WEATHER5")));
				
				weatherInfos.setFx1(cursor.getString(cursor.getColumnIndex("FX1")));
				weatherInfos.setFchh(cursor.getString(cursor.getColumnIndex("FCHH")));
				
				weatherInfos.setIndex(cursor.getString(cursor.getColumnIndex("_INDEX")));
				weatherInfos.setIndex_d(cursor.getString(cursor.getColumnIndex("INDEX_D")));
				weatherInfos.setIndex_ag(cursor.getString(cursor.getColumnIndex("INDEX_AG")));
				weatherInfos.setIndex_cl(cursor.getString(cursor.getColumnIndex("INDEX_CL")));
				weatherInfos.setIndex_xc(cursor.getString(cursor.getColumnIndex("INDEX_XC")));
				weatherInfos.setIndex_tr(cursor.getString(cursor.getColumnIndex("INDEX_TR")));
				weatherInfos.setIndex_ls(cursor.getString(cursor.getColumnIndex("INDEX_LS")));
				weatherInfos.setIndex_uv(cursor.getString(cursor.getColumnIndex("INDEX_UV")));
				weatherInfos.setIndex_co(cursor.getString(cursor.getColumnIndex("INDEX_CO")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeCursor();
		}
		return weatherInfos;
	}
	
	private String addWeatherInfoSQL(WeatherInfos infos){
		StringBuffer sb_sql = new StringBuffer();
		sb_sql.append("INSERT INTO WEATHERINFOS VALUES(NULL,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?)").append("\n");
		return sb_sql.toString();
	}
	
	private String[] getWeatherAttributes(WeatherInfos infos){
		String[] insertValues = {
			infos.getCity(),infos.getCity_en(),infos.getDate_y(),infos.getDate(),infos.getWeek(),infos.getFchh(),
			infos.getCityid(),infos.getTemp1(),infos.getTemp2(),infos.getTemp3(),infos.getTemp4(),infos.getTemp5(),
			infos.getTemp6(),infos.getTempF1(),infos.getTempF2(),infos.getTempF3(),infos.getTempF4(),infos.getTempF5(),
			infos.getTempF6(),infos.getWeather1(),infos.getWeather2(),infos.getWeather3(),infos.getWeather4(),infos.getWeather5(),
			infos.getWeather6(),infos.getImg1(),infos.getImg2(),infos.getImg3(),infos.getImg4(),infos.getImg5(),
			infos.getImg6(),infos.getImg7(),infos.getImg8(),infos.getImg9(),infos.getImg10(),infos.getImg11(),
			infos.getImg12(),infos.getImg_single(),infos.getImg_title1(),infos.getImg_title2(),infos.getImg_title3(),infos.getImg_title4(),
			infos.getImg_title5(),infos.getImg_title6(),infos.getImg_title7(),infos.getImg_title8(),infos.getImg_title9(),infos.getImg_title10(),
			infos.getImg_title11(),infos.getImg_title12(),infos.getImg_title_single(),infos.getWind1(),infos.getWind2(),infos.getWind3(),
			infos.getWind4(),infos.getWind5(),infos.getWind6(),infos.getFx1(),infos.getFx2(),infos.getFl1(),
			infos.getFl2(),infos.getFl3(),infos.getFl4(),infos.getFl5(),infos.getFl6(),infos.getIndex(),
			infos.getIndex_d(),infos.getIndex48(),infos.getIndex48_d(),infos.getIndex_uv(),infos.getIndex48_uv(),infos.getIndex_xc(),
			infos.getIndex_tr(),infos.getIndex_co(),infos.getSt1(),infos.getSt2(),infos.getSt3(),infos.getSt4(),
			infos.getSt5(),infos.getSt6(),infos.getIndex_cl(),infos.getIndex_ls(),infos.getIndex_ag()
			};
		return insertValues;
	}
	
	private String addLifeIndexInfoSQL(){
		StringBuffer sb_sql = new StringBuffer();
		sb_sql.append("	INSERT INTO LIFEINDEXINFO VALUES(NULL,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?,?,?,?,?").append("\n");
		sb_sql.append(",?,?,?,?,?,?,?,?)").append("\n");
		return sb_sql.toString();
	}
	
	public boolean addLifeIndexInfo(LifeIndexInfo info,String cityid){
		try {
			db.beginTransaction();
			db.execSQL(this.addLifeIndexInfoSQL(), this.getLifeIndexInfoAttributes(info, cityid));
			db.setTransactionSuccessful();
			is_success = true;
		} catch (Exception e) {
			is_success = false;
			e.printStackTrace();
		} finally{
			db.endTransaction();
		}
		return is_success;
	}
	
	public boolean delInfo(String tablename,String cityid){
		try {
			db.beginTransaction();
			db.execSQL("DELETE FROM "+tablename+" WHERE CITYID=?",new String[]{cityid});
			db.setTransactionSuccessful();
			is_success = true;
		} catch (Exception e) {
			is_success = false;
			e.printStackTrace();
		} finally{
			db.endTransaction();
		}
		return is_success;
	}
	
	public LifeIndexInfo getLifeIndexInfo(String cityid){
		LifeIndexInfo indexInfo = null;
		try {
			indexInfo = new LifeIndexInfo();
			cursor = db.rawQuery("SELECT * FROM LIFEINDEXINFO L WHERE L.CITYID = ? ", new String[]{cityid});
			while(cursor.moveToNext()){
				indexInfo.setCt_hint(cursor.getString(cursor.getColumnIndex("CT_HINT")));
				indexInfo.setCt_des(cursor.getString(cursor.getColumnIndex("CT_DES")));
				
				indexInfo.setPp_hint(cursor.getString(cursor.getColumnIndex("PP_HINT")));
				indexInfo.setPp_des(cursor.getString(cursor.getColumnIndex("PP_DES")));
				
				indexInfo.setGm_hint(cursor.getString(cursor.getColumnIndex("GM_HINT")));
				indexInfo.setGm_des(cursor.getString(cursor.getColumnIndex("GM_DES")));
				
				indexInfo.setYd_hint(cursor.getString(cursor.getColumnIndex("YD_HINT")));
				indexInfo.setYd_des(cursor.getString(cursor.getColumnIndex("YD_DES")));
				
				indexInfo.setXc_hint(cursor.getString(cursor.getColumnIndex("XC_HINT")));
				indexInfo.setXc_des(cursor.getString(cursor.getColumnIndex("XC_DES")));
				
				indexInfo.setTr_hint(cursor.getString(cursor.getColumnIndex("TR_HINT")));
				indexInfo.setTr_des(cursor.getString(cursor.getColumnIndex("TR_DES")));
				
				indexInfo.setGl_hint(cursor.getString(cursor.getColumnIndex("GL_HINT")));
				indexInfo.setGl_des(cursor.getString(cursor.getColumnIndex("GL_DES")));
				
				indexInfo.setUv_hint(cursor.getString(cursor.getColumnIndex("UV_HINT")));
				indexInfo.setUv_des(cursor.getString(cursor.getColumnIndex("UV_DES")));
				
				indexInfo.setCo_hint(cursor.getString(cursor.getColumnIndex("CO_HINT")));
				indexInfo.setCo_des(cursor.getString(cursor.getColumnIndex("CO_DES")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeCursor();
		}
		return indexInfo;
	}
	
	private String[] getLifeIndexInfoAttributes(LifeIndexInfo info,String cityid){
		String[] insertvalues = {
				cityid,info.getDate(),
				info.getAc_name(),info.getAc_hint(),info.getAc_des(),info.getAc_des_s(),
				info.getAg_name(),info.getAg_hint(),info.getAg_des(),info.getAg_des_s(),
				info.getBe_name(),info.getBe_hint(),info.getBe_des(),info.getBe_des_s(),
				info.getCl_name(),info.getCl_hint(),info.getCl_des(),info.getCl_des_s(),
				info.getCo_name(),info.getCo_hint(),info.getCo_des(),info.getCo_des_s(),
				info.getCt_name(),info.getCt_hint(),info.getCt_des(),info.getCt_des_s(),
				info.getDy_name(),info.getDy_hint(),info.getDy_des(),info.getDy_des_s(),
				info.getFs_name(),info.getFs_hint(),info.getFs_des(),info.getFs_des_s(),
				info.getGj_name(),info.getGj_hint(),info.getGj_des(),info.getGj_des_s(),
				info.getGl_name(),info.getGl_hint(),info.getGl_des(),info.getGl_des_s(),
				info.getGm_name(),info.getGm_hint(),info.getGm_des(),info.getGm_des_s(),
				info.getGz_name(),info.getGz_hint(),info.getGz_des(),info.getGz_des_s(),
				info.getHc_name(),info.getHc_hint(),info.getHc_des(),info.getHc_des_s(),
				info.getJt_name(),info.getJt_hint(),info.getJt_des(),info.getJt_des_s(),
				info.getLk_name(),info.getLk_hint(),info.getLk_des(),info.getLk_des_s(),
				info.getLs_name(),info.getLs_hint(),info.getLs_des(),info.getLs_des_s(),
				info.getMf_name(),info.getMf_hint(),info.getMf_des(),info.getMf_des_s(),
				info.getNl_name(),info.getNl_hint(),info.getNl_des(),info.getNl_des_s(),					
				info.getPj_name(),info.getPj_hint(),info.getPj_des(),info.getPj_des_s(),
				info.getPk_name(),info.getPk_hint(),info.getPk_des(),info.getPk_des_s(),
				info.getPl_name(),info.getPl_hint(),info.getPl_des(),info.getPl_des_s(),
				info.getPp_name(),info.getPp_hint(),info.getPp_des(),info.getPp_des_s(),
				info.getPt_name(),info.getPt_hint(),info.getPt_des(),info.getPt_des_s(),
				info.getSg_name(),info.getSg_hint(),info.getSg_des(),info.getSg_des_s(),
				info.getTr_name(),info.getTr_hint(),info.getTr_des(),info.getTr_des_s(),
				info.getUv_name(),info.getUv_hint(),info.getUv_des(),info.getUv_des_s(),
				info.getXc_name(),info.getXc_hint(),info.getXc_des(),info.getXc_des_s(),
				info.getXq_name(),info.getXq_hint(),info.getXq_des(),info.getXq_des_s(),
				info.getYd_name(),info.getYd_hint(),info.getYd_des(),info.getYd_des_s(),
				info.getYh_name(),info.getYh_hint(),info.getYh_des(),info.getYh_des_s(),
				info.getYs_name(),info.getYs_hint(),info.getYs_des(),info.getYs_des_s(),
				info.getZs_name(),info.getZs_hint(),info.getZs_des(),info.getZs_des_s()		
		};
		return insertvalues;
	}
	
	public String[] findAllCityName(){
		String[] cities = null;
		Cursor cursor = null;
		String sql = "SELECT WC.CODE,WC.CITY,WC.PROVINCE FROM WEATHER_CODE WC";
		try {
			cursor = db.rawQuery(sql, null);
			int size = cursor.getCount();
			cities = new String[size];
			int index = 0;
			while (cursor.moveToNext()) {
				cities[index] = cursor.getString(cursor.getColumnIndex("CITY")) + "-" +cursor.getString(cursor.getColumnIndex("PROVINCE"));
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeCursor();
		}
		return cities;
	}
	
	/**
	 * @function 插入查询天气信息的城市
	 * @param code 城市代码
	 * @param city 城市名称
	 * @return Boolean 是否成功插入
	 */
	public boolean addWeatherCity(String code,String city){
		try {
			db.beginTransaction();  
			db.execSQL("INSERT INTO WEATHER_CITY VALUES(NULL,?,?)" , new String[]{code,city});
			db.setTransactionSuccessful();
			is_success = true;
		} catch (Exception e) {
			is_success = false;
			e.printStackTrace();
		} finally{
			db.endTransaction();
		}
		return is_success;
	} 
	
	/**
	 * @function 删除查看天气信息的城市
	 * @param code 城市代码
	 * @return Boolean 删除是否成功
	 */
	public boolean delWeatherCity(String city){
		try {
			db.beginTransaction();
			db.execSQL("DELETE FROM WEATHER_CITY WHERE CITYNAME = ? " ,new String[]{city});
			db.setTransactionSuccessful();
			is_success = true;
		} catch (Exception e) {
			is_success = false;
			e.printStackTrace();
		} finally{
			db.endTransaction();
		}
		return is_success;
	}
	
	/**
	 * @function 校验输入的城市是否存在并返回对应的城市代码
	 * @param city 城市名称
	 * @return obj[] 基类数组{0：是否存在，1:若存在返回对应的城市代码}
	 */
	public Object[] isExists(String city){
		Object[] obj = new Object[2];
		try {
			cursor = db.rawQuery(" SELECT CODE FROM WEATHER_CODE WHERE CITY = ?", new String[]{city});
			obj = new Object[2];
			if(cursor.moveToNext()){
				obj[0]=true;
				obj[1]=cursor.getString(cursor.getColumnIndex("CODE"));
			}else{
				obj[0]=false;
				obj[1]="";
			}
		} catch (Exception e) {
			 obj = null;
			is_success = false;
			e.printStackTrace();
		} finally {
			closeCursor();
		}
		return obj;
	}
	
	/**
	 * @function 增加天气信息城市之前校验是否已经存在
	 * @param city 城市名称
	 * @return boolean 是否存在
	 */
	public boolean addWeatherCityBeforCheck(String city){
		try {
			cursor = db.rawQuery("SELECT CITYCODE FROM WEATHER_CITY WHERE CITYNAME = ?", new String[]{city});
			if(cursor.moveToNext()){
				is_success = true;
			}else{
				is_success = false;
			}
		} catch (Exception e) {
			is_success = false;
			e.printStackTrace();
		} finally {
			closeCursor();
		}
		return is_success;
	}
	
	/**
	 * @function 获取所有已设置的天气城市
	 * @return Map<code,city_name>
	 */
	public Map<String, String> getAllCityCode(){
		String citycode = "";
		String cityname = "";
		HashMap<String, String> map = null;
		try {
			map = new HashMap<String, String>();
			cursor = db.rawQuery("SELECT CITYCODE,CITYNAME FROM WEATHER_CITY ORDER BY _ID DESC",null);
			while (cursor.moveToNext()) {
				citycode = cursor.getString(cursor.getColumnIndex("CITYCODE"));
				cityname = cursor.getString(cursor.getColumnIndex("CITYNAME"));
				map.put(citycode, cityname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeCursor();
		}
		return map;
	}
	
	/**
	 * @function 获取所有已设置的天气城市
	 * @return Map<Integer, List<String>> 城市信息
	 */
	public Map<Integer, ArrayList<String>> getAllWeatherCity(){
		String cityname = "";
		String province = "";
		String temp = "";
		ArrayList<String> citylist = null;
		ArrayList<String> provincelist = null;
		ArrayList<String> temp_weather = null;
		HashMap<Integer, ArrayList<String>> map = null;
		try {
			citylist = new ArrayList<String>();
			provincelist = new ArrayList<String>();
			temp_weather = new ArrayList<String>();
			cursor = db.rawQuery("SELECT DISTINCT CITYNAME, PROVINCE, IFNULL(TEMP1,'') AS TEMP1, IFNULL(WEATHER1,'') AS WEATHER1 FROM WEATHER_CITY WC ,WEATHER_CODE WO left join WEATHERINFOS WS on WC.CITYCODE = WS.CITYID WHERE WO.CODE = WC.CITYCODE  ORDER BY WO._ID ASC", null);
			int index = 0;
			map = new HashMap<Integer, ArrayList<String>>();
			while(cursor.moveToNext()){
				cityname = cursor.getString(cursor.getColumnIndex("CITYNAME"));
				citylist.add(index, cityname);
				province = cursor.getString(cursor.getColumnIndex("PROVINCE"));
				provincelist.add(index, province);
				
				temp = cursor.getString(cursor.getColumnIndex("WEATHER1"));
				temp += "  " + cursor.getString(cursor.getColumnIndex("TEMP1"));
				temp_weather.add(index,temp);
				index++;
			}
			map.put(0, citylist);
			map.put(1, provincelist);
			map.put(2, temp_weather);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeCursor();
		}
		return map;
	}
	
	/**
	 * @function 根据城市代码获取最后一次跟新天气信息的时间点
	 * @param code 城市代码
	 * @return String 最后一次更新的时间点
	 */
	public String getFCHH(String code){
		String fchh = "";
		try {
			cursor = db.rawQuery("SELECT W.FCHH FROM WEATHERINFOS W WHERE W.CITYID = ? ORDER BY W._id DESC", new String[]{code});
			if(cursor.moveToNext()){
				fchh = cursor.getString(cursor.getColumnIndex("FCHH"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			this.closeCursor();
		}
		return fchh;
	}
	
	/**
	 * @function 关闭数据库
	 */
	public static void close(){
		if(db!=null){
			db.close();
		}
	}
	
	/**
	 * @function 关闭游标
	 */
	private void closeCursor(){
		if(cursor!=null){
			cursor.close();
		}
	}
}
