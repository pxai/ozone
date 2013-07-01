package com.javamercenary.ai.inferenczy.core;

/**
 * Título:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
import java.util.Hashtable;
import java.util.Vector;


public class ResultSet extends  Hashtable {

	/**
	* Attributes
	*/
	
 	
 	/**
 	* method
 	*/
 	public ResultSet () {
 	}

	/**
	* getValue
	*/
	public Object getValue(int iRow, String sColumn) {
		return  ((Vector)this.get(sColumn)).elementAt(iRow);
	}
	
 }// end ResultSet