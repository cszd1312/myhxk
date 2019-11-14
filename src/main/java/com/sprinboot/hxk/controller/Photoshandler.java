package com.sprinboot.hxk.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sprinboot.hxk.pojo.Album;
import com.sprinboot.hxk.pojo.Img_src;
import com.sprinboot.hxk.pojo.Packaging;
import com.sprinboot.hxk.pojo.Picture;
import com.sprinboot.hxk.service.Albumservice;
import com.sprinboot.hxk.service.Pictureservice;

@Controller
public class Photoshandler {

	@Autowired
	private Albumservice albumservice;
	@Autowired
	private Pictureservice pictureservice;
	@RequestMapping(value="/note",method = RequestMethod.GET)
	public String note(Map map) {
		List<Album> list = albumservice.quertlist();
		map.put("album",list);
		System.out.println(list);
		return "list/note";
	}
	@RequestMapping(value="/photos/{id}",method = RequestMethod.GET)
	public String note_img(Map map,@PathVariable("id") Integer id) {
		Album album = albumservice.querybyid(id);
		List<Picture> pictures = pictureservice.querylistbupid(id);
		map.put("album",album);
		map.put("picture",pictures);
		return "list/note_img";
	}
	
	@RequestMapping(value="/photos/img_src",method = RequestMethod.POST)
	public ResponseEntity<Packaging> photos_img_src(@RequestParam("file")MultipartFile mfile) {
		String[] split = mfile.getOriginalFilename().split("\\.");//截取文件后缀名
		String replace = "/user/"+UUID.randomUUID().toString().replace("-","")+"."+split[1]; //UUID随机一个随机数作为文件名
		//服务器上使用
		//String rootPath =request.getServletContext().getRealPath("/WEB-INF/classes/static");
		//本地使用
        String rootPath ="C:\\Users\\Administrator\\Desktop\\hxk-master (2)\\hxk\\src\\main\\resources\\static";    
        File fileDir = new File(rootPath+replace);
        File demo=new File(fileDir.getAbsolutePath());
        System.out.println(fileDir.getAbsolutePath());
		try {
			mfile.transferTo(fileDir);
			Packaging code=new Packaging(200,"上传成功",new Img_src(replace,split[0]));
			return ResponseEntity.status(HttpStatus.OK).body(code);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Packaging code=new Packaging(500,"上传失败",new Img_src("",""));
		return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).build();
	}
	
	@RequestMapping(value="/insert/photo",method = RequestMethod.POST)
	public ResponseEntity<Void> insert_photo(String img_title,String img_src,
			String picture_img_title,String picture_img_src
			) {
		try {
			albumservice.insertandpicture(img_title,img_src,picture_img_title,picture_img_src);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	//根据ID删除相册
	@RequestMapping(value="/delete/photos/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Void> delete_photos(@PathVariable("id")Integer id) {
		try {
			albumservice.deleteAlbum(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	@RequestMapping(value="/query/photos",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Album>> query_photos(String img_title) {
		try {
			System.out.println(img_title);
			List<Album> like = albumservice.queryalbumlike(img_title);
			if (like.size() == 0) {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(like);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@RequestMapping(value="/query/picture",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Picture>> query_picture(Integer pid) {
		try {
			List<Picture> list = pictureservice.querylistbupid(pid);
			if (list.size() == 0) {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@RequestMapping(value="/delete/picture/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Void> delete_picture(@PathVariable("id") Integer id) {
		try {
			pictureservice.deletepicture(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	//相册添加照片
	@RequestMapping(value="/upload/pictyure",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Packaging> upload_pictyure(MultipartFile file,Integer id) {
		String[] split = file.getOriginalFilename().split("\\.");//截取文件后缀名
		String replace = "/user/"+UUID.randomUUID().toString().replace("-","")+"."+split[1]; //UUID随机一个随机数作为文件名
		//服务器上使用
		//String rootPath =request.getServletContext().getRealPath("/WEB-INF/classes/static");
		//本地使用
        String rootPath ="C:\\Users\\Administrator\\Desktop\\hxk-master (2)\\hxk\\src\\main\\resources\\static";    
        File fileDir = new File(rootPath+replace);
        File demo=new File(fileDir.getAbsolutePath());
        System.out.println(fileDir.getAbsolutePath());
		try {
			file.transferTo(fileDir);
			Integer insertbupid = pictureservice.insertbupid(replace, id, split[0]);
			if(insertbupid==0) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).build();
			}
			Packaging code=new Packaging(200,insertbupid.toString(),new Img_src(replace,split[0]));
			System.out.println(code);
			return ResponseEntity.status(HttpStatus.OK).body(code);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Packaging code=new Packaging(500,"上传失败",new Img_src("",""));
		return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).build();
	}
}
