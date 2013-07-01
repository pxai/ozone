package com.javamercenary.ai.inferenczy.inferenceengine;

/**
 * Título:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */

import com.javamercenary.ai.inferenczy.api.RuleSet;
 
 public class InferenceEngine extends Thread {
 	
 	/**
 	* InferenceEngine Attributes
 	*/
 	private String EXPERT_SYSTEM = "";
	private Object O = null;
	
 	/**
 	* constructor
 	*/
 	public InferenceEngine () {
 		init();
	}

 	/**
 	* constructor
 	*/
 	public InferenceEngine (String EXPERT_SYSTEM) {
 		this.EXPERT_SYSTEM = EXPERT_SYSTEM;
 		init();
	}
	
	/**
	* init
	*/
	private void init () {
		try {
		O = Class.forName(EXPERT_SYSTEM).newInstance();
		} catch (ClassNotFoundException cnfe) {
		} catch (InstantiationException ie) {
		} catch (IllegalAccessException iae) {
		}
	}
	/**
	* run
	*/
	public void run () {
		((RuleSet)O).matchRule();
	}
}//end InferenceEngine