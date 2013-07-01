package com.javamercenary.ai.inferenczy.core;

/**
 * Título:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
 
 public class Printer {
	
	private SystemInterface _SI = null;
 	
 	/**
 	* method
 	*/
	Printer () {
	}


	/**
	* setProperties
	*/
	public void setProperties (SystemInterface _SI) {
		this._SI = _SI;
	}	

	/**
	* print
	*/
	public void print (int flag, String message) {
		switch (flag) {
			case 0 : System.out.println(message);break;
			case 1: System.out.print(message);break;
			case -1: System.err.print(message);break;	
		}
	}
 }