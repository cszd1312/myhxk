package com.sprinboot.hxk.pojo;
//图片上传后的状态
public class Packaging {

	private Integer code;
	private String msg;
	private Img_src data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Img_src getData() {
		return data;
	}
	public void setData(Img_src data) {
		this.data = data;
	}
	public Packaging(Integer code, String msg, Img_src data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public Packaging() {
		super();
	}
	@Override
	public String toString() {
		return "Packaging [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
