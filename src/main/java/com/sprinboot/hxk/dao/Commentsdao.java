package com.sprinboot.hxk.dao;

import java.util.List;

import com.sprinboot.hxk.pojo.Comments;

public interface Commentsdao {

	public List<Comments> querylistbyblogid(Integer id);

	public Integer insertcomment(Comments demo);
	
	public Comments querybyid(Integer id);
}
