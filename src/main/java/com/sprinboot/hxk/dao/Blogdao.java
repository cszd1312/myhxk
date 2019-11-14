package com.sprinboot.hxk.dao;

import java.util.List;

import com.sprinboot.hxk.pojo.Blog;

public interface Blogdao {

	//添加博客
	public Integer insertblogbyblog(Blog blog);

	//查询博客
	public List<Blog> querybloglist(Integer typename);
	
	//查询博客根据ID
	public Blog querybyid(Integer id);
	
	public List<Blog> querylikename(String blog_name);
	
	public Integer deleteblogbyid(Integer id);
	
	public Integer updatebyblog(Blog blog);
	
	public void updateblogbyclick(Integer id);


}
