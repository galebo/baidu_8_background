package com.galebo.fang.models;


public class Summery{
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

