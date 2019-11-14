package com.sprinboot.hxk.pojo;

public class Blog_type {

	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blog_type(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Blog_type() {
		super();
	}
	@Override
	public String toString() {
		return "Blog_type [id=" + id + ", name=" + name + "]";
	}
	
}
