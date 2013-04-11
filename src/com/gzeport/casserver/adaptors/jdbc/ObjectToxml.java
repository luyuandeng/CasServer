package com.gzeport.casserver.adaptors.jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.gzeport.casserver.pojo.FuncModel;
import com.gzeport.casserver.pojo.UserCasInfo;
import com.thoughtworks.xstream.XStream;

public class ObjectToxml {
	public String change(Object obj, int count){
		  StringBuffer sb =new StringBuffer();
		  
		  try {
		   
		   String objname = obj.getClass().getName();
		   objname=objname.substring(objname.lastIndexOf(".")+1);
		   if(count==1){ 
		    sb.append("<?xml version='1.0' encoding='UTF-8'?>/n");
		    sb.append("<"+objname+">/n");
		    
		   }else{
		    sb.append("/t<"+objname+">/n");
		   }
		   System.out.println(obj.getClass().getName());
		   Class objclass = Class.forName(obj.getClass().getName());
		   
		   Field [] objfileds =objclass.getDeclaredFields();
		   
		   
		   for (Field field : objfileds) {
		    System.out.println(field.getType().getName()+""+field.getName());
		    String fieldname=field.getName();
		    String name="get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1);
		    
		    Method getobj = objclass.getMethod(name);
		   
		    
		    if("java.util.List".equals(field.getType().getName())){
		     Object o =getobj.invoke(obj);
		     
		     List list = (List) o;
		     count++;
		     for (Object object : list) {
		      sb.append(change(object,count));
		     }
		     
		     System.out.println(list.size());
		    }
		    else{
		     Object a = getobj.invoke(obj);
		     if(count==2&&a!=null){
		      sb.append("/t/t<"+fieldname+">"+a.toString()+"</"+fieldname+">/n");
		      System.out.println(a);
		     }else if(a!=null){
		      sb.append("/t<"+fieldname+">"+a.toString()+"</"+fieldname+">/n");
		      System.out.println(a);
		     }       
		    }  
		   }
		   if(count==2){
		    sb.append("/t</"+objname+">/n");
		    count--;
		    System.out.println("jjjjjjjjjjjjjjjjjjjjjj"+count);
		   }else{
		    
		    sb.append("</"+objname+">/n");
		   }
		   
		   
		  } catch (ClassNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (SecurityException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (NoSuchMethodException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IllegalArgumentException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IllegalAccessException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (InvocationTargetException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  return sb.toString();
		  
		 }
		 
		 public static void main(String[] args) {
			 UserCasInfo pm = new UserCasInfo();
			 pm.setUserInfo("liuyu#123456#刘宇");
			 pm.setCompanyInfo("gzeport#电子口岸");
		  FuncModel p = new FuncModel();
		   p.setFuncId("001");
		   p.setFuncName("用户管理系统");
		   
		   FuncModel p2 = new FuncModel();
		   p2.setFuncId("002");
		   p2.setFuncName("EDI系统");
		  List systemListl = new ArrayList<FuncModel>();
		  systemListl.add(p);
		  systemListl.add(p2);
		  pm.setSystemListl(systemListl);
 
//		  System.out.println(new ObjectToxml().change(pm,1));
		  XStream xs =new XStream();
		  
		  XtreamUtil.makeXMLFile("c:\\a.xml", xs, pm);
		  
		 }

}
