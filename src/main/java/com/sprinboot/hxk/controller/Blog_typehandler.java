package com.sprinboot.hxk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sprinboot.hxk.service.Blog_typeservice;
import com.sprinboot.hxk.pojo.*;
@Controller
public class Blog_typehandler {
	@Autowired
	private Blog_typeservice blogtypeservice;
	
	//后台进入分类页面
	@RequestMapping(value="/type_list",method = RequestMethod.GET)
	public String type_list(Map map,Blog_type type) {
		map.put("typelist",blogtypeservice.querytypelist(type));
		return "list/blog_type";
	}
	
	//返回博客类别的JSON
	@RequestMapping(value="/typelist",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Blog_type>> jsonblogtype() {
		try {
			List<Blog_type> querytypelist = blogtypeservice.querytypelist(null);
			return ResponseEntity.status(HttpStatus.OK).body(querytypelist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	//异步删除分类信息
	@RequestMapping(value="/delete/blog_type/{id}",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> delete_type(@PathVariable("id") Integer id) {
		try {
			Integer type = blogtypeservice.deletetype(id);
			if (type == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	//异步添加分类信息
	@RequestMapping(value="/insert/blog_type",method = RequestMethod.POST)
	public ResponseEntity<Void> insert_blog_type(Blog_type type) {
		try {
			Integer id = blogtypeservice.inserttypebyname(type);
			if (id == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
