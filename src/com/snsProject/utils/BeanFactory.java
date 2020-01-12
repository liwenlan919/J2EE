package com.snsProject.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory {
	 private static ClassPathXmlApplicationContext ctx=null;
	 static {
		  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	 }
    public static Object getBean(String name) {
		return ctx.getBean(name);
	} 
    public static <T> T  getBean(String name , Class<T> cla) {
    	return ctx.getBean(name,cla);
	}
	public static void close(){
		if(ctx!=null){
			ctx.close();
		}
		
	}
	
}
