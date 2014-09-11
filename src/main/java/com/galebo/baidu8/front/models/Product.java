package com.galebo.baidu8.front.models;

public class Product {
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice10000() {
		return price10000;
	}
	public void setPrice10000(String price10000) {
		this.price10000 = price10000;
	}
	public String getBei() {
		return bei;
	}
	public void setBei(String bei) {
		this.bei = bei;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getShouyi() {
		return shouyi;
	}
	public void setShouyi(String shouyi) {
		this.shouyi = shouyi;
	}
	public String getZiChan() {
		return ziChan;
	}
	public void setZiChan(String ziChan) {
		this.ziChan = ziChan;
	}
	String name       ;//"百度利滚利版";
    String desc       ;//"一元起购，即买即到，随用随取";
    String price      ;//= "4.654";
    String price10000 ;//= "5";
    String bei        ;//= "34";
    String image      ;//="product.png";
    String shouyi     ;//="30.0元";
    String ziChan     ;//="10000";
}
