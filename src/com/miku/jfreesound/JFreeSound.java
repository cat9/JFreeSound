package com.miku.jfreesound;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.miku.jfreesound.bean.FsSound;
import com.miku.jfreesound.bean.RetResult;
import com.miku.jfreesound.bean.base.IBaseRequest;
import com.miku.jfreesound.bean.requests.RqGetSoundAnalysis;
import com.miku.jfreesound.bean.requests.RqGetSoundById;
import com.miku.jfreesound.bean.requests.RqSearchSoundByContentBase;
import com.miku.jfreesound.bean.requests.RqSearchSoundByGeotags;
import com.miku.jfreesound.bean.requests.RqSearchSoundByNormal;
import com.miku.jfreesound.bean.requests.RqSearchSoundsBySimilarity;
import com.miku.jfreesound.httpx.HttpX;
import com.miku.jfreesound.httpx.IHttpX;

public class JFreeSound {
	private static final String TAG = JFreeSound.class.getSimpleName();

	// base url
	private static final String URL_BASE = "http://www.freesound.org/api";

	private String mApiKey;

	private static JFreeSound mJFreeSound;

	private IHttpX mHttpX;

	private JFreeSound() {
		mHttpX = HttpX.getInstance();
	}

	public static synchronized JFreeSound getInstance() {
		if (mJFreeSound == null) {
			mJFreeSound = new JFreeSound();
		}
		return mJFreeSound;
	}

	public void init(String apiKey) {
		mApiKey = apiKey;
	}

	private String buildUrl(IBaseRequest rq) {
		StringBuilder sb = new StringBuilder(URL_BASE);
		String reqStr=rq.buildRequest();
		sb.append(reqStr);
		if(reqStr.contains("?")){
			sb.append('&');
		}else{
			sb.append('?');
		}
		sb.append("api_key=").append(mApiKey);
		return sb.toString();
	}
	
	private void parseSearchSounds(RetResult<List<FsSound>> result,
			JSONObject retObj) throws JSONException{
		result.setArg1(retObj.optInt("num_results", 0));
		result.setArg2(retObj.optInt("num_pages",0));
		JSONArray jarr = retObj.getJSONArray("sounds");
		List<FsSound> list = new ArrayList<FsSound>();
		int len = jarr.length();
		for (int i = 0; i < len; i++) {
			FsSound sound = new FsSound(jarr.getJSONObject(i));
			list.add(sound);
		}
		result.setRetObj(list);
	}
	
	private RetResult<List<FsSound>> searchSound(IBaseRequest req,ResultCallback<List<FsSound>> resultCallback){
		OnParseResultListenner<List<FsSound>> listener = new OnParseResultListenner<List<FsSound>>() {
			@Override
			public void onParse(RetResult<List<FsSound>> result,
					JSONObject retObj) throws JSONException {
				parseSearchSounds(result,retObj);
			}
		};
		return execute(req, resultCallback, listener);
	}

	private <T> RetResult<T> execute(final IBaseRequest req,
			final ResultCallback<T> resultCallback,
			final OnParseResultListenner<T> listener) {
		if (resultCallback != null) {
			new Thread() {
				@Override
				public void run() {
					RetResult<T> result = execute(req, null, listener);
					resultCallback.onResult(result);
				}
			}.start();
			return null;
		} else {
			RetResult<T> result = new RetResult<T>();
			String ret = mHttpX.getRequest(buildUrl(req));
			if (ret != null) {
				try {
					JSONObject retObj = new JSONObject(ret);
					boolean isError = retObj.optBoolean("error", false);
					if (isError) {
						result.setRetCode(RetResult.RET_ERROR);
						result.setMsg(retObj.optString("explanation",
								"unknown error!"));
					} else {
						listener.onParse(result, retObj);
					}
				} catch (Exception e) {
					e.printStackTrace();
					result.setRetCode(RetResult.RET_ERROR);
					result.setMsg(e.getMessage());
				}
			} else {
				result.setRetCode(RetResult.RET_ERROR);
				result.setMsg("network error!");
			}
			return result;
		}
	}

