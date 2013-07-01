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


public interface DBOperationsInterface  {

	/**
	* method declaration
	*/
	public ResultSet selectData (String select);
	public int insertData (String insert);
	public int updateData (String update);
	public int deleteData (String delete);
 	
 	/**
 	* method
 	*/
 }// end DBOperations