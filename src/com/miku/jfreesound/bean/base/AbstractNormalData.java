package com.miku.jfreesound.bean.base;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.miku.jfreesound.utils.TextUtils;

/**
 * 
 * @author xr.lee
 *
 */
public abstract class AbstractNormalData implements IBaseData{
	
	public AbstractNormalData(){}
	
	public AbstractNormalData(JSONObject json){
		parse(json);
	}
	
	public abstract String[] getDataAll();

	@Override
	public void parse(JSONObject json) {
		if (json != null) {
			for (String columnName : getDataAll()) {
				String value = null;
				try {
					value = json.get(columnName).toString();
					if ("null".equals(value)) {
						value = null;
					}
				} catch (Exception e) {
					value = null;
				}
				setValueByKey(columnName, value);
			}
		}
	}

	public abstract void setValueByKey(String key, String value);

	public abstract String getValueByKey(String key);

	@Override
	public JSONObject buildJson() {
		JSONObject jsonObj = new JSONObject();
		for (String columnName : getDataAll()) {
			String value = getValueByKey(columnName);
			if (!TextUtils.isEmpty(value)) {
				try {
					if (value.charAt(0) == '['
							&& value.charAt(value.length() - 1) == ']') {
						JSONArray jarr = new JSONArray(value);
						jsonObj.put(columnName, jarr);
					} else if (value.charAt(0) == '{'
							&& value.charAt(value.length() - 1) == '}') {
						jsonObj.put(columnName, new JSONObject(value));
					} else {
						jsonObj.put(columnName, value);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonObj;
	}
	
	@Override
	public String toString() {
		return buildJson().toString();
	}
	
	protected String getNullIfNULL(String value){
		if(TextUtils.isEmpty(value) || "null".equals(value)){
			return null;
		}
		return value;
	}
	
	
	
	
}
