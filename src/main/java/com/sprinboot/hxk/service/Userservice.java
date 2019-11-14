package com.sprinboot.hxk.service;

import com.sprinboot.hxk.pojo.User;

public interface Userservice {

	public User queryUser(User user);
	
	public Integer insertuser(User user);

}
