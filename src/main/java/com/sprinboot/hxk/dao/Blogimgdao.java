package com.sprinboot.hxk.dao;

import com.sprinboot.hxk.pojo.Blog_img;

public interface Blogimgdao {

	public Integer insertblogimg(Integer blog_id,String blog_img);
	
	public Blog_img querybybid(Integer bid);
	
	public void updatebybid(String img_src,Integer bid);
}
