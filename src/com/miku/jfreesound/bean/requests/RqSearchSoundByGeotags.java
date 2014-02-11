package com.miku.jfreesound.bean.requests;

import java.util.HashMap;
import java.util.Map;

import com.miku.jfreesound.bean.base.IBaseRequest;
import com.miku.jfreesound.utils.TextUtils;

public class RqSearchSoundByGeotags implements IBaseRequest {
private static final String URL="/sounds/geotag";//normal search
	
	/**
	 * min_lat Minimum latitude [-90 to 90]
	 */
	public String min_lat;
	
	/**
	 * max_lat Maximum latitude [-90 to 90]
	 */
	public String max_lat;
	
	/**
	 * min_lon Minimum longitude [-180 to 180]
	 */
	public String min_lon;
	
	/**
	 * max_lon Maximum longitude [-180 to 180]
	 */
	public String max_lon;
	
	/**
	 * p The page of the search result to get
	 */
	public int pageNum;
	
	/**
	 * fields Fields
	 */
	public String[] fields;
	
	/**
	 * sounds_per_page Number of sounds to return in each page (be aware that large numbers may produce sloooow queries, maximum allowed is 100 sounds per page)
	 */
	public int sounds_per_page;


	@Override
	public String buildRequest() {
		
		Map<String,String> params=new HashMap<String,String>();
		
		
		StringBuilder queryBuilder=new StringBuilder();
		queryBuilder.append(URL).append('?');
		
		//min_lat
		if(!TextUtils.isEmpty(min_lat)){
			params.put("min_lat", min_lat);
		}
		
		//max_lat
		if(!TextUtils.isEmpty(max_lat)){
		 params.put("max_lat", max_lat);
		}
		
		//min_lon
		if(!TextUtils.isEmpty(min_lon)){
			params.put("min_lon", min_lon);
		}
		//max_lon
		if(!TextUtils.isEmpty(max_lon)){
			params.put("max_lon", max_lon);
		}
		
		//p
		params.put("p", String.valueOf(pageNum<1?1:pageNum));

		
		//fields
		if(fields==null){
			//use default
			fields=new String[]{};
		}
		String str_fields=TextUtils.array2String(fields,",");
		if(!TextUtils.isEmpty(str_fields)){
			params.put("fields", str_fields);
		}
		
		//sounds_per_page
		if(sounds_per_page<=0){
			sounds_per_page=10;
		}
		if(sounds_per_page>100){
			sounds_per_page=100;
		}
		params.put("sounds_per_page", String.valueOf(sounds_per_page));
		
		return queryBuilder.append(TextUtils.map2String(params, "&")).toString();
	}

}
