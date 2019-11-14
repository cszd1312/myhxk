package com.sprinboot.hxk.pojo;

public class User {

	private Integer id;
	private String username;
	private String password;
	private String user_img;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public User(Integer id, String username, String password, String user_img) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.user_img = user_img;
	}
	public User(String username, String password, String user_img) {
		super();
		this.username = username;
		this.password = password;
		this.user_img = user_img;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", user_img=" + user_img + "]";
	}
	
	
	
}
