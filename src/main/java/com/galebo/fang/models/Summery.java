package com.galebo.fang.models;

import java.util.ArrayList;
import java.util.List;


public class Summery{
	public static class Data{
		String key;
		String json;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getJson() {
			return json;
		}
		public void setJson(String json) {
			this.json = json;
		}
	}
	public static class Zhus{
		public static class Zhu{
			String date;
			int count;
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}
			public int getCount() {
				return count;
			}
			public void setCount(int count) {
				this.count = count;
			}
		}
		List<Zhu> datas=new ArrayList<Zhu>();
		public List<Zhu> getDatas() {
			return datas;
		}
	}
	 public static class Fang{
			int qiFang;
			int xianFang;
			int cunLiangFang;
			public int getQiFang() {
				return qiFang;
			}
			public void setQiFang(int qiFang) {
				this.qiFang = qiFang;
			}
			public int getXianFang() {
				return xianFang;
			}
			public void setXianFang(int xianFang) {
				this.xianFang = xianFang;
			}
			public int getCunLiangFang() {
				return cunLiangFang;
			}
			public void setCunLiangFang(int cunLiangFang) {
				this.cunLiangFang = cunLiangFang;
			}
		}
	Fang zhuZhai;
	Fang allFang;
	public Fang getZhuZhai() {
		return zhuZhai;
	}
	public void setZhuZhai(Fang zhuZhai) {
		this.zhuZhai = zhuZhai;
	}
	public Fang getAllFang() {
		return allFang;
	}
	public void setAllFang(Fang allFang) {
		this.allFang = allFang;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	String date;
}

