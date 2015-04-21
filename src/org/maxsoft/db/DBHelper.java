package org.maxsoft.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.maxsoft.weather.R;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "weatherinfo.db"; //数据库名称
	private static final int DATABASE_VERSION = 1; //数据库版本
	private StringBuffer create_table = null;
	public static final String WEATHERINFOS = "WEATHERINFOS";
	public static final String LIFEINDEXINFO = "LIFEINDEXINFO";
	public static final String WEATHER_CODE = "WEATHER_CODE";
	public static final String WEATHER_CITY = "WEATHER_CITY";
	public static final String DATABASES_DIR="/data/data/org.maxsoft.weather/databases";
	//^(?!.*(nativeGetEnabledTags)).*$
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		copyDatabaseFile(context,true);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(initCreateWeatherInfoTableSQL());
		db.execSQL(initCreateLifeIndexTableSQL());
		db.execSQL(initCreateWeatherCitySQL());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//TODO
	}

	/**
	 * @function 初始化创建天气信息表SQL
	 * @return String SQL
	 */
	private String initCreateWeatherInfoTableSQL(){
		create_table = new StringBuffer();
		create_table.append("CREATE TABLE IF NOT EXISTS WEATHERINFOS").append("\n");
		create_table.append("(_id INTEGER PRIMARY KEY AUTOINCREMENT,").append("\n");
		create_table.append(" CITY VARCHAR,CITY_EN VARCHAR,DATE_Y VARCHAR,DATE_C VARCHAR,WEEK VARCHAR,").append("\n");
		create_table.append(" FCHH VARCHAR,CITYID VARCHAR,TEMP1 VARCHAR,TEMP2 VARCHAR,TEMP3 VARCHAR,").append("\n");
		create_table.append(" TEMP4 VARCHAR,TEMP5 VARCHAR, TEMP6 VARCHAR,TEMPF1 VARCHAR,TEMPF2 VARCHAR,").append("\n");
		create_table.append(" TEMPF3 VARCHAR,TEMPF4 VARCHAR,TEMPF5 VARCHAR, TEMPF6 VARCHAR,WEATHER1 VARCHAR,").append("\n");
		create_table.append(" WEATHER2 VARCHAR,WEATHER3 VARCHAR,WEATHER4 VARCHAR, WEATHER5 VARCHAR,").append("\n");
		create_table.append(" WEATHER6 VARCHAR,IMG1 VARCHAR,IMG2 VARCHAR,IMG3 VARCHAR, IMG4 VARCHAR,").append("\n");
		create_table.append(" IMG5 VARCHAR,IMG6 VARCHAR,IMG7 VARCHAR,IMG8 VARCHAR,IMG9 VARCHAR,").append("\n");
		create_table.append(" IMG10 VARCHAR,IMG11 VARCHAR,IMG12 VARCHAR,IMG_SINGLE VARCHAR, IMG_TITLE1 VARCHAR,").append("\n");
		create_table.append(" IMG_TITLE2 VARCHAR,IMG_TITLE3 VARCHAR,IMG_TITLE4 VARCHAR, IMG_TITLE5 VARCHAR,IMG_TITLE6 VARCHAR,").append("\n");
		create_table.append(" IMG_TITLE7 VARCHAR,IMG_TITLE8 VARCHAR, IMG_TITLE9 VARCHAR,IMG_TITLE10 VARCHAR,IMG_TITLE11 VARCHAR,IMG_TITLE12 VARCHAR,").append("\n");
		create_table.append(" IMG_TITLE_SINGLE VARCHAR,WIND1 VARCHAR,WIND2 VARCHAR,WIND3 VARCHAR,WIND4 VARCHAR,").append("\n");
		create_table.append(" WIND5 VARCHAR,WIND6 VARCHAR,FX1 VARCHAR,FX2 VARCHAR,FL1 VARCHAR,FL2 VARCHAR,").append("\n");
		create_table.append(" FL3 VARCHAR,FL4 VARCHAR,FL5 VARCHAR,FL6 VARCHAR,_INDEX VARCHAR,INDEX_D VARCHAR,").append("\n");
		create_table.append(" INDEX48 VARCHAR,INDEX48_D VARCHAR,INDEX_UV VARCHAR,INDEX48_UV VARCHAR,").append("\n");
		create_table.append(" INDEX_XC VARCHAR,INDEX_TR VARCHAR,INDEX_CO VARCHAR,ST1 VARCHAR,").append("\n");
		create_table.append(" ST2 VARCHAR,ST3 VARCHAR,ST4 VARCHAR,ST5 VARCHAR,ST6 VARCHAR,").append("\n");
		create_table.append(" INDEX_CL VARCHAR,INDEX_LS VARCHAR,INDEX_AG VARCHAR)").append("\n");
		return create_table.toString();
	}
	
	/**
	 * @function 初始化创建生活指数信息表SQL
	 * @return String SQL
	 */
	private String initCreateLifeIndexTableSQL(){
		create_table = new StringBuffer();
		create_table.append(" CREATE TABLE IF NOT EXISTS LIFEINDEXINFO ").append("\n");
		create_table.append("(_ID INTEGER PRIMARY KEY AUTOINCREMENT,CITYID VARCHAR, ").append("\n");
		create_table.append(" DATE_N VARCHAR,AC_NAME VARCAHR,AC_HINT VARCHAR,AC_DES VARCAHR,AC_DES_S VARCHAR,").append("\n");
		create_table.append(" AG_NAME VARCAHR,AG_HINT VARCHAR,AG_DES VARCAHR,AG_DES_S VARCHAR,").append("\n");
		create_table.append(" BE_NAME VARCAHR,BE_HINT VARCHAR,BE_DES VARCAHR,BE_DES_S VARCHAR,").append("\n");
		create_table.append(" CL_NAME VARCAHR,CL_HINT VARCHAR,CL_DES VARCAHR,CL_DES_S VARCHAR,").append("\n");
		create_table.append(" CO_NAME VARCAHR,CO_HINT VARCHAR,CO_DES VARCAHR,CO_DES_S VARCHAR,").append("\n");
		create_table.append(" CT_NAME VARCAHR,CT_HINT VARCHAR,CT_DES VARCAHR,CT_DES_S VARCHAR,").append("\n");
		create_table.append(" DY_NAME VARCAHR,DY_HINT VARCHAR,DY_DES VARCAHR,DY_DES_S VARCHAR,").append("\n");
		create_table.append(" FS_NAME VARCAHR,FS_HINT VARCHAR,FS_DES VARCAHR,FS_DES_S VARCHAR,").append("\n");
		create_table.append(" GJ_NAME VARCAHR,GJ_HINT VARCHAR,GJ_DES VARCAHR,GJ_DES_S VARCHAR,").append("\n");
		create_table.append(" GL_NAME VARCAHR,GL_HINT VARCHAR,GL_DES VARCAHR,GL_DES_S VARCHAR,").append("\n");
		create_table.append(" GM_NAME VARCAHR,GM_HINT VARCHAR,GM_DES VARCAHR,GM_DES_S VARCHAR,").append("\n");
		create_table.append(" GZ_NAME VARCAHR,GZ_HINT VARCHAR,GZ_DES VARCAHR,GZ_DES_S VARCHAR,").append("\n");
		create_table.append(" HC_NAME VARCAHR,HC_HINT VARCHAR,HC_DES VARCAHR,HC_DES_S VARCHAR,").append("\n");
		create_table.append(" JT_NAME VARCAHR,JT_HINT VARCHAR,JT_DES VARCAHR,JT_DES_S VARCHAR,").append("\n");
		create_table.append(" LK_NAME VARCAHR,LK_HINT VARCHAR,LK_DES VARCAHR,LK_DES_S VARCHAR,").append("\n");
		create_table.append(" LS_NAME VARCAHR,LS_HINT VARCHAR,LS_DES VARCAHR,LS_DES_S VARCHAR,").append("\n");
		create_table.append(" MF_NAME VARCAHR,MF_HINT VARCHAR,MF_DES VARCAHR,MF_DES_S VARCHAR,").append("\n");
		create_table.append(" NL_NAME VARCAHR,NL_HINT VARCHAR,NL_DES VARCAHR,NL_DES_S VARCHAR,").append("\n");
		create_table.append(" PJ_NAME VARCAHR,PJ_HINT VARCHAR,PJ_DES VARCAHR,PJ_DES_S VARCHAR,").append("\n");
		create_table.append(" PK_NAME VARCAHR,PK_HINT VARCHAR,PK_DES VARCAHR,PK_DES_S VARCHAR,").append("\n");
		create_table.append(" PL_NAME VARCAHR,PL_HINT VARCHAR,PL_DES VARCAHR,PL_DES_S VARCHAR,").append("\n");
		create_table.append(" PP_NAME VARCAHR,PP_HINT VARCHAR,PP_DES VARCAHR,PP_DES_S VARCHAR,").append("\n");
		create_table.append(" PT_NAME VARCAHR,PT_HINT VARCHAR,PT_DES VARCAHR,PT_DES_S VARCHAR,").append("\n");
		create_table.append(" SG_NAME VARCAHR,SG_HINT VARCHAR,SG_DES VARCAHR,SG_DES_S VARCHAR,").append("\n");
		create_table.append(" TR_NAME VARCAHR,TR_HINT VARCHAR,TR_DES VARCAHR,TR_DES_S VARCHAR,").append("\n");
		create_table.append(" UV_NAME VARCAHR,UV_HINT VARCHAR,UV_DES VARCAHR,UV_DES_S VARCHAR,").append("\n");
		create_table.append(" XC_NAME VARCAHR,XC_HINT VARCHAR,XC_DES VARCAHR,XC_DES_S VARCHAR,").append("\n");
		create_table.append(" XQ_NAME VARCAHR,XQ_HINT VARCHAR,XQ_DES VARCAHR,XQ_DES_S VARCHAR,").append("\n");
		create_table.append(" YD_NAME VARCAHR,YD_HINT VARCHAR,YD_DES VARCAHR,YD_DES_S VARCHAR,").append("\n");
		create_table.append(" YH_NAME VARCAHR,YH_HINT VARCHAR,YH_DES VARCAHR,YH_DES_S VARCHAR,").append("\n");
		create_table.append(" YS_NAME VARCAHR,YS_HINT VARCHAR,YS_DES VARCAHR,YS_DES_S VARCHAR,").append("\n");
		create_table.append(" ZS_NAME VARCAHR,ZS_HINT VARCHAR,ZS_DES VARCAHR,ZS_DES_S VARCHAR)").append("\n");
		return create_table.toString();
	} 
	
	/**
	 * @function 初始化创建设置查看天气信息的城市SQL
	 * @return SQL
	 */
	public String initCreateWeatherCitySQL(){
		create_table = new StringBuffer();
		create_table.append(" CREATE TABLE IF NOT EXISTS WEATHER_CITY ").append("\n");
		create_table.append(" (_ID INTEGER PRIMARY KEY AUTOINCREMENT,CITYCODE VARCHAR,CITYNAME VARCHAR )").append("\n");
		return create_table.toString();
	}
	
	public void copyDatabaseFile(Context context, boolean isfored) {  
        Log.v("COPY", "--------------------------------copyDatabaseFile-");  
        File dir = new File(DATABASES_DIR);  
        if (!dir.exists() || isfored) {  
            try {  
                dir.mkdir();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        File dest = new File(dir, DATABASE_NAME);  
        if(dest.exists() && !isfored){  
            return ;  
        }  
          
        try {  
            if(dest.exists()){  
               return ; 
            }  
            dest.createNewFile();     
            InputStream in = context.getResources().openRawResource(R.raw.weatherinfo);  
            int size = in.available();  
            byte buf[] = new byte[size];  
            Log.v("COPY", "--------------------------------正在copy数据库---------");  
            in.read(buf);  
            in.close();  
            FileOutputStream out = new FileOutputStream(dest);  
            out.write(buf);  
            out.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
    }  
}
