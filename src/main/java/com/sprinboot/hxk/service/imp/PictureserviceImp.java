package com.sprinboot.hxk.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.hxk.dao.Picturedao;
import com.sprinboot.hxk.pojo.Picture;
import com.sprinboot.hxk.service.Pictureservice;
@Service
public class PictureserviceImp implements Pictureservice{
	@Autowired
	private Picturedao picturedao;
	@Override
	public List<Picture> querylistbupid(Integer id) {
		return picturedao.querylistbupid(id);
	}
	@Override
	public void deletepicture(Integer id) {
		picturedao.deletepicture(id);
	}
	@Override
	public Integer insertbupid(String img_src, Integer pid, String img_name) {
		Picture demo=new Picture(img_src, img_name, img_name, pid);
		Integer insertpicture = picturedao.insertpicture(demo);
		if(insertpicture==0) {
			return 0;
		}
		System.out.println(demo.getId()+"图片ID");
		return demo.getId();
	}

	
}
