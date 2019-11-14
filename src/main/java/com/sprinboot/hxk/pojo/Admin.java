package com.sprinboot.hxk.pojo;

public class Admin {

	private Integer id;
	private String nickname;
	private String username;
	private String password;
	private String admin_img;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getAdmin_img() {
		return admin_img;
	}
	public void setAdmin_img(String admin_img) {
		this.admin_img = admin_img;
	}
	public Admin(Integer id, String nickname, String username, String password, String admin_img) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.username = username;
		this.password = password;
		this.admin_img = admin_img;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", nickname=" + nickname + ", username=" + username + ", password=" + password
				+ ", admin_img=" + admin_img + "]";
	}
	
}
