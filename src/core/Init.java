package com.javamercenary.ai.inferenczy.core;

/**
 * Título:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
 import java.util.Vector;

 public class Init extends Process {

 	
 	/**
 	* method
 	*/
 	public Init () {
 		super();
 	}

	public Init (int PID,int UID,int GID,int STATE,int PRIORITY, String P_INFO, SystemInterface _SI) {
		super(PID,UID,GID,STATE,PRIORITY,P_INFO, _SI);
	}
	
	/**
	* run  method
	*/
	public void run () {
		get_SI().log(1,"<Init> Init started. [pid: "+this.getPID()+"]");
		loadProcesses();
		while (true) {
		}
	}

	/**
	* loadProcesses
	* load processes from init.d
	*/
	private boolean loadProcesses () {
		String line = "";
		int cont = 2;
		boolean errors = false;
		Vector vclasses = null;
		
		try {
		vclasses = get_SI().readData(get_SI().getProperty("init.d"),"CLASSNAME");
		for (int i = 0;i<vclasses.size();i++) {
			get_SI().log(1,"<Init> Loading "+vclasses.elementAt(i)+"... ");
			if (get_SI().startProcess((String)vclasses.elementAt(i),cont++,1,1,1,1,line) < 0)
				errors = true;
		}
		if (errors)
			get_SI().log(1,"<Init> Init finished with errors. Check init.d file.");
		else
			get_SI().log(1,"<Init> Init completed succesfully.");
		return true;	
		} catch (Exception e) {
	    	    get_SI().log(1,"Failed loadin properties .Error: "+e.getMessage());
		    return false;
		}
	}
 }