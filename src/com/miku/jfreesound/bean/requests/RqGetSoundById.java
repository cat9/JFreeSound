package com.miku.jfreesound.bean.requests;

import com.miku.jfreesound.bean.base.IBaseRequest;

public class RqGetSoundById implements IBaseRequest {

private static final String URL="/sounds/<sound_id>";
	
	/**
	 * id Sound ID
	 */
	public String soundId;
	
	@Override
	public String buildRequest() {
		return URL.replaceFirst("<sound_id>", soundId);
	}
}