	/**
	 * 
	 * @param req
	 * @param resultCallback
	 *            if resultCallback==null,then synchronize access the network
	 *            and return the result directly,or asynchronous execute and
	 *            callback in resultCallback
	 * @return RetResult<List<FsSound>> the result if resultCallback==null or
	 *         null when asynchronous
	 */
	public RetResult<List<FsSound>> searchSoundsByNormal(
			RqSearchSoundByNormal req,
			ResultCallback<List<FsSound>> resultCallback) {
		return searchSound(req, resultCallback);
	}

	/**
	 * 
	 * @param req
	 * @param resultCallback
	 *            if resultCallback==null,then synchronize access the network
	 *            and return the result directly,or asynchronous execute and
	 *            callback in resultCallback
	 * @return RetResult<List<FsSound>> the result if resultCallback==null or
	 *         null when asynchronous
	 */
	public RetResult<List<FsSound>> searchSoundsByContentBase(
			RqSearchSoundByContentBase req,
			ResultCallback<List<FsSound>> resultCallback) {
		return searchSound(req, resultCallback);
	}
	
	/**
	 * 
	 * @param req
	 * @param resultCallback
	 *            if resultCallback==null,then synchronize access the network
	 *            and return the result directly,or asynchronous execute and
	 *            callback in resultCallback
	 * @return RetResult<List<FsSound>> the result if resultCallback==null or
	 *         null when asynchronous
	 */
	public RetResult<List<FsSound>> searchSoundsByGeotags(
			RqSearchSoundByGeotags req,
			ResultCallback<List<FsSound>> resultCallback) {
		return searchSound(req, resultCallback);
	}
	
	/**
	 * 
	 * @param req
	 * @param resultCallback
	 *            if resultCallback==null,then synchronize access the network
	 *            and return the result directly,or asynchronous execute and
	 *            callback in resultCallback
	 * @return RetResult<List<FsSound>> the result if resultCallback==null or
	 *         null when asynchronous
	 */
	public RetResult<List<FsSound>> searchSoundsBySimilarity(
			RqSearchSoundsBySimilarity req,
			ResultCallback<List<FsSound>> resultCallback) {
		return searchSound(req, resultCallback);
	}
	
	/**
	 * 
	 * @param req
	 * @param resultCallback
	 *            if resultCallback==null,then synchronize access the network
	 *            and return the result directly,or asynchronous execute and
	 *            callback in resultCallback
	 * @return RetResult<List<FsSound>> the result if resultCallback==null or
	 *         null when asynchronous
	 */
	public RetResult<FsSound> getSoundById(
			RqGetSoundById req,
			ResultCallback<FsSound> resultCallback) {
		OnParseResultListenner<FsSound> listener = new OnParseResultListenner<FsSound>() {
			@Override
			public void onParse(RetResult<FsSound> result,
					JSONObject retObj) throws JSONException {
					FsSound sound = new FsSound(retObj);
				result.setRetObj(sound);
			}
		};
		return execute(req, resultCallback, listener);
	}
	
	/**
	 * 
	 * @param req
	 * @param resultCallback
	 *            if resultCallback==null,then synchronize access the network
	 *            and return the result directly,or asynchronous execute and
	 *            callback in resultCallback
	 * @return RetResult<List<FsSound>> the result if resultCallback==null or
	 *         null when asynchronous
	 */
	public RetResult<JSONObject> getSoundAnalysis(
			RqGetSoundAnalysis req,
			ResultCallback<JSONObject> resultCallback) {
		OnParseResultListenner<JSONObject> listener = new OnParseResultListenner<JSONObject>() {
			@Override
			public void onParse(RetResult<JSONObject> result,
					JSONObject retObj) throws JSONException {
				result.setRetObj(retObj);
			}
		};
		return execute(req, resultCallback, listener);
	}
	

	public interface ResultCallback<T> {
		public void onResult(RetResult<T> result);
	}

	private interface OnParseResultListenner<T> {
		public void onParse(RetResult<T> result, JSONObject retObj)
				throws JSONException;
	}

}
