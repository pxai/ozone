package com.javamercenary.ai.inferenczy.core;

/**
 * Título:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection extends  Process {

	/**
	* Attributes
	*/
	private Connection _CONNECTION = null;
	
 	
 	/**
 	* method
 	*/
 	public DBConnection () {
 		super();
 	}

	
	/**
	* run  method
	*/
	public void run () {
		get_SI().log(1,"<DBConnection> starting...");
		if (openConnection()) 
			get_SI().log(1,"<DBConnection> Connected to DB");
		else
			get_SI().log(1,"<DBConnection> Can't connect to DB");
		setInterface();
		get_SI().log(1,"<DBConnection> started. [pid: "+this.getPID()+"]");
	}

	/**
	* openConnection
	*/
	private boolean openConnection () {
		try {
	      	 Class.forName(get_SI().getProperty("jdbc_driver")).newInstance();
	    	} catch (Exception e) {
        	  System.err.println("Error on Driver: "+e.getMessage());
		  return false;
    		}
    		try {
      		 _CONNECTION = DriverManager.getConnection(get_SI().getProperty("jdbc_url"),get_SI().getProperty("jdbc_user"),get_SI().getProperty("jdbc_password"));
      		 get_SI().setDBConnection(_CONNECTION);
	    	} catch (Exception e) {
        	  System.err.println("Error on Connect: "+e.getMessage());
		  return false;
    		}
		return true;	
	}

	/**
	* setInterface
	* sets DBOperationsInterface to SQL
	* must be done after Connection is made.
	*/
	private void setInterface () {
		get_SI().setDBOperationsInterface(new DBOperationsSQL(get_SI()));
		get_SI().log(1,"<DBConnection> DB Operations interface set to: SQL");
		//probe it:
		//get_SI().getDBOperationsInterface().selectData("select * from personas");
	}
	
	/**
	* getConnection
	*/
	public Connection getConnection () {
		return _CONNECTION;	
	}

 }// end DBConnection