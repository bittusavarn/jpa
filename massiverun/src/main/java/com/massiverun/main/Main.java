package com.massiverun.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.massiverun.constants.PreCacheCriteria;
import com.mysql.jdbc.Driver;
 
/**
 * 
 * @author Nilamber Kumar
 * Config test MAin Class
 */
public class Main {

	public static void main(String ar[]){
     
	  //ApplicationContext appContext =   
      //new ClassPathXmlApplicationContext("context/beans.xml");
	  //PreCacheCriteria prec=(PreCacheCriteria)appContext.getBean("testClass");
	  //InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("new2.txt");
	  //try
	  //{
			//new PreCacheCriteria().loadPreCacheCriteria(is);
	  //} catch (Exception e){
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		//Connection con=DriverManager.getConnection("com.mysql.jdbc");;
		AW1 aw=new AW1();
		aw.setName("Nilamber Kumar");
		System.out.println("Name="+aw.getName());
	}
	private transient int e;
	
	public static void test(A a)
	{
		A b=new A("Nil");
		a=b;
	}
	
	
	public static class A
	{
		public A(String t)
		{
			a=t;
		}
		public String a;
		
	}
	
}	



