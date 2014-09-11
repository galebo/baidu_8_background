package com.galebo.baidu8.front.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.galebo.baidu8.front.models.Home;
import com.galebo.baidu8.front.models.Home.Banner;
import com.galebo.baidu8.front.services.Interfaces.IPageBeanCreator;
@Service("beanCreator")
public class PagebeanCreator implements IPageBeanCreator{
	public Home getHome(){
		Home home=new Home();
		ArrayList<Banner> banners = new ArrayList<Home.Banner>();
		Banner banner = new Banner();
		banner.setImg("http://localhost:8080/images/banner1.png");
		banner.setUrl("http://localhost:8080/images/banner1.png");
		banners.add(banner);
		banner = new Banner();
		banner.setImg("http://localhost:8080/images/banner2.png");
		banner.setUrl("http://localhost:8080/images/banner1.png");
		banners.add(banner);
		banner = new Banner();
		banner.setImg("http://localhost:8080/images/banner3.png");
		banner.setUrl("http://localhost:8080/images/banner1.png");
		banners.add(banner);
		home.setBanners(banners);
		return home;
	}
}
