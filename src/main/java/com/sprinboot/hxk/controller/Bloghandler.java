package com.sprinboot.hxk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.DateUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sprinboot.hxk.pojo.Admin;
import com.sprinboot.hxk.pojo.Blog;
import com.sprinboot.hxk.pojo.Blog_img;
import com.sprinboot.hxk.pojo.Blog_pack;
import com.sprinboot.hxk.pojo.Blog_type;
import com.sprinboot.hxk.pojo.Img_src;
import com.sprinboot.hxk.pojo.Packaging;
import com.sprinboot.hxk.pojo.User;
import com.sprinboot.hxk.service.Blog_typeservice;
import com.sprinboot.hxk.service.Blogservice;
import com.sprinboot.hxk.util.Time_calculation;

@Controller
public class Bloghandler {

	@Autowired
	private Blogservice blogservice;
	public final static String IMG_PATH_PREFIX = "static//imges";
	@Autowired
	private Blog_typeservice blogtypeservice;
	//进入博客添加页面
	@RequestMapping(value="/blog_insertUI",method = RequestMethod.GET)
	public String blog_insertUI() {
		System.out.println("进入博客添加页面");
		return "list/blog_insertUI";
	}
	//博客添加
	@RequestMapping(value="/insert/blog",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity blog_insert(Blog blog,String blog_imgs,HttpSession session) {
		try {
			Admin user = (Admin) session.getAttribute("admin");
			System.out.println(blog_imgs);
			Integer blogid = blogservice.insertblogbyblog(blog,blog_imgs,user.getId());
			if (blogid == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	//首页加载博客
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String blog_page(@RequestParam(value="page",defaultValue="1")Integer page,Integer typename,Map map) {
		PageHelper.startPage(page,5);
		List<Blog> bloglist = blogservice.querybloglist(typename);
		System.out.println(bloglist);
		Time_calculation timefromat=new Time_calculation();
		List<Blog> list = timefromat.calculation_date(bloglist);
		PageInfo userPageInfo = new PageInfo<>(list);
		if(typename!=null) {
			map.put("typeid",typename);
		}
		map.put("demo",userPageInfo);   
		map.put("typelist",blogtypeservice.querytypelist(null));
		map.put("length",userPageInfo.getPageNum());   
		map.put("lastlength",userPageInfo.getPages()); 
		System.out.println(userPageInfo.getPageNum());
		return "list/list";
	}
	//进入博客详情页
	@RequestMapping(value="/blog/{id}",method = RequestMethod.GET)
	public String blog_id(@PathVariable("id") Integer id,Map<String,Object> map,HttpSession session) {
		Blog querybyid = blogservice.querybyid(id);
		blogservice.updateblogbyclick(id);
		User user = (User) session.getAttribute("user");
		map.put("user",user!=null?user.getId():null);
		map.put("blog",querybyid);
		return "list/blog_demo";
	}
	
	//接收博客文章附带的图片并保存在服务器
	@RequestMapping(value="/upload/blog_img",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Packaging> upload_blog_img(@RequestParam("file")MultipartFile mfile,
		HttpServletRequest request
			) {
		
		String[] split = mfile.getOriginalFilename().split("\\.");//截取文件后缀名
		String replace = "/user/"+UUID.randomUUID().toString().replace("-","")+"."+split[1]; //UUID随机一个随机数作为文件名
		//服务器上使用
		//String rootPath =request.getServletContext().getRealPath("/WEB-INF/classes/static");
		//本地使用
        String rootPath ="C:\\Users\\Administrator\\Desktop\\hxk-master (2)\\hxk\\src\\main\\resources\\static";    
        File fileDir = new File(rootPath+replace);
        File demo=new File(fileDir.getAbsolutePath());
		try {
			mfile.transferTo(fileDir);
			Packaging code=new Packaging(0,"上传成功",new Img_src(replace,mfile.getOriginalFilename()));
			return ResponseEntity.status(HttpStatus.OK).body(code);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Packaging code=new Packaging(500,"上传失败",new Img_src());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(code);
	}
	//根据博客标题模糊查询
	@RequestMapping(value="/test/blog_name",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Blog_pack> likename(@RequestParam(defaultValue = "1")Integer page,String blog_name,@RequestParam(defaultValue = "10")Integer limit){
		PageHelper.startPage(page,limit);
		List<Blog> likename = blogservice.querylikename(blog_name);
		PageInfo list=new PageInfo(likename);
		Blog_pack demo=new Blog_pack();
		demo.setCode(200);
		demo.setMsg("成功");
		demo.setCount((int)list.getTotal());
		demo.setData(list.getList());
		return ResponseEntity.status(HttpStatus.OK).body(demo);
	}
	
	@RequestMapping(value="/delete/blog",method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity delete_blog(Integer id) {
		try {
			Integer deleteblogbyid = blogservice.deleteblogbyid(id);
			if (deleteblogbyid != null) {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	//进入博客修改页面
	@RequestMapping(value="/update_blogUI",method = RequestMethod.GET)
	public String update_blogUI(Integer id,Map<String, Object> map) {
		Blog querybyid = blogservice.querybyid(id);
		map.put("blog",querybyid);
		map.put("blogtype",blogtypeservice.querytypelist(null));
		return "list/blog_update";
	}
	//异步修改博客
	@RequestMapping(value="/update/blog",method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> update_blog(Blog blog) {
		try {
			Integer blogid = blogservice.updatebyblog(blog);
			if (blogid == null) {
				return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
			}
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@RequestMapping(value="/console",method=RequestMethod.GET)
	public String console() {
		return "list/console";
	}
}
