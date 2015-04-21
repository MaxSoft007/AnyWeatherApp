package org.maxsoft.util;

import java.io.InputStream;

import org.maxsoft.weather.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
public class WeatherIcons {
	public static int getSmallIcon(String index){
		int icon_index = -1;
		switch (Integer.valueOf(index)) {
		case 0:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.d0;
			}else{
				icon_index = R.drawable.n0;
			}
			break;
		case 1:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.d1;
			}else{
				icon_index = R.drawable.n1;
			}
			break;
		case 2:
			icon_index = R.drawable.s2;
			break;
		case 3:
			icon_index = R.drawable.s3;
			break;
		case 4:
			icon_index = R.drawable.s4;
			break;
		case 5:
			icon_index = R.drawable.s5;
			break;
		case 6:
			icon_index = R.drawable.s6;
			break;
		case 7:
			icon_index = R.drawable.s7;
			break;
		case 8:
			icon_index = R.drawable.s8;
			break;
		case 9:
			icon_index = R.drawable.s9;
			break;
		case 10:
			icon_index = R.drawable.s10;
			break;
		case 11:
			icon_index = R.drawable.s11;
			break;
		case 12:
			icon_index = R.drawable.s12;
			break;
		case 13:
			icon_index = R.drawable.s13;
			break;
		case 14:
			icon_index = R.drawable.s14;
			break;
		case 15:
			icon_index = R.drawable.s15;
			break;
		case 16:
			icon_index = R.drawable.s16;
			break;
		case 17:
			icon_index = R.drawable.s17;
			break;
		case 18:
			icon_index = R.drawable.s18;
			break;
		case 19:
			icon_index = R.drawable.s19;
			break;
		case 20:
			icon_index = R.drawable.s20;
			break;
		case 21:
			icon_index = R.drawable.s8;
			break;
		case 22:
			icon_index = R.drawable.s9;
			break;
		case 23:
			icon_index = R.drawable.s10;
			break;
		case 24:
			icon_index = R.drawable.s11;
			break;
		case 25:
			icon_index = R.drawable.s12;
			break;
		case 26:
			icon_index = R.drawable.s15;
			break;
		case 27:
			icon_index = R.drawable.s16;
			break;
		case 28:
			icon_index = R.drawable.s17;
			break;
		case 29:
			icon_index = R.drawable.s29;
			break;
		case 30:
			icon_index = R.drawable.s30;
			break;
		case 31:
			icon_index = R.drawable.s31;
			break;
		case 53:
			icon_index = R.drawable.s53;
			break;
		default:
			icon_index = R.drawable.d0;
			break;
		}
		return icon_index;
	}
	
	public static int getLargeIcon(String index){
		int icon_index = -1;
		switch (Integer.valueOf(index)) {
		case 0:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.ld0;
			}else{
				icon_index = R.drawable.ln0;
			}
			break;
		case 1:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.ld1;
			}else{
				icon_index = R.drawable.ln1;
			}
			break;
		case 2:
			icon_index = R.drawable.l2;
			break;
		case 3:
			icon_index = R.drawable.l3;
			break;
		case 4:
			icon_index = R.drawable.l4;
			break;
		case 5:
			icon_index = R.drawable.l5;
			break;
		case 6:
			icon_index = R.drawable.l6;
			break;
		case 7:
			icon_index = R.drawable.l7;
			break;
		case 8:
			icon_index = R.drawable.l8;
			break;
		case 9:
			icon_index = R.drawable.l9;
			break;
		case 10:
			icon_index = R.drawable.l10;
			break;
		case 11:
			icon_index = R.drawable.l11;
			break;
		case 12:
			icon_index = R.drawable.l12;
			break;
		case 13:
			icon_index = R.drawable.l13;
			break;
		case 14:
			icon_index = R.drawable.l14;
			break;
		case 15:
			icon_index = R.drawable.l15;
			break;
		case 16:
			icon_index = R.drawable.l16;
			break;
		case 17:
			icon_index = R.drawable.l17;
			break;
		case 18:
			icon_index = R.drawable.l18;
			break;
		case 19:
			icon_index = R.drawable.l19;
			break;
		case 20:
			icon_index = R.drawable.l20;
			break;
		case 21:
			icon_index = R.drawable.l8;
			break;
		case 22:
			icon_index = R.drawable.l9;
			break;
		case 23:
			icon_index = R.drawable.l10;
			break;
		case 24:
			icon_index = R.drawable.l11;
			break;
		case 25:
			icon_index = R.drawable.l12;
			break;
		case 26:
			icon_index = R.drawable.l15;
			break;
		case 27:
			icon_index = R.drawable.l16;
			break;
		case 28:
			icon_index = R.drawable.l17;
			break;
		case 29:
			icon_index = R.drawable.l29;
			break;
		case 30:
			icon_index = R.drawable.l30;
			break;
		case 31:
			icon_index = R.drawable.l31;
			break;
		case 53:
			icon_index = R.drawable.l53;
			break;
		default :
			icon_index = R.drawable.ld0;
			break;
		}
		return icon_index;
	}
	
	public static int getBG(String index){
		int icon_index = -1;
		switch (Integer.valueOf(index)) {
		case 0: //ÇçÌì
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				if(DateUtils.getMonth() >= 11 || DateUtils.getMonth() <=2){
					icon_index = R.drawable.winter_day;
				}else{
					icon_index = R.drawable.fine_day;
				}
			}else{
				if(DateUtils.getMonth() >= 11 || DateUtils.getMonth() <=2){
					icon_index = R.drawable.winter_night;
				}else{
					icon_index = R.drawable.fine_day;
				}
			}
			break;
		case 1: //¶àÔÆ
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.cloudy_day;
			}else{
				icon_index = R.drawable.cloudy_night;
			}
			break;
		case 2: //Òõ
			icon_index = R.drawable.overcast;
			break;
		case 3: //ÕóÓê
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.slight_rain_day;
			}else{
				icon_index = R.drawable.slight_rain_night;
			}
			break;
		case 4: //À×ÕóÓê
			icon_index = R.drawable.thunder_storm;
			break;
		case 5: //À×ÕóÓê °éÓÐ±ù±¢
			icon_index = R.drawable.thunder_storm;
			break;
		case 6: //Óê¼ÐÑ©
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.shower_rain_day;
			}else{
				icon_index = R.drawable.shower_rain_night;
			}
			break;
		case 7://Ð¡Óê
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.slight_rain_day;
			}else{
				icon_index = R.drawable.slight_rain_night;
			}
			break;
		case 8: //ÖÐÓê
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.moderate_rain_day;
			}else{
				icon_index = R.drawable.moderate_rain_night;
			}
			break;
		case 9: //´óÓê
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.heavy_rain_day;
			}else{
				icon_index = R.drawable.heavy_rain_night;
			}
			break;
		case 10: //±©Óê
			icon_index = R.drawable.thunder_storm;
			break;
		case 11: //´ó±©Óê
			icon_index = R.drawable.thunder_storm;
			break;
		case 12: //ÌØ´ó±©Óê
			icon_index = R.drawable.thunder_storm;
			break;
		case 13: //ÕóÑ©
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.snow_day;
			}else{
				icon_index = R.drawable.snow_night;
			}
			break;
		case 14: //Ð¡Ñ©
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.snow_day;
			}else{
				icon_index = R.drawable.snow_night;
			}
			break;
		case 15: //ÖÐÑ©
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.snow_day;
			}else{
				icon_index = R.drawable.snow_night;
			}
			break;
		case 16: //´óÑ©
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.snow_day;
			}else{
				icon_index = R.drawable.snow_night;
			}
			break;
		case 17: //±©Ñ©
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.snow_day;
			}else{
				icon_index = R.drawable.snow_night;
			}
			break;
		case 18:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.fog_day;
			}else{
				icon_index = R.drawable.fog_night;
			}
			break;
		case 19:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.shower_rain_day;
			}else{
				icon_index = R.drawable.shower_rain_night;
			}
			break;
		case 20:
			icon_index = R.drawable.sand_storm;
			break;
		case 21:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.heavy_rain_day;
			}else{
				icon_index = R.drawable.heavy_rain_night;
			}
			break;
		case 22:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.heavy_rain_day;
			}else{
				icon_index = R.drawable.heavy_rain_night;
			}
			break;
		case 23:
			icon_index = R.drawable.thunder_storm;
			break;
		case 24:
			icon_index = R.drawable.thunder_storm;
			break;
		case 25:
			icon_index = R.drawable.thunder_storm;
			break;
		case 26:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.snow_day;
			}else{
				icon_index = R.drawable.snow_night;
			}
			break;
		case 27:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.snow_day;
			}else{
				icon_index = R.drawable.snow_night;
			}
			break;
		case 28:
			if(DateUtils.getHour() >= 6 && DateUtils.getHour() < 18){
				icon_index = R.drawable.snow_day;
			}else{
				icon_index = R.drawable.snow_night;
			}
			break;
		case 29:
			icon_index = R.drawable.fog_and_haze;
			break;
		case 30:
			icon_index = R.drawable.fog_and_haze;
			break;
		case 31:
			icon_index = R.drawable.fog_and_haze;
			break;
		case 53:
			icon_index = R.drawable.fog_and_haze;
			break;
		default :
			icon_index = R.drawable.na;
			break;
		}
		return icon_index;
	}
	
	public static Bitmap readBitMap(Context context, int resId){
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		//»ñÈ¡×ÊÔ´Í¼Æ¬
		InputStream is = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is,null,opt);
	}
}
