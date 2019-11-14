package com.sprinboot.hxk.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.hxk.dao.Blog_typedao;
import com.sprinboot.hxk.pojo.Blog_type;
import com.sprinboot.hxk.service.Blog_typeservice;
@Service
public class Blog_typeseerviceImp implements Blog_typeservice{
	
	@Autowired
	private Blog_typedao blogtypedao;
	@Override
	public List<Blog_type> querytypelist(Blog_type type) {
		return blogtypedao.querytypelist(type);
	}
	@Override
	public Blog_type querybyid(Integer id) {
		
		return blogtypedao.querybyid(id);
	}
	@Override
	public Integer deletetype(Integer id) {
		return blogtypedao.deletetype(id);
	}
	@Override
	public Integer inserttypebyname(Blog_type type) {
		return blogtypedao.inserttypebyname(type);
	}
}
