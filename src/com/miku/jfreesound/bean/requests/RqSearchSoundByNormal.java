package com.miku.jfreesound.bean.requests;

import java.util.HashMap;
import java.util.Map;

import com.miku.jfreesound.bean.base.IBaseRequest;
import com.miku.jfreesound.utils.TextUtils;

public class RqSearchSoundByNormal implements IBaseRequest {
	
	private static final String URL="/sounds/search";//normal search
	
	/**
	 * q The query
	 */
	public String queryWord;
	
	/**
	 * p The page of the search result to get
	 */
	public int pageNum;
	
	/**
	 * f The filter
	 */
	public String filter;
	
	/**
	 * s How to sort the results
	 */
	public String sort;
	
	/**
	 * fields Fields
	 */
	public String[] fields;
	
	/**
	 * sounds_per_page Number of sounds to return in each page (be aware that large numbers may produce sloooow queries, maximum allowed is 100 sounds per page)
	 */
	public int sounds_per_page;
	
	/**
	 * g Group results in packs. g=0 (default) don¡¯t group, g=1 group. See below.
	 */
	public boolean isGroup;

	@Override
	public String buildRequest() {
		
		Map<String,String> params=new HashMap<String,String>();
		
		
		StringBuilder queryBuilder=new StringBuilder();
		queryBuilder.append(URL).append('?');
		
		//q
		if(!TextUtils.isEmpty(queryWord)){
			params.put("q", queryWord);
		}
		
		//p
		params.put("p", String.valueOf(pageNum<1?1:pageNum));
		
		//f
		if(!TextUtils.isEmpty(filter)){
			params.put("f", filter);
		}
		
		//s
		if(!TextUtils.isEmpty(sort)){
			params.put("s", sort);
		}
		
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
		
		//group
		if(isGroup){
			params.put("g", String.valueOf(1));
		}
		
		return queryBuilder.append(TextUtils.map2String(params, "&")).toString();
	}

}
