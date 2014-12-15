package com.galebo.fang;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.galebo.fang.services.DataGetter;

public class Fang {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"applicationContext-resources.xml"});
//		Statics bean= (Statics) ac.getBean("statics"); 
		DataGetter bean= (DataGetter) ac.getBean("dataGetter"); 
		bean.exe();
	}
}
