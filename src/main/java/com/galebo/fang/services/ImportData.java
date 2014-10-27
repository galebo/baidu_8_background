package com.galebo.fang.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.alibaba.fastjson.JSON;
import com.galebo.fang.models.Summery;
import com.galebo.fang.models.Summery.Fang;

public class ImportData {
	public static void main(String[] args) {
		String all="223	319	343	247	40	374	382	375	464	323	90	88	533	511	626	562	0	0	70";
		String zhuzhai="190	282	331	214	32	309	328	321	398	226	38	45	466	458	554	509	0	0	63";
		String[] alls = all.split("\t");
		String[] zhuzhais = zhuzhai.split("\t");
		
		for (int i = 0; i < alls.length; i++) {

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH,i-alls.length);
			String date = sdf.format( calendar.getTime());
			Summery summery=new Summery();
			{
				Fang fang=new Fang();
				fang.setCunLiangFang(Integer.valueOf(alls[i]));
				summery.setAllFang(fang);
			}
			{
				Fang fang=new Fang();
				fang.setCunLiangFang(Integer.valueOf(zhuzhais[i]));
				summery.setZhuZhai(fang);
			}
			summery.setDate(date);
			System.out.println("insert into `data`(`type`,`key`,`json`) values (1,'"+date+"','"+JSON.toJSONString(summery)+"');");
		}
	}
	
}
