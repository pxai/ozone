package com.javamercenary.ai.inferenczy.core;

/**
 * T�tulo:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
 
 public class Log {
	
	private SystemInterface _SI = null;
 	private PrintWriter _LOG_WRITER = null;
 	
 	/**
 	* method
 	*/
	Log () {
	}

	/**
	* setProperties
	*/
	public void setProperties (SystemInterface _SI) {
		this._SI = _SI;
	}

	public boolean log (int loglevel, String message) {
		try {
		 if (Integer.parseInt(this._SI.getProperty("loglevel")) == loglevel) { 		 		  
		  _SI.print(0,message);
		  return this.writeLog(message);
		 }
		 return true;
		} catch (Exception e) {
			writeLog("Error: no loglevel is set. Check inferenczy.properties file.");
			return false;
		}
	}	

	/**
	* write
	*/
	private boolean writeLog (String message) {
		String header ="<LOG>",tail = "</LOG>";
	try {
		_LOG_WRITER = new PrintWriter(new FileOutputStream(this._SI.getProperty("logfile"), true));
		_LOG_WRITER.println(header+"<DATE>"+new Date().toString()+"</DATE><MESSAGE>"+message+"</MESSAGE>"+tail);
		_LOG_WRITER.close();
		return true;
	 } catch (IOException ioe) {
		 return false;
	 }
	}
 }