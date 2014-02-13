package com.miku.jfreesound.bean;

import org.json.JSONObject;

import com.miku.jfreesound.JFreeSound;
import com.miku.jfreesound.bean.base.AbstractHashMapData;
import com.miku.jfreesound.bean.requests.RqGetOriginalFileUrl;

public class FsSound extends AbstractHashMapData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4632718778690444738L;

	public static final String DATA_ID = "id";
	public static final String DATA_REF = "ref";
	public static final String DATA_URL = "url";
	public static final String DATA_PREVIEW_HQ_MP3 = "preview-hq-mp3";
	public static final String DATA_PREVIEW_LQ_MP3 = "preview-lq-mp3";
	public static final String DATA_PREVIEW_HQ_OGG = "preview-hq-ogg";
	public static final String DATA_PREVIEW_LQ_OGG = "preview-lq-ogg";
	public static final String DATA_SERVE = "serve";
	public static final String DATA_SIMILARITY = "similarity";
	public static final String DATA_TYPE = "type";
	public static final String DATA_DURATION = "duration";
	public static final String DATA_SAMPLERATE = "samplerate";
	public static final String DATA_BITDEPTH = "bitdepth";
	public static final String DATA_FILESIZE = "filesize";
	public static final String DATA_BITRATE = "bitrate";
	public static final String DATA_CHANNELS = "channels";
	public static final String DATA_ORIGINAL_FILENAME = "original_filename";
	public static final String DATA_DESCRIPTION = "description";
	public static final String DATA_TAGS = "tags";
	public static final String DATA_LICENSE = "license";
	public static final String DATA_CREATED = "created";
	public static final String DATA_NUM_COMMENTS = "num_comments";
	public static final String DATA_NUM_DOWNLOADS = "num_downloads";
	public static final String DATA_NUM_RATINGS = "num_ratings";
	public static final String DATA_AVG_RATING = "avg_rating";
	public static final String DATA_PACK = "pack";
	public static final String DATA_GEOTAG = "geotag";
	public static final String DATA_USER = "user";
	public static final String DATA_SPECTRAL_M = "spectral_m";
	public static final String DATA_SPECTRAL_L = "spectral_l";
	public static final String DATA_WAVEFORM_M = "waveform_m";
	public static final String DATA_WAVEFORM_L = "waveform_l";
	public static final String DATA_ANALYSIS = "analysis";
	public static final String DATA_ANALYSIS_FRAMES = "analysis_frames";

	public static final String[] DATA_ALL = { DATA_ID, DATA_REF, DATA_URL,
			DATA_PREVIEW_HQ_MP3, DATA_PREVIEW_LQ_MP3, DATA_PREVIEW_HQ_OGG,
			DATA_PREVIEW_LQ_OGG, DATA_SERVE, DATA_SIMILARITY, DATA_TYPE,
			DATA_DURATION, DATA_SAMPLERATE, DATA_BITDEPTH, DATA_FILESIZE,
			DATA_BITRATE, DATA_CHANNELS, DATA_ORIGINAL_FILENAME,
			DATA_DESCRIPTION, DATA_TAGS, DATA_LICENSE, DATA_CREATED,
			DATA_NUM_COMMENTS, DATA_NUM_DOWNLOADS, DATA_NUM_RATINGS,
			DATA_AVG_RATING, DATA_PACK, DATA_GEOTAG, DATA_USER,
			DATA_SPECTRAL_M, DATA_SPECTRAL_L, DATA_WAVEFORM_M, DATA_WAVEFORM_L,
			DATA_ANALYSIS, DATA_ANALYSIS_FRAMES };

	public FsSound() {
	}

	public FsSound(JSONObject json) {
		super(json);
	}

	@Override
	public String[] getDataAll() {
		return DATA_ALL;
	}

	public String getId() {
		return get(DATA_ID);
	}

	public void setId(String id) {
		setValueByKey(DATA_ID, id);
	}

	public String getRef() {
		return get(DATA_REF);
	}

	public void setRef(String ref) {
		setValueByKey(DATA_REF, ref);
	}

	public String getUrl() {
		return get(DATA_URL);
	}

	public void setUrl(String url) {
		setValueByKey(DATA_URL, url);
	}

	public String getPreview_hq_mp3() {
		return get(DATA_PREVIEW_HQ_MP3);
	}

	public void setPreview_hq_mp3(String preview_hq_mp3) {
		setValueByKey(DATA_PREVIEW_HQ_MP3, preview_hq_mp3);
	}

	public String getPreview_lq_mp3() {
		return get(DATA_PREVIEW_LQ_MP3);
	}

	public void setPreview_lq_mp3(String preview_lq_mp3) {
		setValueByKey(DATA_PREVIEW_LQ_MP3, preview_lq_mp3);
	}

	public String getPreview_hq_ogg() {
		return get(DATA_PREVIEW_HQ_OGG);
	}

	public void setPreview_hq_ogg(String preview_hq_ogg) {
		setValueByKey(DATA_PREVIEW_HQ_OGG, preview_hq_ogg);
	}

	public String getPreview_lq_ogg() {
		return get(DATA_PREVIEW_LQ_OGG);
	}

	public void setPreview_lq_ogg(String preview_lq_ogg) {
		setValueByKey(DATA_PREVIEW_LQ_OGG, preview_lq_ogg);
	}

	public String getServe() {
		return get(DATA_SERVE);
	}

	public void setServe(String serve) {
		setValueByKey(DATA_SERVE, serve);
	}

	public String getSimilarity() {
		return get(DATA_SIMILARITY);
	}

	public void setSimilarity(String similarity) {
		setValueByKey(DATA_SIMILARITY, similarity);
	}

	public String getType() {
		return get(DATA_TYPE);
	}

	public void setType(String type) {
		setValueByKey(DATA_TYPE, type);
	}

	public String getDuration() {
		return get(DATA_DURATION);
	}

	public void setDuration(String duration) {
		setValueByKey(DATA_DURATION, duration);
	}

	public String getSamplerate() {
		return get(DATA_SAMPLERATE);
	}

	public void setSamplerate(String samplerate) {
		setValueByKey(DATA_SAMPLERATE, samplerate);
	}

	public String getBitdepth() {
		return get(DATA_BITDEPTH);
	}

	public void setBitdepth(String bitdepth) {
		setValueByKey(DATA_BITDEPTH, bitdepth);
	}

	public String getFilesize() {
		return get(DATA_FILESIZE);
	}

	public void setFilesize(String filesize) {
		setValueByKey(DATA_FILESIZE, filesize);
	}

	public String getBitrate() {
		return get(DATA_BITRATE);
	}

	public void setBitrate(String bitrate) {
		setValueByKey(DATA_BITRATE, bitrate);
	}

	public String getChannels() {
		return get(DATA_CHANNELS);
	}

	public void setChannels(String channels) {
		setValueByKey(DATA_CHANNELS, channels);
	}

	public String getOriginal_filename() {
		return get(DATA_ORIGINAL_FILENAME);
	}
	
	public String getOriginal_file(){
		RqGetOriginalFileUrl rq=new RqGetOriginalFileUrl();
		rq.soundId=getId();
		return JFreeSound.getInstance().buildUrl(rq);
	}

	public void setOriginal_filename(String original_filename) {
		setValueByKey(DATA_ORIGINAL_FILENAME, original_filename);
	}

	public String getDescription() {
		return get(DATA_DESCRIPTION);
	}

	public void setDescription(String description) {
		setValueByKey(DATA_DESCRIPTION, description);
	}

	public String getTags() {
		return get(DATA_TAGS);
	}

	public void setTags(String tags) {
		setValueByKey(DATA_TAGS, tags);
	}

	public String getLicense() {
		return get(DATA_LICENSE);
	}

	public void setLicense(String license) {
		setValueByKey(DATA_LICENSE, license);
	}

	public String getCreated() {
		return get(DATA_CREATED);
	}

	public void setCreated(String created) {
		setValueByKey(DATA_CREATED, created);
	}

	public String getNum_comments() {
		return get(DATA_NUM_COMMENTS);
	}

	public void setNum_comments(String num_comments) {
		setValueByKey(DATA_NUM_COMMENTS, num_comments);
	}

	public String getNum_downloads() {
		return get(DATA_NUM_DOWNLOADS);
	}

	public void setNum_downloads(String num_downloads) {
		setValueByKey(DATA_NUM_DOWNLOADS, num_downloads);
	}

	public String getNum_ratings() {
		return get(DATA_NUM_RATINGS);
	}

	public void setNum_ratings(String num_ratings) {
		setValueByKey(DATA_NUM_RATINGS, num_ratings);
	}

	public String getAvg_rating() {
		return get(DATA_AVG_RATING);
	}

	public void setAvg_rating(String avg_rating) {
		setValueByKey(DATA_AVG_RATING, avg_rating);
	}

	public String getPack() {
		return get(DATA_PACK);
	}

	public void setPack(String pack) {
		setValueByKey(DATA_PACK, pack);
	}

	public String getGeotag() {
		return get(DATA_GEOTAG);
	}

	public void setGeotag(String geotag) {
		setValueByKey(DATA_GEOTAG, geotag);
	}

	public String getUser() {
		return get(DATA_USER);
	}

	public void setUser(String user) {
		setValueByKey(DATA_USER, user);
	}

	public String getSpectral_m() {
		return get(DATA_SPECTRAL_M);
	}

	public void setSpectral_m(String spectral_m) {
		setValueByKey(DATA_SPECTRAL_M, spectral_m);
	}

	public String getSpectral_l() {
		return get(DATA_SPECTRAL_L);
	}

	public void setSpectral_l(String spectral_l) {
		setValueByKey(DATA_SPECTRAL_L, spectral_l);
	}

	public String getWaveform_m() {
		return get(DATA_WAVEFORM_M);
	}

	public void setWaveform_m(String waveform_m) {
		setValueByKey(DATA_WAVEFORM_M, waveform_m);
	}

	public String getWaveform_l() {
		return get(DATA_WAVEFORM_L);
	}

	public void setWaveform_l(String waveform_l) {
		setValueByKey(DATA_WAVEFORM_L, waveform_l);
	}

	public String getAnalysis() {
		return get(DATA_ANALYSIS);
	}

	public void setAnalysis(String analysis) {
		setValueByKey(DATA_ANALYSIS, analysis);
	}

	public String getAnalysis_frames() {
		return get(DATA_ANALYSIS_FRAMES);
	}

	public void setAnalysis_frames(String analysis_frames) {
		setValueByKey(DATA_ANALYSIS_FRAMES, analysis_frames);
	}
	
}
