package com.sprinboot.hxk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sprinboot.hxk.pojo.Blog;
import com.sprinboot.hxk.pojo.Comments;
import com.sprinboot.hxk.pojo.Msg;
import com.sprinboot.hxk.pojo.User;
import com.sprinboot.hxk.service.Commentsservice;

@Controller
public class Commentsahandler {

	@Autowired
	private Commentsservice commentsservice;
	
	@RequestMapping(value="/comment/paging",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<PageInfo> comment_paging(Integer blog,Integer page) {
		List<Comments> querybyblogid = commentsservice.querybyblogid(blog);
		PageHelper.startPage(page,5);
		System.out.println(querybyblogid);
		System.out.println("评论测试"+page+"||"+blog);
		PageInfo<Comments> userPageInfo = new PageInfo<>(querybyblogid);
		return ResponseEntity.status(HttpStatus.OK).body(userPageInfo);
	}
	
	//添加评论
	@RequestMapping(value="/insert/commnts",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity insert_commnts(String comment_text,
			Integer blog_id,@RequestParam(defaultValue = "0",required = false)Integer reply_id,HttpSession session) {
		try {
			User attribute = (User) session.getAttribute("user");
			if (attribute == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} else{
				commentsservice.insertcomment(attribute.getId(),comment_text,blog_id,reply_id);
				return ResponseEntity.status(HttpStatus.OK).build();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
}
