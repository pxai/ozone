package com.javamercenary.ai.inferenczy.core;

/**
 * Título:       Inference Engine
 * Descripcion:
 * Copyright:    Copyright (c) 2001
 * Empresa:
 * @author P. Al.
 * @version 1.0
 */
 
import org.w3c.dom.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import com.sun.xml.tree.XmlDocumentBuilder;
import com.sun.xml.parser.Parser;
import com.sun.xml.parser.Resolver;
import org.xml.sax.InputSource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.sun.xml.tree.XmlDocument;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Vector;

public class SystemXMLReader {

/**
* Attributes
*/
  private Parser parser = new com.sun.xml.parser.Parser();
  private Document doc =  null;
  private XmlDocumentBuilder builder = new XmlDocumentBuilder();
  private NodeList nl = null;
  private SystemInterface _SI = null;
  

  public SystemXMLReader() {
  }

  
/**
* setProperties
*/
public void setProperties (SystemInterface _SI) {
	this._SI = _SI;
}

/**
* initParse
* @param String filename
* @param String[] elements
* @return Hashtable
*/
  public Hashtable initParse (String filename, String[] elements) {
    Element root = null;
    OutputStreamWriter out;
    Hashtable result = new Hashtable();
    
    // Loading Hashtable
    for (int i =0;i<elements.length;i++) 
    	result.put(elements[i],"");

      try {
       _SI.log(1,"<SystemXMLReader> Init "+filename+" parsing.");

       out = new OutputStreamWriter(System.out, "UTF8");
       builder.setParser(parser);
       parser.parse(new InputSource(new FileInputStream(filename)));
       _SI.log(1,"<SystemXMLReader> parsed.");
       doc =  builder.getDocument();
       NodeList element_list = null;
       Node node = null;

      	for (int i =0;i<elements.length;i++) {	
    		element_list = doc.getElementsByTagName(elements[i]);
       		result.put(elements[i],element_list.item(0).getFirstChild().getNodeValue());//element_list.item(0).getNodeValue());
 	       _SI.log(2,"<SystemXMLReader> Result "+result.toString());
    	}
	_SI.log(2,"Dump of hash: "+result.toString());

       return result;
      } catch (FileNotFoundException fnfe) {
        _SI.log(1,"<SystemXMLReader> File not found."+fnfe.getMessage());
      } catch (IOException ioex) {
        _SI.log(1,"<SystemXMLReader> Exception IO."+ioex.getMessage());
      } catch (SAXException se) {
        _SI.log(1,"<SystemXMLReader> Exception SAX."+se.getMessage());
      } catch (Exception e) {
        _SI.log(1,"<SystemXMLReader> Exception. "+e.getMessage());
      }  
       return null;
     }

/**
* initParse
* @param String filename
* @param String field
* @return Hashtable
*/
  public Vector initParse (String filename,String field) {
    Element root = null;
    OutputStreamWriter out;
    Vector result = new Vector();
    
      try {
       _SI.log(1,"<SystemXMLReader> Init "+filename+" parsing.");

       out = new OutputStreamWriter(System.out, "UTF8");
       builder.setParser(parser);
       parser.parse(new InputSource(new FileInputStream(filename)));
       _SI.log(1,"<SystemXMLReader> parsed.");
       doc =  builder.getDocument();
       NodeList element_list = null;
       Node node = null;

    		element_list = doc.getElementsByTagName(field);
      	for (int i =0;i<element_list.getLength();i++) {	
       		result.addElement(element_list.item(i).getFirstChild().getNodeValue());
 	       _SI.log(2,"<SystemXMLReader> Result "+result.toString());
    	}
	_SI.log(2,"Dump of vector: "+result.toString());

       return result;
      } catch (FileNotFoundException fnfe) {
        _SI.log(1,"<SystemXMLReader> File not found."+fnfe.getMessage());
      } catch (IOException ioex) {
        _SI.log(1,"<SystemXMLReader> Exception IO."+ioex.getMessage());
      } catch (SAXException se) {
        _SI.log(1,"<SystemXMLReader> Exception SAX."+se.getMessage());
      } catch (Exception e) {
        _SI.log(1,"<SystemXMLReader> Exception. "+e.getMessage());
      }  
       return null;
     }

  public static void main(String[] args) {
    SystemXMLReader pd = new SystemXMLReader();
    System.out.println("Pedro Alcazar> Iniciando SystemXMLReader");
  }

} // class SystemXMLReader