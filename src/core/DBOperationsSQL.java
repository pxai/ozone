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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class DBOperationsSQL  implements DBOperationsInterface {

	/**
	* attributes
	*/
	private Connection conn = null;
	private SystemInterface _SI = null;
	
	public DBOperationsSQL (SystemInterface _SI) {
		this.conn = _SI.getDBConnection();
		this._SI = _SI;
	}

	/**
	* method implementation
	*/
	public com.javamercenary.ai.inferenczy.core.ResultSet selectData (String select) {
		Statement stmnt = null;
		com.javamercenary.ai.inferenczy.core.ResultSet rs = new com.javamercenary.ai.inferenczy.core.ResultSet();
		java.sql.ResultSet sqlrs = null;
		ResultSetMetaData rsmd = null;
		Vector v = new Vector();
	 try {
	 	stmnt = conn.createStatement();
	 	sqlrs = stmnt.executeQuery(select);
	 	rsmd = sqlrs.getMetaData();
	 	int c = rsmd.getColumnCount();
	 	for (int j = 1;j<=c;j++)
 			rs.put(rsmd.getColumnName(j),new Vector());
 			
	 	while (sqlrs.next()) 
	 		for (int j = 1;j<=c;j++) {
	 			v = (Vector)rs.get(rsmd.getColumnName(j));
	 			v.addElement(sqlrs.getObject(rsmd.getColumnName(j)));
	 			rs.put(rsmd.getColumnName(j),v);
			}
			
	 	_SI.log(2,"<DBOperationsSQL> SQL ResultSet to generic ResultSet Mapping complete.");
		 	
	 } catch (Exception sqle) {
	 	_SI.log(1,"<DBOperationsSQL> Error on sql select: "+select+" .Message:"+sqle.getMessage());
		return null;	
         }
	 	_SI.log(1,"<DBOperationsSQL> SQL SELECT successful: "+select);
		return rs;
	}
	
	/**
	* insertData
	* method implementation
	*/
	public int insertData (String insert) {
		Statement stmnt = null;
	 try {
	 	stmnt = conn.createStatement();
	 	stmnt.executeUpdate(insert);
	 } catch (SQLException sqle) {
	 	_SI.log(1,"<DBOperationsSQL> Error on sql insert: "+insert+" .Message:"+sqle.getMessage());
		return -1;	
         }
	 	_SI.log(1,"<DBOperationsSQL> SQL INSERT successful: "+insert);
		return 0;
	}
	
	/**
	* updateData
	* method implementation
	*/
	public int updateData (String update) {
		Statement stmnt = null;
	 try {
	 	stmnt = conn.createStatement();
	 	stmnt.executeUpdate(update);
	 } catch (SQLException sqle) {
	 	_SI.log(1,"<DBOperationsSQL> Error on sql update: "+update+" .Message:"+sqle.getMessage());
		return -1;	
         }
	 	_SI.log(1,"<DBOperationsSQL> SQL UPDATE successful: "+update);
		return 0;	
	}
	
	/**
	* deleteData
	* method implementation
	*/
	public int deleteData (String delete) {
		Statement stmnt = null;
	 try {
	 	stmnt = conn.createStatement();
	 	stmnt.executeUpdate(delete);
	 } catch (SQLException sqle) {
	 	_SI.log(1,"<DBOperationsSQL> Error on sql deletion: "+delete+" .Message:"+sqle.getMessage());
		return -1;	
         }
	 	_SI.log(1,"<DBOperationsSQL> SQL DELETE successful: "+delete);
		return 0;
	}
 	

 }// end DBOperations