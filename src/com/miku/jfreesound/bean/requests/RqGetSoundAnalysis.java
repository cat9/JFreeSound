package com.miku.jfreesound.bean.requests;

import com.miku.jfreesound.utils.TextUtils;

import com.miku.jfreesound.bean.base.IBaseRequest;

/**
 * 
 * @author xr.lee
 * http://www.freesound.org/docs/api/resources.html#sound-analysis-resource
 *
 */
public class RqGetSoundAnalysis implements IBaseRequest {

	// url
	private static final String URL = "/sounds/<sound_id>/analysis/<filter>";

	/**
	 * id Sound ID
	 */
	public String soundId;

	/**
	 * filter More details please see
	 * http://www.freesound.org/docs/api/resources.html#sound-analysis-resource
	 */
	public String filter;

	/**
	 * all If set to true, all the available analysis data will be returned.
	 * This might include unstable or unreliable data. For stable descriptors
	 * use the recommended ones. (default=False) When retrieving non recommended
	 * features, all must be set to True.
	 */
	public boolean isAll;

	@Override
	public String buildRequest() {
		String url = URL.replaceFirst("<sound_id>", soundId).replaceFirst(
				"<filter>", TextUtils.isEmpty(filter) ? "" : filter);
		return url + (isAll ? "all=1" : "");
	}

}
