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
 import java.sql.Connection;
 
 public class Kernel extends Thread {
 	
 	/**
 	* KERNEL ATTRIBUTES
 	*/
 	// process table
	private final static Hashtable _PROCESSES = new Hashtable();
	// system properties: loglevel, multiuser,...
	private InferenczyProperties _SYSTEM_PROPERTIES = new InferenczyProperties();
	// system interface
	private SystemInterface _SI = null;
	// log service
	private static final Log _LOG = new Log();
	// console output
	private static final Printer _PRINTER = new Printer();
	// XML Reader
	private static final SystemXMLReader _XML_READER = new SystemXMLReader();
	// database connection
	private Connection _DBCONNECTION = null;
	// database operations interface
	private DBOperationsInterface _DBOPERATIONS_INTERFACE = null;
 	
 	/**
 	* method
 	*/
	Kernel () {
	}
		
	/**
	* run the Kernel
	*/
	public void run () {
		// first of all, load system properties.
		if (!this.loadProperties()) {
			System.err.println("Failed to load Properties file.");	
		}
		_SI = new SystemInterface(this);
		//setting properties.
		_LOG.setProperties(_SI);
		_PRINTER.setProperties(_SI);	
		_XML_READER.setProperties(_SI);	
		_LOG.log(1,"<Kernel> Kernel loaded.");
		// now run first process: init (pid:1)
		_LOG.log(1,"<Kernel> starting init...");
		startProcess("com.javamercenary.ai.inferenczy.core.Init",1,1,1,1,1,"Init program");
	}
	
	/**
	* loadProperties
	*/
	private boolean loadProperties () {
		return _SYSTEM_PROPERTIES.loadProperties();
	}
	
	/**
	* getProperties
	*/
	public InferenczyProperties getProperties () {
		return  _SYSTEM_PROPERTIES;
	}
	
	/**
	* startProcess
	* return 0 if everything works well
	*/
	public int startProcess (String name,int PID,int UID,int GID,int STATE,int PRIORITY, String P_INFO) {
		Object o = null;
		try {
		o = Class.forName(name).newInstance();	
		} catch (ClassNotFoundException cnfe) {
			_LOG.log(1,"Error on instantiation. Class not Found."+cnfe.getMessage());
			return -1;
		} catch (IllegalAccessException iae) {
			_LOG.log(1,"Error on instantiation.Illegal Access"+iae.getMessage());
			return -2;
		} catch (InstantiationException ie) {
			_LOG.log(1,"Error on instantiation."+ie.getMessage());
			return -3;
		}
		try {
		if (((Process) o).setAttributes(PID,UID,GID,STATE, PRIORITY,P_INFO,this._SI)) {
			addProcess(((Process)o));
			((Process) o).start();			
		}
		return 0;
		} catch (Exception e) {
			removeProcess(new Integer(((Process)o).getPID()));
			_LOG.log(1,"Error on instantiation."+e.getMessage());
			return -4;
		}
		
	}

/**
* addProcess
*/
 private boolean addProcess (Process p) {
 	try {
	_PROCESSES.put(new Integer(p.getPID()),p); 	
		return true;
	} catch (Exception e) {
		_PRINTER.print(-1,"Error starting process.\n");
		return false;
	}
}

/**
* removeProcess
*/
 public boolean removeProcess (Integer pid) {
 	try {
	_PROCESSES.remove(pid); 	
		return true;
	} catch (Exception e) {
		_PRINTER.print(-1,"Error deleting process.\n");
		return false;
	}
}

/**
* getProcessTable
*/
 public Hashtable getProcessTable () { 	
	return _PROCESSES; 	
 }

/**
* log
*/
public boolean log (int loglevel, String message) {
	return _LOG.log(loglevel,message);
}

/**
* print
*/
public void print (int flag, String message) {
	 _PRINTER.print(flag,message);
}


/**
* setDBConnection
*/
public void setDBConnection (Connection conn) {
	this._DBCONNECTION = conn;	
}

/**
* getDBConnection
*/
public Connection getDBConnection () {
	return this._DBCONNECTION;	
}

/**
* setDBOperations
*/
public void setDBOperationsInterface (DBOperationsInterface dbo) {
	this._DBOPERATIONS_INTERFACE = dbo;	
}

/**
* getDBOperations
*/
public DBOperationsInterface getDBOperationsInterface () {
	return this._DBOPERATIONS_INTERFACE;	
}

/**
* readData
* @param String filename
* @param String[] elements
* @return Hashtable
*/
public Hashtable readData (String filename, String[] elements) {
	return this._XML_READER.initParse(filename,elements);
}

/**
* readData
* @param String filename
* @param String field
* @return Hashtable
*/
public Vector readData (String filename,String field) {
	return this._XML_READER.initParse(filename,field);
}
}//end kernel