package com.sprinboot.hxk.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.sprinboot.hxk.pojo.Blog;

//用于判断博客时间
public class Time_calculation {

	public List<Blog> calculation_date(List<Blog> list){
		
		for(Blog demo:list) {
			String demo2 = demo(demo.getBlog_date().getTime());
			demo.setTime_packing(demo2);
		}
		return list;
	}
	public String demo(long d) {  //JAVA时区问题
		long f=new Date().getTime();
		long in=(f-d)/1000;	
		if(in==0) {
			return "刚刚";
		}else if(in<30) {
			return in+"秒以前";
		}else if(in>=30 && in<60){
			return "半分钟前";
		}else if(in>=60 && in<60*60){
			long m=in/60;
			return m+"分钟前";
		}else if(in>=60*60 && in<60*60*24) {
			long h=(in/60)/60;
			return h+"小时前";
		}else if(in>=60*60*24 && in<60*60*24*30) {
			long t=in/60/60/24;
			return t+"天前";
		}else if(in>=60*60*24*30 && in<60*60*24*30*12){
			long y=in/60/60/24/30;
			return y+"月前";
		}else if(in>=60*60*24*30*12) {
			long n=in/60/60/24/30/12;
			return n+"年前";		
		}
		return "出错";
	}
}
