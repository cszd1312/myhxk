package com.sprinboot.hxk.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.hxk.dao.Blogdao;
import com.sprinboot.hxk.dao.Blogimgdao;
import com.sprinboot.hxk.pojo.Blog;
import com.sprinboot.hxk.service.Blogservice;

@Service
public class BlogserviceImp implements Blogservice{
	
	@Autowired
	private Blogdao blogdao;
	@Autowired
	private Blogimgdao imgdao;
	
	private static String imgs[]= {"/user/b.jpg","/user/c.jpg","/user/d.jpg"};
	@Override
	public Integer insertblogbyblog(Blog blog,String blog_img,Integer id) {
		if(blog.getBlog_article().length()<=0) {
			String demo=blog.getBlog_text().replaceAll("<img[^>]*>","");
			if(blog.getBlog_text().length()<=130) {
				blog.setBlog_article(demo+".......");
			}else {
				blog.setBlog_article(demo.substring(0,130)+".......");
			}
		}
		blog.setBlog_date(new Date());
		blog.setBlog_click(0);
		blog.setBlog_user(id);
		Integer insertblogbyblog = blogdao.insertblogbyblog(blog);
		if(blog.getId()!=null) {
			if(blog_img.length()==0) {
				int ran = (int) (Math.random()*(imgs.length-1));
				blog_img=imgs[ran];
			}
			imgdao.insertblogimg(blog.getId(), blog_img);
		}
		return insertblogbyblog;
	}
	@Override
	public List<Blog> querybloglist(Integer typename) {
		return blogdao.querybloglist(typename);
	}
	@Override
	public Blog querybyid(Integer id) {
		return blogdao.querybyid(id);
	}
	@Override
	public List<Blog> querylikename(String blog_name) {
		return blogdao.querylikename(blog_name);
	}
	@Override
	public Integer deleteblogbyid(Integer id) {
		return blogdao.deleteblogbyid(id);
	}
	@Override
	public Integer updatebyblog(Blog blog) {
		System.out.println(blog+"博客");
		imgdao.updatebybid(blog.getBlog_img().getImg_src(),blog.getId());
		return blogdao.updatebyblog(blog);
	}
	@Override
	public void updateblogbyclick(Integer id) {
		blogdao.updateblogbyclick(id);
	}
	
	
}
