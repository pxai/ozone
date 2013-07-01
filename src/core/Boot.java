package com.javamercenary.ai.inferenczy.core;

/**
 * Título:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
 
 public class Boot  {

 	
 	/**
 	* method
 	*/
	Boot () {
	}
		
	
	public static void main (String args[]) {
		System.out.println("INFeReNCZy (c) P. Al. Madrid September 2001");
		System.out.println("INFeReNCZy Bootstrap...");
		new Kernel().start();
	}

 }