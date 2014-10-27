package com.galebo.fang;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.galebo.fang.services.Statics;

public class Fang {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"applicationContext-resources.xml"});
		Statics dg= (Statics) ac.getBean("statics"); 
		dg.exe();
	}
}
