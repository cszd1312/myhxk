package com.sprinboot.hxk.pojo;

//通用图片类
public class Img_src {
	
	private String src; //上传图片的路径
	private String title; //上传图片的名称
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Img_src(String src, String title) {
		super();
		this.src = src;
		this.title = title;
	}
	public Img_src() {
		super();
	}
	@Override
	public String toString() {
		return "Img_src [src=" + src + ", title=" + title + "]";
	}
	
}
