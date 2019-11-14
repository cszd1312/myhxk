package com.sprinboot.hxk.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sprinboot.hxk.pojo.Admin;
import com.sprinboot.hxk.pojo.Img_src;
import com.sprinboot.hxk.pojo.Msg;
import com.sprinboot.hxk.pojo.Packaging;
import com.sprinboot.hxk.pojo.User;
import com.sprinboot.hxk.service.Adminservice;
import com.sprinboot.hxk.service.Userservice;

@Controller
public class Userhandler {

	@Autowired
	private Userservice userservice;
	
	@Autowired
	private Adminservice adminservice;
	
	@RequestMapping(value="/queryuser",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Msg> query(User user,HttpSession session) {
		try {
			User user2= userservice.queryUser(user);
			if (user2 == null) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
			session.setAttribute("user",user2);
			String dizhi=(String) session.getAttribute("dizhi");
			Msg msg=new Msg(dizhi);
			return ResponseEntity.ok(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@RequestMapping(value="/")
	public String index(String dizhi,HttpSession session) {
		//保存注册前的路径
		if(dizhi!=null) {
			session.setAttribute("dizhi",dizhi);
		}else {
			session.setAttribute("dizhi",null);
		}
		return "list/index";
	}
	//注册用户账号路径
	@RequestMapping(value="/insert_user",method=RequestMethod.POST)
	public String insert_user(Map map,String vercode,User user,HttpSession session) {
		String demo=(String) session.getAttribute("code");
		System.out.println(demo);
		if(vercode.toUpperCase().equals(demo.toUpperCase())) {
			System.out.println("验证通过");
			Integer insertuser = userservice.insertuser(user);
			if(insertuser==null) {
				map.put("msg", "账号注册失败,<a href='/register'>点击</a>这里返回继续注册");
				return "list/messg";
			}else {
				//session.setAttribute("user","0"); 
				return "redirect:/register";
			}
		}
		map.put("msg","验证码出错，<a href='/register'>点击</a>这里返回继续注册");
		return "list/messg";
	}
	//进入用户登录
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String register() {
		return "list/user_register";
	}
	//进入管理员登录
	@RequestMapping(value="/backstage",method=RequestMethod.GET)
	public String backstageUI(Map map) {
		System.out.println("进入管理员登录");
		map.put("msg","");
		return "list/user_backstage";
	}
	//管理员登录验证
	@RequestMapping(value="/user_admin",method=RequestMethod.GET)
	public String backstage(Admin admin,Map map,HttpSession session) {
		Admin demo = adminservice.queryadmin(admin);
		if(demo!=null) {
			session.setAttribute("admin",demo);
			return "redirect:/demo";
		}
		map.put("msg","账号或密码错误");
		return "list/user_backstage";
	}
	//进入管理员基本信息
	@RequestMapping(value="/query/admin",method=RequestMethod.GET)
	public String queryadminbyid(HttpSession session,Map<String,Admin> map) {
		Admin admin=(Admin) session.getAttribute("admin");
		System.out.println(admin);
		map.put("admin",admin);
		return "list/admin";
	}
	
	@RequestMapping(value="/admin_img/upload",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Packaging> admin_img_upload(@RequestParam("file")MultipartFile file
			,HttpSession session,HttpServletRequest request) {
		String[] split = file.getOriginalFilename().split("\\.");//截取文件后缀名
		String replace = "/user/"+UUID.randomUUID().toString().replace("-","")+"."+split[1]; //UUID随机一个随机数作为文件名
		//服务器上使用
		//String rootPath =request.getServletContext().getRealPath("/WEB-INF/classes/static");
		//本地使用
		String rootPath ="C:/Users/Administrator/Desktop/hxk/src/main/resources/static";    
        File fileDir = new File(rootPath+replace);
        File demo=new File(fileDir.getAbsolutePath());
        System.out.println(fileDir.getAbsolutePath());
		try {
			file.transferTo(fileDir);
			Admin admin=(Admin) session.getAttribute("admin");
			admin.setAdmin_img(replace);
			Integer updateadmin = adminservice.updateadmin(admin);
			if(updateadmin==null) {
				return ResponseEntity.ok(new Packaging(500, "数据库添加出错",new Img_src()));
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(new Packaging(200,"",new Img_src(replace,"测试图片名")));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	//修改管理员信息
	@RequestMapping(value="/update_admin",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> update_admin(Admin admin) {
		System.out.println(admin);
		Integer updateadmin = adminservice.updateadmin(admin);
		if(updateadmin==null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	//管理员注销
	@RequestMapping(value="/Logoff",method = RequestMethod.GET)
	public String Logoff(HttpSession session,Map map) {
		session.setAttribute("user",null);
		return "redirect:/backstage";
	}
}
