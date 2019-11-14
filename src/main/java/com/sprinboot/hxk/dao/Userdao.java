package com.sprinboot.hxk.dao;

import com.sprinboot.hxk.pojo.User;

public interface Userdao {

	public User queryUser(User user);
	
	public User querybyid(Integer id);
	
	public Integer insertuser(User user);
	
}
