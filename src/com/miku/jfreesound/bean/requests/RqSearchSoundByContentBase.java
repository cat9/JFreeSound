package com.miku.jfreesound.bean.requests;

import java.util.HashMap;
import java.util.Map;

import com.miku.jfreesound.bean.base.IBaseRequest;
import com.miku.jfreesound.utils.TextUtils;

public class RqSearchSoundByContentBase implements IBaseRequest {

private static final String URL="/sounds/content_search";//normal search
	
	/**
	 * t The Target
	 */
	public String target;
	
	/**
	 * f The filter
	 */
	public String filter;
	
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
	
	/**
	 * max_results The maximum number of results to get in each query (default = 15)
	 */
	public int max_results;

	@Override
	public String buildRequest() {
		
		Map<String,String> params=new HashMap<String,String>();
		
		
		StringBuilder queryBuilder=new StringBuilder();
		queryBuilder.append(URL).append('?');
		
		//t
		if(!TextUtils.isEmpty(target)){
			params.put("t", target);
		}
		
		//p
		params.put("p", String.valueOf(pageNum<1?1:pageNum));
		
		//f
		if(!TextUtils.isEmpty(filter)){
			params.put("f", filter);
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
		if(max_results<=0){
			max_results=15;
		}
		params.put("max_results", String.valueOf(max_results));
		
		return queryBuilder.append(TextUtils.map2String(params, "&")).toString();
	}

}
