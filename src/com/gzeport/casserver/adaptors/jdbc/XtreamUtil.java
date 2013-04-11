package com.gzeport.casserver.adaptors.jdbc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;

import com.gzeport.logistics.common.util.StringHelp;
import com.thoughtworks.xstream.XStream;
 

public class XtreamUtil {
	
	
	/**
	 * 
	 * @param xStream
	 * @param ownerType
	 */
	public static void parseAliasUpper(XStream xStream  ,java.lang.Class ownerType ){
	
//		Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1)
		
		if(ownerType!=null){
		   String className=ownerType.getSimpleName();
//			System.out.println("className="+className);
//			xStream.alias(className, ownerType);
			Field  [] fields =ownerType.getDeclaredFields();
			  for( Field field: fields){
					String fieldName=field.getName();
//					System.out.println("fieldName="+fieldName);
					String aliasFieldName=fieldName;
					if(aliasFieldName!=null&&aliasFieldName.length()>=1){
//						String firstChar=aliasFieldName.substring(0,1);
//						String upperChar= StringHelp.toUpperString(firstChar);
////						System.out.println("firstChar="+firstChar+",upperChar="+upperChar);
////						aliasFieldName.replace(aliasFieldName.substring(0,1), StringHelp.toUpperString(aliasFieldName.substring(0,1)));
//						aliasFieldName=aliasFieldName.replaceFirst(firstChar, upperChar);
						aliasFieldName=Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
//						System.out.println("aliasFieldName="+aliasFieldName);
						xStream.aliasField(aliasFieldName, ownerType,fieldName);
					}
					
					}
		}
	
		
	}
	
	/**
	 * 
	 * @param ownerType
	 */
	public static void parseFieldAliasUpper(java.lang.Class ownerType ){
		Field  [] fields =ownerType.getDeclaredFields();
	  for( Field field: fields){
		String fieldName=field.getName();
//		System.out.println("fieldName="+fieldName);
		String aliasFieldName=fieldName;
		if(aliasFieldName!=null&&aliasFieldName.length()>=1){
			String firstChar=aliasFieldName.substring(0,1);
			String upperChar= StringHelp.toUpperString(firstChar);
//			System.out.println("firstChar="+firstChar+",upperChar="+upperChar);
//			aliasFieldName.replace(aliasFieldName.substring(0,1), StringHelp.toUpperString(aliasFieldName.substring(0,1)));
			aliasFieldName=aliasFieldName.replaceFirst(firstChar, upperChar);
//			System.out.println("aliasFieldName="+aliasFieldName);
		}
		}
	}
	
	/**
	 * 
	 * @param fieldName
	 * @return
	 */
	public static String  parseFieldAliasUpper(String fieldName){
		String aliasFieldName=fieldName;
		if(aliasFieldName!=null&&aliasFieldName.length()>=1){
			String firstChar=aliasFieldName.substring(0,1);
			String upperChar= StringHelp.toUpperString(firstChar);
			System.out.println("firstChar="+firstChar+",upperChar="+upperChar);
//			aliasFieldName.replace(aliasFieldName.substring(0,1), StringHelp.toUpperString(aliasFieldName.substring(0,1)));
			aliasFieldName=aliasFieldName.replaceFirst(firstChar, upperChar);
			System.out.println("aliasFieldName="+aliasFieldName);
			
		}
		return aliasFieldName;
	}
	
	/**
	 * 
	 * @param filePath
	 * @param xs
	 * @param ownerType
	 */
	public static void makeXMLFile(String filePath,XStream xs,Object  ownerType){
		FileOutputStream outputStream=null;
//		parseAliasUpper(xs  ,ownerType);
		Writer writer=null;
		try {
			  outputStream = new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(outputStream!=null){
			try {
				  writer = new OutputStreamWriter(outputStream, "UTF-8");
				  try {
					writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(writer!=null){
				 xs.toXML(ownerType, writer); 
			}
		}
		 
	}
}
