package com.miku.jfreesound;

import java.util.List;

import org.json.JSONObject;

import com.miku.jfreesound.bean.FsSound;
import com.miku.jfreesound.bean.RetResult;
import com.miku.jfreesound.bean.requests.RqGetSoundAnalysis;
import com.miku.jfreesound.bean.requests.RqGetSoundById;
import com.miku.jfreesound.bean.requests.RqSearchSoundByContentBase;
import com.miku.jfreesound.bean.requests.RqSearchSoundByGeotags;
import com.miku.jfreesound.bean.requests.RqSearchSoundByNormal;
import com.miku.jfreesound.bean.requests.RqSearchSoundsBySimilarity;
import com.miku.jfreesound.utils.Log;

public class Test {
	private static final String TAG = Test.class.getSimpleName();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFreeSound fs=JFreeSound.getInstance();
		fs.init("53633ecaaa244da79575c0131bda54e5");
		
		
		/**
		RqSearchSoundByNormal req=new RqSearchSoundByNormal();
		req.queryWord="rain";
		RetResult<List<FsSound>> result=fs.searchSoundsByNormal(req,null);
		Log.e(TAG, "isSucc:"+result.isSucc());
		if(result.isSucc()){
			List<FsSound> list=result.getRetObj();
			for(FsSound sound:list){
				Log.e(TAG, sound.toString());
			}
		}else{
			Log.e(TAG, result.getMsg());
		}
		
		
		
		RqSearchSoundByContentBase req1=new RqSearchSoundByContentBase();
		req1.target=".sfx.tristimulus.mean:0.8,0.3,0.0";
		RetResult<List<FsSound>> result2=fs.searchSoundsByContentBase(req1,null);
		Log.e(TAG, "isSucc:"+result.isSucc());
		if(result2.isSucc()){
			List<FsSound> list=result2.getRetObj();
			for(FsSound sound:list){
				Log.e(TAG, sound.toString());
			}
		}else{
			Log.e(TAG, result2.getMsg());
		}
		
		
		
		RqGetSoundById req3=new RqGetSoundById();
		req3.soundId="83295";
		RetResult<FsSound> result3=fs.getSoundById(req3,null);
		Log.e(TAG, "isSucc:"+result.isSucc());
		if(result2.isSucc()){
			FsSound sound=result3.getRetObj();
				Log.e(TAG, sound.toString());
		}else{
			Log.e(TAG, result3.getMsg());
		}
		
		RqSearchSoundByGeotags req4=new RqSearchSoundByGeotags();
		req4.min_lon="2.005176544189453";
		req4.max_lon="2.334766387939453";
		req4.min_lat="41.3265528618605";
		req4.max_lon="41.4504467428547";
		RetResult<List<FsSound>> result4=fs.searchSoundsByGeotags(req4,null);
		Log.e(TAG, "isSucc:"+result4.isSucc());
		if(result4.isSucc()){
			List<FsSound> list=result4.getRetObj();
			for(FsSound sound:list){
				Log.e(TAG, sound.toString());
			}
		}else{
			Log.e(TAG, result4.getMsg());
		}
		
		RqGetSoundAnalysis req5=new RqGetSoundAnalysis();

		req5.soundId="999";
		req5.filter="lowlevel/dissonance";
		RetResult<JSONObject> result5=fs.getSoundAnalysis(req5,null);
		Log.e(TAG, "isSucc:"+result5.isSucc());
		if(result5.isSucc()){
			Log.e(TAG, result5.getRetObj().toString());
		}else{
			Log.e(TAG, result5.getMsg());
		}*/
		
		RqSearchSoundsBySimilarity req6=new RqSearchSoundsBySimilarity();
		req6.soundId="999";
		RetResult<List<FsSound>> result6=fs.searchSoundsBySimilarity(req6,null);
		Log.e(TAG, "isSucc:"+result6.isSucc());
		if(result6.isSucc()){
			List<FsSound> list=result6.getRetObj();
			for(FsSound sound:list){
				Log.e(TAG, sound.toString());
			}
		}else{
			Log.e(TAG, result6.getMsg());
		}
		
		
		
	}

}
