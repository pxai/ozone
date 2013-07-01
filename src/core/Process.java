package com.javamercenary.ai.inferenczy.core;

/**
 * Título:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
 
 public abstract class Process extends Thread {
 
 	/**
 	* attributes
 	*/
 	private int PID = -1 ;
 	private int UID = 0;
 	private int GID = 0;
 	private int STATE = 0;
 	private int PRIORITY = 0;
 	private String P_INFO = "";
 	private long START_DATE;
 	private SystemInterface _SI = null;
 	
 	/**
 	* constructors
 	*/
 	public Process () {
 		this.START_DATE = System.currentTimeMillis();
	}

 	public Process (int PID,int UID,int GID,int STATE,int PRIORITY, String P_INFO, SystemInterface _SI) {
 		this.PID = PID;
 		this.UID = UID;
 		this.GID = GID;
 		this.PID = PID;
 		this.PRIORITY = PRIORITY;
 		this.P_INFO = P_INFO;
 		this._SI = _SI;
	}

 	public boolean setAttributes (int PID,int UID,int GID,int STATE,int PRIORITY, String P_INFO, SystemInterface _SI) {
 		if (PID == -1) return false;
 		
 		this.PID = PID;
 		this.UID = UID;
 		this.GID = GID;
 		this.PID = PID;
 		this.PRIORITY = PRIORITY;
 		this.P_INFO = P_INFO;
 		this._SI = _SI;
 		return true;
	}

 	public  int getPID (){
 		return PID;
 	}
 	 	
 	public  int getUID () {
 		return UID;
 	}
 	
 	public  int getGID () {
 		return GID;
 	}
 	
 	public  int getSTATE () {
 	 	return STATE;
	}
	
 	public  int setSTATE (int state) {
 		return STATE = state;
 	}
 	
	public  int getPRIORITY () {
 		return PRIORITY;
	}
	
	public  int setPRIORITY(int priority) {
		return PRIORITY = priority;
	}
	
	public  long getSTART_DATE() {
		return START_DATE;
	}
	
	public  String getP_INFO () {
		return P_INFO;
	}
	
	public  SystemInterface get_SI () {
		return _SI;
	}
		
	public  String setP_INFO(String p_info) {
		return P_INFO = p_info;	
	}
 }