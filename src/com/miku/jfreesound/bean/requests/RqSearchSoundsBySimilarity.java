package com.miku.jfreesound.bean.requests;

import java.util.HashMap;
import java.util.Map;

import com.miku.jfreesound.bean.base.IBaseRequest;
import com.miku.jfreesound.utils.TextUtils;

public class RqSearchSoundsBySimilarity implements IBaseRequest {

	private static final String URL = "/sounds/<sound_id>/similar";// normal
																	// search

	/**
	 * id Required,The similar sound Id
	 */
	public String soundId;

	/**
	 * num_results Not Required, The number of similar sounds to return (max =
	 * 100, default = 15)
	 */
	public int num_results;

	/**
	 * preset Not Required, The similarity measure to use when retrieving
	 * similar sounds (for the moment, only lowlevel is available at is selected
	 * by default)
	 */
	public String preset;

	/**
	 * fields Not Required, Fields
	 */
	public String[] fields;

	/**
	 * Api Documentation error.this Parameter is InVaild. sounds_per_page Not
	 * Required, Number of sounds to return in each page (be aware that large
	 * numbers may produce sloooow queries, maximum allowed is 100 sounds per
	 * page)
	 */
	// public int sounds_per_page;

	@Override
	public String buildRequest() {

		Map<String, String> params = new HashMap<String, String>();

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append(URL.replaceFirst("<sound_id>", soundId))
				.append('?');

		// num_results
		if (num_results <= 0) {
			num_results = 15;
		}
		if (num_results > 100) {
			num_results = 100;
		}
		params.put("num_results", String.valueOf(num_results));

		// preset
		if (!TextUtils.isEmpty(preset)) {
			params.put("q", preset);
		}

		// fields
		if (fields == null) {
			// use default
			fields = new String[] {};
		}
		String str_fields = TextUtils.array2String(fields, ",");
		if (!TextUtils.isEmpty(str_fields)) {
			params.put("fields", str_fields);
		}

		// Api Documentation error.this Parameter is InVaild.
		/*
		 * sounds_per_page if(sounds_per_page<=0){ sounds_per_page=10; }
		 * if(sounds_per_page>100){ sounds_per_page=100; }
		 * params.put("sounds_per_page", String.valueOf(sounds_per_page));
		 */

		return queryBuilder.append(TextUtils.map2String(params, "&"))
				.toString();
	}

}
