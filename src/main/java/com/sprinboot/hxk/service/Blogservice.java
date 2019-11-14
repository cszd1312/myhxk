package com.sprinboot.hxk.service;

import java.util.List;

import com.sprinboot.hxk.pojo.Blog;

public interface Blogservice {

	public Integer insertblogbyblog(Blog blog,String blog_img,Integer id);
	
	public List<Blog> querybloglist(Integer typename);
	
	public Blog querybyid(Integer id);
	
	public List<Blog> querylikename(String blog_name);
	
	public Integer deleteblogbyid(Integer id);
	
	public Integer updatebyblog(Blog blog);
	
	public void updateblogbyclick(Integer id);

}
