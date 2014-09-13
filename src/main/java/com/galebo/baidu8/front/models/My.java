package com.galebo.baidu8.front.models;

import java.util.List;

public class My {
	public static class ShouYis{
		List<ShouYi> shouYis;

		public List<ShouYi> getShouYis() {
			return shouYis;
		}

		public void setShouYis(List<ShouYi> shouYis) {
			this.shouYis = shouYis;
		}
	}
	static public class ShouYi {
		String name;// =[json objectForKey:@"name"];
		public ShouYi(String name, String date, String money, String type) {
			super();
			this.name = name;
			this.date = date;
			this.money = money;
			this.desc = type;
		}
		String date;// =[json objectForKey:@"date"];
		String money;// =[json objectForKey:@"money"];
		String desc;// =[json objectForKey:@"type"];
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getMoney() {
			return money;
		}
		public void setMoney(String money) {
			this.money = money;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String type) {
			this.desc = type;
		}
	}
}
