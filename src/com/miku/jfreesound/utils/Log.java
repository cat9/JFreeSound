package com.miku.jfreesound.utils;

public class Log {
	public static void i(String tag,String msg){
		log(tag,msg);
	}
	
	public static void e(String tag,String msg){
		log(tag,msg);
	}
	
	public static void w(String tag,String msg){
		log(tag,msg);
	}
	
	public static void v(String tag,String msg){
		log(tag,msg);
	}
	
	private static void log(String tag,String msg){
		System.out.println(msg);
	}
}
