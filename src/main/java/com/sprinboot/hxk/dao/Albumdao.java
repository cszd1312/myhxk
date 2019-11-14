package com.sprinboot.hxk.dao;

import java.util.List;

import com.sprinboot.hxk.pojo.Album;
import com.sprinboot.hxk.pojo.Picture;

public interface Albumdao {

	public List<Album> querylist();
	
	public Album querybyid(Integer id);
	
	public Integer insertalbum(Album album);
	
	public void deleteAlbum(Integer id);

	public List<Album> queryalbumlike(String img_title);
}
