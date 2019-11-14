package com.sprinboot.hxk.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.hxk.dao.Commentsdao;
import com.sprinboot.hxk.dao.Userdao;
import com.sprinboot.hxk.pojo.Comments;
import com.sprinboot.hxk.service.Commentsservice;
@Service
public class CommentsserviceImp implements Commentsservice{
	
	@Autowired
	private Commentsdao commentsdao;
	@Autowired
	private Userdao userdao;
	@Override
	public List<Comments> querybyblogid(Integer id) {
		return commentsdao.querylistbyblogid(id);
	}
	@Override
	public Integer insertcomment(Integer id, String comment_text, Integer blog_id, Integer reply_id) {
		Comments demo=new Comments();
		if(!reply_id.equals(0)) {
		Comments querybyid = commentsdao.querybyid(reply_id);
		reply_id=querybyid.getUser().getId();
		}
		demo.setUser_id(id);
		demo.setComment_text(comment_text);
		demo.setBlog_id(blog_id);
		demo.setComment_date(new Date());
		demo.setReply_id(reply_id);
		System.out.println(demo);
		return commentsdao.insertcomment(demo);
	}

}
