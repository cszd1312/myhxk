package com.sprinboot.hxk.service;

import java.util.List;

import com.sprinboot.hxk.pojo.Comments;

public interface Commentsservice {

	public List<Comments> querybyblogid(Integer id);

	public Integer insertcomment(Integer id, String comment_text, Integer blog_id, Integer reply_id);
}
