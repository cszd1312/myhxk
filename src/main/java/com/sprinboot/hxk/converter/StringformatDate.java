package com.sprinboot.hxk.converter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringformatDate implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=null;
		try {
			date=format.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
