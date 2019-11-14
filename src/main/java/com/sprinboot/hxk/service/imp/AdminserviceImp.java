package com.sprinboot.hxk.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.hxk.dao.Admindao;
import com.sprinboot.hxk.pojo.Admin;
import com.sprinboot.hxk.service.Adminservice;
@Service
public class AdminserviceImp implements Adminservice{
	@Autowired
	private Admindao admindao;
	
	@Override
	public Admin queryadmin(Admin admin) {
		return admindao.queryadmin(admin);
	}

	@Override
	public Integer updateadmin(Admin admin) {
		return admindao.updateadmin(admin);
	}

}
