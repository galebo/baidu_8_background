package com.galebo.baidu8.front.models;

import java.util.ArrayList;
import java.util.List;

public class Home {
	public static class Banner{
		String img;
		String url;
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	}
	List<Banner> banners=new ArrayList<Banner>();
	public List<Banner> getBanners() {
		return banners;
	}
	public void setBanners(List<Banner> banners) {
		this.banners = banners;
	}
}
