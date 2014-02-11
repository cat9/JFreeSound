package com.miku.jfreesound.bean.base;

import org.json.JSONObject;

public interface IBaseData {
	public String[] getDataAll();
	
	public void parse(JSONObject json);
	
	public abstract void setValueByKey(String key,String value);
	
	public abstract String getValueByKey(String key);
	
	public JSONObject buildJson();
}
