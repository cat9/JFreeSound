package com.miku.jfreesound.utils;

import java.util.Map;

public class TextUtils {
	private TextUtils(){/* cannot be instantiated */}
	
	/**
     * Returns true if the string is null or 0-length.
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
    
    /**
     * Return the String like  "str1,str2,str3" in the String Array,","is the spliter
     * @param strArray
     * @param spliter String like ",","&" or others
     * @return the String like  "str1str2,str3"
     */
    public static String array2String(String[] strArray,String spliter){
    	StringBuilder sb=new StringBuilder();
    	for(String str:strArray){
    		sb.append(str);
    		sb.append(spliter);
    	}
    	if(sb.length()>spliter.length()){
    		sb.setLength(sb.length()-spliter.length());
    	}
    	return sb.toString();
    }
    
    /**
     * Return the String like  "str1,str2,str3" in the String Map,","is the spliter
     * @param strMap
     * @param spliter String like ",","&" or others
     * @return the String like  "str1str2,str3"
     */
    public static String map2String(Map<String,String> strMap,String spliter){
    	StringBuilder sb=new StringBuilder();
    	for(String key:strMap.keySet()){
    		sb.append(key);
    		sb.append('=');
    		sb.append(strMap.get(key));
    		sb.append(spliter);
    	}
    	if(sb.length()>spliter.length()){
    		sb.setLength(sb.length()-spliter.length());
    	}
    	return sb.toString();
    }
}
