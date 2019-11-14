package com.sprinboot.hxk.service;

import java.util.List;

import com.sprinboot.hxk.pojo.Album;
import com.sprinboot.hxk.pojo.Picture;
//相册service
public interface Albumservice {

	public List<Album> quertlist();
	
	public Album querybyid(Integer id);

	public void insertandpicture(String img_title, String img_src, String picture_img_title, String picture_img_src) throws Exception;

	public void deleteAlbum(Integer id) throws Exception;
	
	public List<Album> queryalbumlike(String img_title);
}
