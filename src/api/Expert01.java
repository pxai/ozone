package com.javamercenary.ai.inferenczy.api;

/**
 * T�tulo:       API for Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
 import java.io.Serializable;
 import java.util.Hashtable;

 
 public class Expert01 
 extends RuleSet
 implements Serializable { 	
 	
 	/**
 	* RULE Attributes
 	*/
 	
 	/**
 	* constructor
 	*/
 	public Expert01 () {
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
	* rule1
	*/
	public int rule1 () {
		return 1;
	}

	/**
	* rule2
	*/
	public int rule2 () {
		return 2;
	}

	/**
	* rule3
	*/
	public int rule3 (Object o) {
		return 3;
	}

	/**
	* rule4
	*/
	public int rule4 (Object o1, Object o2) {
		return 4;
	}

	/**
	* Fire
	* a big switch to decide what actions must be taken.
	*/
	public void Fire (int ruleID) {		
		switch (ruleID) {
			case 1 : RHS_rule1();
				break;			
			case 2 : RHS_rule2();
				break;			
			case 3 : RHS_rule3();
				break;			
			case 4 : RHS_rule4();
				break;			
			default:
				break;
		}
	}
	
	/**
	* RHS_rule1
	*/
	public int RHS_rule1 () {
		return 1;
	}

	/**
	* RHS_rule2
	*/
	public int RHS_rule2 () {
		return 1;
	}

	/**
	* RHS_rule3
	*/
	public int RHS_rule3 () {
		return 1;
	}

	/**
	* RHS_rule4
	*/
	public int RHS_rule4 () {
		return 1;
	}

}//end kernel