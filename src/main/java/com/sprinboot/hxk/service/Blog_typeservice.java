package com.sprinboot.hxk.service;

import java.util.List;

import com.sprinboot.hxk.pojo.Blog_type;

public interface Blog_typeservice {

	public List<Blog_type> querytypelist(Blog_type type);
	
	public Blog_type querybyid(Integer id);
	
	public Integer inserttypebyname(Blog_type type);
	
	public Integer deletetype(Integer id);
}
