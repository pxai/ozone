package com.javamercenary.ai.inferenczy.api;

/**
 * Título:       API for Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
 import java.io.Serializable;
 import java.util.Hashtable;

 
 public abstract class RuleSet implements Serializable {
 	
 	/**
 	* RULE Attributes
 	*/
 	private Hashtable RULESET = new Hashtable();
 	
 	/**
 	* constructor
 	*/
 	public RuleSet () {
	}

	/**
	* inits RHS hashtable.
	*/
	public void init () {
	}

	/**
	* matchRule
	*/
	public int matchRule () {
		return 1;
	}
	
	/**
	* Fire
	* a big switch to decide what actions must be taken.
	*/
	public void Fire (int ruleID) {		
	}
	

}//end kernel