package com.sprinboot.hxk.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.hxk.dao.Userdao;
import com.sprinboot.hxk.pojo.User;
import com.sprinboot.hxk.service.Userservice;
@Service
public class UserserviceImp implements Userservice{
	@Autowired
	private Userdao userdao;
	
	@Override
	public User queryUser(User user) {
		// TODO Auto-generated method stub
		return userdao.queryUser(user);
	}

	@Override
	public Integer insertuser(User user) {
		return userdao.insertuser(user);
	}


}
