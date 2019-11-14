package com.sprinboot.hxk;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sprinboot.hxk.dao")
public class HxkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HxkApplication.class, args);
	}

}
