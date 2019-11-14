package com.sprinboot.hxk.dao;

import java.util.List;

import com.sprinboot.hxk.pojo.Picture;

public interface Picturedao {

	public List<Picture> querylistbupid(Integer id);
	
	public Integer insertpicture(Picture demo);
	
	public void deletepicture(Integer id);
}
