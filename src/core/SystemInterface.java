package com.javamercenary.ai.inferenczy.core;

/**
 * Título:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
 
import java.util.Properties;
import java.util.Hashtable;
import java.util.Vector;
import java.io.IOException;
import java.io.FileInputStream;
import java.sql.Connection;

public class SystemInterface {
	
	/**
	* attributes
	*/
    private  Kernel _KERNEL = null;

/**
 * default constructor
 */
  public SystemInterface(Kernel _KERNEL) {
  	this._KERNEL = _KERNEL;
  }

/**
 * getProperty
 */
 public String getProperty  (String property) {
 try {
  return (String)_KERNEL.getProperties().getProperty(property);
  } catch (Exception e) {
    return null;
  }
 }

 /**
 * setProperty
 */
 public boolean setProperty  (String property, String value) {
 try {
  _KERNEL.getProperties().setProperty(property, value);
  return true;
  } catch (Exception e) {
    return false;
  }
 }

/**
* getProcessTable
*/
 public Hashtable getProcessTable () { 	
	return _KERNEL.getProcessTable(); 	
 }

/**
* log
*/
public boolean log (int loglevel, String message) {
	return _KERNEL.log(loglevel,message);
}

/**
* print
*/
public void print (int flag, String message) {
	 _KERNEL.print(flag,message);
}

/**
* startProcess
*/
public int startProcess (String name,int PID,int UID,int GID,int STATE,int PRIORITY, String P_INFO) {
	return _KERNEL.startProcess(name, PID, UID, GID, STATE, PRIORITY, P_INFO);
}


/**
* setDBConnection
*/
public void setDBConnection (Connection conn) {
	_KERNEL.setDBConnection(conn);	
}

/**
* getDBConnection
*/
public Connection getDBConnection () {
	return _KERNEL.getDBConnection();	
}

/**
* setDBOperations
*/
public void setDBOperationsInterface (DBOperationsInterface dbo) {
	_KERNEL.setDBOperationsInterface(dbo);	
}

/**
* getDBOperations
*/
public DBOperationsInterface getDBOperationsInterface () {
	return _KERNEL.getDBOperationsInterface();	
}

/**
* readData
* @param String filename
* @param String[] elements
* @return Hashtable
*/
public Hashtable readData (String filename, String[] elements) {
	return _KERNEL.readData(filename, elements);
}

/**
* readData
* @param String filename
* @param String field
* @return Hashtable
*/
public Vector readData (String filename,String field) {
	return _KERNEL.readData(filename,field);
}
}// end clase