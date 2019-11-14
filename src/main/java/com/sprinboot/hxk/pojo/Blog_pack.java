package com.sprinboot.hxk.pojo;

public class Blog_pack<T> {

	private Integer code;
	private String msg;
	private Integer count;
	private T data;
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Blog_pack(Integer code, String msg, Integer count, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	public Blog_pack() {
		super();
	}
	@Override
	public String toString() {
		return "Blog_pack [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
	
}
