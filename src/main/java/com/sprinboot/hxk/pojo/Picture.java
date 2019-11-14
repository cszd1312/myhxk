package com.sprinboot.hxk.pojo;
//相册中的图片页
public class Picture {

	private Integer id;
	private String img_src;
	private String img_title;
	private String img_name;
	private Integer img_pid;
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
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public Integer getImg_pid() {
		return img_pid;
	}
	public void setImg_pid(Integer img_pid) {
		this.img_pid = img_pid;
	}
	public Picture() {
		super();
	}
	public Picture(String img_src, String img_title, String img_name, Integer img_pid) {
		super();
		this.img_src = img_src;
		this.img_title = img_title;
		this.img_name = img_name;
		this.img_pid = img_pid;
	}
	public Picture(Integer id, String img_src, String img_title, String img_name, Integer img_pid) {
		super();
		this.id = id;
		this.img_src = img_src;
		this.img_title = img_title;
		this.img_name = img_name;
		this.img_pid = img_pid;
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", img_src=" + img_src + ", img_title=" + img_title + ", img_name=" + img_name
				+ ", img_pid=" + img_pid + "]";
	}
	
}
