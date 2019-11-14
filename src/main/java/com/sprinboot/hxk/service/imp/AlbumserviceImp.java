package com.sprinboot.hxk.service.imp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprinboot.hxk.dao.Albumdao;
import com.sprinboot.hxk.dao.Picturedao;
import com.sprinboot.hxk.error.Myexeption;
import com.sprinboot.hxk.pojo.Album;
import com.sprinboot.hxk.pojo.Picture;
import com.sprinboot.hxk.service.Albumservice;

@Service
public class AlbumserviceImp implements Albumservice{

	@Autowired
	private Albumdao albumdao;
	@Autowired
	private Picturedao picturedao;
	@Override
	public List<Album> quertlist() {
		return albumdao.querylist();
	}
	@Override
	public Album querybyid(Integer id) {
		return albumdao.querybyid(id);
	}
	@Transactional() 
	public void insertandpicture(String img_title, String img_src, String picture_img_title,
			String picture_img_src) throws Exception{
		Album album = new Album(img_src, img_title);
		Integer id=albumdao.insertalbum(album);
		if(id==null) {
			throw new Myexeption("相册数据出错");
		}else {
		if(picture_img_title.length()>0 && picture_img_src.length()>0) {
			System.out.println(album.getId()+"相册ID");
			String[] split = picture_img_title.split(",");
			String[] split2 = picture_img_src.split(",");
			List<String> asList = Arrays.asList(split);
			List<String> asList2 = Arrays.asList(split2);
			for(int i=0;i<asList.size();i++) {
				if(asList.get(i).length()>0) {
					Integer id2=picturedao.insertpicture(new Picture(asList2.get(i), asList.get(i), asList.get(i), album.getId()));
					if(id2==null) {
						throw new Myexeption("相册照片添加数据出错");
					}
				}
			}
		}
			
		}
	}
	@Override
	public void deleteAlbum(Integer id) throws Exception{
		List<Picture> list = picturedao.querylistbupid(id);
		if(list.size()==0) {
			albumdao.deleteAlbum(id);
		}else {
			throw new Myexeption("删除相册失败");
		}
	}
	@Override
	public List<Album> queryalbumlike(String img_title) {
		return albumdao.queryalbumlike(img_title);
	}

}
