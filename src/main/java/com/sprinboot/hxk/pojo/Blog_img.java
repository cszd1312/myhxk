package com.sprinboot.hxk.pojo;

public class Blog_img {

	private Integer id;
	private String img_src;
	private Integer blog_id;
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
	public Integer getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(Integer blog_id) {
		this.blog_id = blog_id;
	}
	public Blog_img(Integer id, String img_src, Integer blog_id) {
		super();
		this.id = id;
		this.img_src = img_src;
		this.blog_id = blog_id;
	}
	public Blog_img() {
		super();
	}
	@Override
	public String toString() {
		return "Blog_img [id=" + id + ", img_src=" + img_src + ", blog_id=" + blog_id + "]";
	}
	
}
