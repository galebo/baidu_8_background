package com.galebo.web.common;

public class Message {

	private int code ;
	private String msg ;
	
	
	
	public Message() {
		super();
	}


	public Message(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	public static final Message getSuccessMsg() {
		return new Message(0, "success") ;
	}
	
}
