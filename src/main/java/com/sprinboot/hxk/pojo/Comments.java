package com.sprinboot.hxk.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

//评论类实体
public class Comments {

	private Integer id; //评论类id
	private Integer user_id; //评论用户id
	private Integer reply_id; //回复用户id 没有为0
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8") 
	private Date comment_date; //评论时间
	private String comment_text; //评论文本信息
	private Integer blog_id; //评论的博客对象id
	private User user;	//评论用户
	private User user2; //回复用户
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getReply_id() {
		return reply_id;
	}
	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public Integer getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(Integer blog_id) {
		this.blog_id = blog_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser2() {
		return user2;
	}
	public void setUser2(User user2) {
		this.user2 = user2;
	}
	public Comments(Integer id, Integer user_id, Integer reply_id, Date comment_date, String comment_text,
			Integer blog_id, User user, User user2) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.reply_id = reply_id;
		this.comment_date = comment_date;
		this.comment_text = comment_text;
		this.blog_id = blog_id;
		this.user = user;
		this.user2 = user2;
	}
	public Comments() {
		super();
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", user_id=" + user_id + ", reply_id=" + reply_id + ", comment_date="
				+ comment_date + ", comment_text=" + comment_text + ", blog_id=" + blog_id + ", user=" + user
				+ ", user2=" + user2 + "]";
	}
	
	
	
	
}
