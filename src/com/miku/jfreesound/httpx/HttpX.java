package com.miku.jfreesound.httpx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.miku.jfreesound.utils.Log;

public class HttpX implements IHttpX {
	private static final String TAG = HttpX.class.getSimpleName();
	private HttpClient mHttpClient;
	private static IHttpX mHttpX;
	
	private HttpX() {
		mHttpClient=createHttpClient();
	}
	
	public static synchronized IHttpX getInstance(){
		if(mHttpX==null){
			mHttpX=new HttpX();
		}
		return mHttpX;
	}
	
	private HttpClient createHttpClient() {
		Log.i(TAG, "Create HttpClient...");
		HttpParams params = new BasicHttpParams();
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params,
				HTTP.DEFAULT_CONTENT_CHARSET);
		HttpProtocolParams.setUseExpectContinue(params, true);

		HttpConnectionParams.setConnectionTimeout(params, 5000);
	    HttpConnectionParams.setSoTimeout(params, 10000);
	     
		SchemeRegistry schReg = new SchemeRegistry();
		schReg.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), 80));

		ClientConnectionManager conMgr = new ThreadSafeClientConnManager(
				params, schReg);
		return new DefaultHttpClient(conMgr, params);
	}

	@Override
	public String getRequest(String url) {
		int resCode = -1;
		BufferedReader reader = null;
		Log.i(TAG, "getRequest start:"+" url:" + url);
		try {
			// 发送get请求创建HttpGet对象
			HttpGet getMethod = new HttpGet(url);
			HttpResponse response = mHttpClient.execute(getMethod);
			// 获取状态码
			resCode = response.getStatusLine().getStatusCode();
			if (resCode == 200) {
				StringBuilder builder = new StringBuilder();
				// 获取响应内容
				reader = new BufferedReader(new InputStreamReader(response
						.getEntity().getContent()));
				for (String s = reader.readLine(); s != null; s = reader
						.readLine()) {
					builder.append(s);
				}
				Log.i(TAG, "getRequest  succ");
				return builder.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			mHttpClient.getConnectionManager().closeIdleConnections(0, TimeUnit.MILLISECONDS);
		}
		Log.i(TAG, "getRequest end-RespCode:" + resCode + " url:" + url);
		return null;
	}

	@Override
	public String postRequest(String url, List<NameValuePair> params) {
		int statueCode = -1;
		Log.i(TAG, "postRequest start:"+" url:" + url);
		try {
			// 发post请求创建HttpGet对象
			HttpPost postMethod = new HttpPost(url);
			postMethod.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			HttpResponse response = mHttpClient.execute(postMethod);
			statueCode = response.getStatusLine().getStatusCode();
			if (statueCode == 200) {
				Log.i(TAG, "postRequest  succ");
				HttpEntity entity=response.getEntity();
				String result=EntityUtils.toString(entity);
				if(entity!=null){
					entity.consumeContent();
				}
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mHttpClient.getConnectionManager().closeIdleConnections(0, TimeUnit.MILLISECONDS);
		}
		Log.e(TAG, "postRequest-RespCode:" + statueCode + " url:" + url);
		return null;
	}
	
	

}
