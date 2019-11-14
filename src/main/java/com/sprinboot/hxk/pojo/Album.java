package com.sprinboot.hxk.pojo;
//相册类
public class Album {

	private Integer id; //个人图片id
	private String img_src; //个人图片地址
	private String img_title; //个人相册标题
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImg_src() {
		return img_src;
	}
	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
	public String getImg_title() {
		return img_title;
	}
	public void setImg_title(String img_title) {
		this.img_title = img_title;
	}
	public Album(Integer id, String img_src, String img_title) {
		super();
		this.id = id;
		this.img_src = img_src;
		this.img_title = img_title;
	}
	public Album(String img_src, String img_title) {
		super();
		this.img_src = img_src;
		this.img_title = img_title;
	}
	public Album() {
		super();
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", img_src=" + img_src + ", img_title=" + img_title + "]";
	}
	
	
}
