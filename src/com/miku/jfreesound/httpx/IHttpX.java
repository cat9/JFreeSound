package com.miku.jfreesound.httpx;

import java.util.List;

import org.apache.http.NameValuePair;

public interface IHttpX {
	public String getRequest(String url);
	public String postRequest(String url, List<NameValuePair> params);
}
