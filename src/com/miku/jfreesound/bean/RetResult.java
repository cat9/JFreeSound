package com.miku.jfreesound.bean;

public class RetResult<T> {
	
	private static final int RET_BASE=2014;
	public static final int RET_SUCC=RET_BASE+1;
	public static final int RET_ERROR=RET_BASE+2;
	
	private T retObj;
	
	private int retCode=RET_SUCC;
	
	private int arg1,arg2;
	
	private String msg;

	public T getRetObj() {
		return retObj;
	}

	public void setRetObj(T retObj) {
		this.retObj = retObj;
	}

	public int getRetCode() {
		return retCode;
	}
	
	public boolean isSucc(){
		return retCode==RET_SUCC;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public int getArg1() {
		return arg1;
	}

	public void setArg1(int arg1) {
		this.arg1 = arg1;
	}

	public int getArg2() {
		return arg2;
	}

	public void setArg2(int arg2) {
		this.arg2 = arg2;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
