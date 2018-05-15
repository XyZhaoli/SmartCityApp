package com.xy.smartcity.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {
	private static SharedPreferences sp;
	
	/**
	 * @param context 上下文环�?
	 * @param key 对应的key�?
	 * @param value  对应的Boolean�?
	 */
	public static void setSpBoolean(Context context, String key, boolean value) {
		if(sp == null) {
			sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
		}
		sp.edit().putBoolean(key, value).commit();
	}
	
	/**
	 * @param context 上下文环�?
	 * @param key 对应的key�?
	 * @param defValue 如果没有这个值，返回�?个默认�??
	 * @return 返回�?对应的�??
	 */
	public static boolean getSpBoolean(Context context, String key, boolean defValue) {
		if(sp == null) { 
			sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
		} 
		return sp.getBoolean(key, defValue);
	}
	
	
	/**
	 * @param context 上下文环�?
	 * @param key 对应的key�?
	 * @param value  对应的String�?
	 */
	public static void setSpString(Context context, String key, String value) {
		if(sp == null) {
			sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
		}
		sp.edit().putString(key, value).commit();
	}
	
	/**
	 * @param context 上下文环�?
	 * @param key 对应的key�?
	 * @param defValue 如果没有这个值，返回�?个默认�??
	 * @return 返回�?对应的�??
	 */
	public static String getSpString(Context context, String key, String defValue) {
		if(sp == null) { 
			sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
		} 
		return sp.getString(key, defValue);
	}
	
	public static void remove(Context context, String key, String defValue) {
		if(sp == null) { 
			sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
		}
		sp.edit().remove(key).commit();
	}
	
	
	
	public static int getInteger(Context context, String key, int defValue) {
		if(sp == null) {
			sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
		}
		return sp.getInt(key, defValue);
	}

	public static void setInteger(Context context, String key, int value) {
		if(sp == null) {
			sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
		}
		sp.edit().putInt(key, value).commit();
	}
}
