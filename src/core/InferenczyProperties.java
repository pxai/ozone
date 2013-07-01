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
import java.io.IOException;
import java.io.FileInputStream;

public class InferenczyProperties {

  /**
  * attributes
  */
  private final static Hashtable _PROPERTIES = new Hashtable();
  private final static String[] _PROPERTY_NAMES = new String[] {
    "system_version",
    "loglevel",
    "logfile",
    "db_type",
    "multiuser_y_n",
    "server_y_n",
    "language",
    "jdbc_driver",
    "jdbc_url",
    "jdbc_user",
    "jdbc_password",
    "init.d"
   };

/**
 * attributes
 */
  private String FILENAME = "Data/etc/inferenczy.properties";

/**
 * default constructor
 */
  public InferenczyProperties() {
  }

/**
 * default constructor
 */
  public InferenczyProperties(String FILENAME) {
    this.FILENAME = FILENAME;
  }

  public boolean loadProperties () {
        Properties defaults = new Properties();
        Properties properties = null;
        FileInputStream in = null;

        properties = new Properties(defaults);

	try {
            in = new FileInputStream(FILENAME);
	    properties.load(in);
            	System.out.println("Loading properties...");
            for (int i=0;i<_PROPERTY_NAMES.length;i++) {
            	_PROPERTIES.put(_PROPERTY_NAMES[i],properties.getProperty(_PROPERTY_NAMES[i]));
            	System.out.println(_PROPERTY_NAMES[i]+" : "+properties.getProperty(_PROPERTY_NAMES[i]));
            }
            in.close();
	    return true;

	} catch (java.io.FileNotFoundException e) {
	    in = null;
	    System.err.println("Can't find porperties file: "+FILENAME+ ".Error: "+e.getMessage());
		return false;
	} catch (java.io.IOException e) {
	    System.err.println("Can't read properties file: "+FILENAME+ ".Error: "+e.getMessage());
		return false;
	} catch (Exception e) {
	    System.err.println("Failed loadin properties .Error: "+e.getMessage());
		return false;
	}
  }

/**
 * getProperty
 */
 public String getProperty  (String property) {
 try {
  return (String)_PROPERTIES.get(property);
  } catch (Exception e) {
    return null;
  }
 }

 /**
 * setProperty
 */
 public boolean setProperty  (String property, String value) {
 try {
  _PROPERTIES.put(property, value);
  return true;
  } catch (Exception e) {
    return false;
  }
 }




}// end clase