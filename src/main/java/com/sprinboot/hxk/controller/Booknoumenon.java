package com.sprinboot.hxk.controller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprinboot.hxk.pojo.Admin;
import com.sprinboot.hxk.pojo.Blog;
import com.sprinboot.hxk.pojo.User;
import com.sprinboot.hxk.service.Userservice;
import com.sprinboot.hxk.util.Imgescode;

@Controller
public class Booknoumenon {
	 // 图片高度
    private static final int IMG_HEIGHT = 100;
    // 图片宽度
    private static final int IMG_WIDTH = 30;
    // 验证码长度
    private static final int CODE_LEN = 4;

	@Autowired
	private Userservice userservice;
	
//	@RequestMapping(value="/list",method=RequestMethod.GET)
//	public String list(User user,HttpSession session
//			) {
//		User queryUser = userservice.queryUser(user);
//		System.out.println(queryUser+"session获取的用户");
//		session.setAttribute("user",queryUser);
//		return "list/list";
//	}
	
	//前端获取动态验证码
	@RequestMapping(value="/getCode")
	public void getcode(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		 try {
             int width=200;
             int height=69;
			BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			//生成对应宽高的初始图片
			             String randomText = Imgescode.drawRandomText(width,height,verifyImg);
			//单独的一个类方法，出于代码复用考虑，进行了封装。
			//功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符                   
			             req.getSession().setAttribute("verifyCode", randomText);
			resp.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别
			OutputStream os = resp.getOutputStream(); //获取文件输出流    
			ImageIO.write(verifyImg,"png",os);//输出图片流
			os.flush();
			os.close();//关闭流
    } catch (IOException e) {
             e.printStackTrace();
    }

	}
	@RequestMapping(value="/demo",method=RequestMethod.GET)
	public String demo(HttpSession session,Map map) {
		Admin attribute = (Admin) session.getAttribute("admin");
		map.put("admin",attribute);
		return "list/demo";
	}
	@RequestMapping(value="/console2",method=RequestMethod.GET)
	public String console2() {
		return "list/blog_search";
	}
	@RequestMapping(value="/note_insert",method = RequestMethod.GET)
	public String note_insert(){
		return "list/note_insert";
	}
	@RequestMapping(value="/note_query",method = RequestMethod.GET)
	public String note_query(){
		return "list/note_query";
	}
	@RequestMapping(value="/wenben")
	public String wenben() {
		return "list/wenben";
	}

	
}
