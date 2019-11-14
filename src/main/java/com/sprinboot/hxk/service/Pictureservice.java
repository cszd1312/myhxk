package com.sprinboot.hxk.service;

import java.util.List;

import com.sprinboot.hxk.pojo.Picture;
//相册——图片类sercice
public interface Pictureservice {

	public List<Picture> querylistbupid(Integer id);
	
	public void deletepicture(Integer id);
	
	public Integer insertbupid(String img_src,Integer pid,String img_name);
}
