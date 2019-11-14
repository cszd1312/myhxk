package com.sprinboot.hxk.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Blog {

	private Integer id; //博客编号
	private String blog_name; //博客标题
	private Blog_type type; //博客分类
	private Integer blog_type; //博客关联分类
	private String blog_text; //博客的文本内容,文本内容中的图片有另一个类保存
	private String blog_article; //博客的内容摘要为空则默认为文本内容开头一部分
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8") 
	private Date blog_date; //博客的创建时间
	private String time_packing; //博客创建天数
	private Integer blog_click; //博客的点击次数
	private Integer blog_comment; //博客是否开启评论
	private Integer blog_appreciate; //博客是否开启赞赏
	private Integer blog_user; //博客创建者ID
	private Blog_img blog_img; //博客封面类
	private User user;	//用户类
	private Comments comments; //评论类
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBlog_name() {
		return blog_name;
	}
	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}
	public Blog_type getType() {
		return type;
	}
	public void setType(Blog_type type) {
		this.type = type;
	}
	public Integer getBlog_type() {
		return blog_type;
	}
	public void setBlog_type(Integer blog_type) {
		this.blog_type = blog_type;
	}
	public String getBlog_text() {
		return blog_text;
	}
	public void setBlog_text(String blog_text) {
		this.blog_text = blog_text;
	}
	public String getBlog_article() {
		return blog_article;
	}
	public void setBlog_article(String blog_article) {
		this.blog_article = blog_article;
	}
	public Date getBlog_date() {
		return blog_date;
	}
	public void setBlog_date(Date blog_date) {
		this.blog_date = blog_date;
	}
	public String getTime_packing() {
		return time_packing;
	}
	public void setTime_packing(String time_packing) {
		this.time_packing = time_packing;
	}
	public Integer getBlog_click() {
		return blog_click;
	}
	public void setBlog_click(Integer blog_click) {
		this.blog_click = blog_click;
	}
	public Integer getBlog_comment() {
		return blog_comment;
	}
	public void setBlog_comment(Integer blog_comment) {
		this.blog_comment = blog_comment;
	}
	public Integer getBlog_appreciate() {
		return blog_appreciate;
	}
	public void setBlog_appreciate(Integer blog_appreciate) {
		this.blog_appreciate = blog_appreciate;
	}
	public Integer getBlog_user() {
		return blog_user;
	}
	public void setBlog_user(Integer blog_user) {
		this.blog_user = blog_user;
	}
	public Blog_img getBlog_img() {
		return blog_img;
	}
	public void setBlog_img(Blog_img blog_img) {
		this.blog_img = blog_img;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	public Blog() {
		super();
	}
	public Blog(String blog_name, Blog_type type, Integer blog_type, String blog_text, String blog_article,
			Date blog_date, String time_packing, Integer blog_click, Integer blog_comment, Integer blog_appreciate,
			Integer blog_user, Blog_img blog_img, User user, Comments comments) {
		super();
		this.blog_name = blog_name;
		this.type = type;
		this.blog_type = blog_type;
		this.blog_text = blog_text;
		this.blog_article = blog_article;
		this.blog_date = blog_date;
		this.time_packing = time_packing;
		this.blog_click = blog_click;
		this.blog_comment = blog_comment;
		this.blog_appreciate = blog_appreciate;
		this.blog_user = blog_user;
		this.blog_img = blog_img;
		this.user = user;
		this.comments = comments;
	}
	public Blog(Integer id, String blog_name, Blog_type type, Integer blog_type, String blog_text, String blog_article,
			Date blog_date, String time_packing, Integer blog_click, Integer blog_comment, Integer blog_appreciate,
			Integer blog_user, Blog_img blog_img, User user, Comments comments) {
		super();
		this.id = id;
		this.blog_name = blog_name;
		this.type = type;
		this.blog_type = blog_type;
		this.blog_text = blog_text;
		this.blog_article = blog_article;
		this.blog_date = blog_date;
		this.time_packing = time_packing;
		this.blog_click = blog_click;
		this.blog_comment = blog_comment;
		this.blog_appreciate = blog_appreciate;
		this.blog_user = blog_user;
		this.blog_img = blog_img;
		this.user = user;
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", blog_name=" + blog_name + ", type=" + type + ", blog_type=" + blog_type
				+ ", blog_text=" + blog_text + ", blog_article=" + blog_article + ", blog_date=" + blog_date
				+ ", time_packing=" + time_packing + ", blog_click=" + blog_click + ", blog_comment=" + blog_comment
				+ ", blog_appreciate=" + blog_appreciate + ", blog_user=" + blog_user + ", blog_img=" + blog_img
				+ ", user=" + user + ", comments=" + comments + "]";
	}
	
}
