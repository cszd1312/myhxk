package com.sprinboot.hxk.exeption;

import java.io.PrintStream;
import java.io.PrintWriter;

public class Myexeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Myexeption(String mssage) {
		super(mssage);

	}

	public Myexeption() {
		super();
	}
	

	
}
