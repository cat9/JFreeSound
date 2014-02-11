package com.miku.jfreesound.bean.base;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.miku.jfreesound.utils.TextUtils;

public abstract class AbstractHashMapData extends HashMap<String, String>
		implements IBaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4732201543440312861L;

	public AbstractHashMapData() {
	}

	public AbstractHashMapData(JSONObject json) {
		parse(json);
	}

	public abstract String[] getDataAll();

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

	public void setValueByKey(String key, String value) {
		put(key, value);
	}

	public String getValueByKey(String key) {
		return get(key);
	}

	@Override
	public String toString() {
		return buildJson().toString();
	}

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

}
