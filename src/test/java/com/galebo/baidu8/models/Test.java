package com.galebo.baidu8.models;

import java.lang.reflect.Method;

import com.galebo.baidu8.front.models.Home;
import com.galebo.baidu8.front.models.Product;


public class Test {
	
	public static void main(String[] args) {
	    printIOS( Home.class);
	    printIOS( Home.Banner.class);
	    printIOS( Product.class);
	}

	private static void printIOS(Class<?> class_) {
		StringBuffer sb=new StringBuffer();
	    
	    for (Method method: class_.getDeclaredMethods()) {
			String name = method.getName();
			if(name.startsWith("get")){
				name=(name.charAt(3)+"").toLowerCase()+name.substring(4);
				sb.append(""+name+"=[json objectForKey:@\""+name+"\"];\r\n");
			}
		}
		System.out.println(sb.toString());
	}
}
