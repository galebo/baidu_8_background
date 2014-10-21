package com.galebo.baidu8.front.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galebo.baidu8.front.models.Home;
import com.galebo.baidu8.front.models.Home.Banner;
import com.galebo.baidu8.front.models.My.ShouYi;
import com.galebo.baidu8.front.models.My.ShouYis;
import com.galebo.baidu8.front.models.Product;

@Controller
public class PublicController {
	static Logger log=Logger.getLogger(PublicController.class);

	
	@RequestMapping("/j_products")
	@ResponseBody
    public Object getJroom()  {
		List<Product> products=new ArrayList<Product>();
		Product player=new Product();
	    player.setName("百度利滚利版");
	    player.setDesc("一元起购，即买即到，随用随取");
	    player.setPrice("4.654");
	    player.setPrice10000("5");
	    player.setBei("34");
	    player.setImage("product.png");
	    player.setShouyi("30.0元");
	    player.setZiChan("10000");
	    products.add(player) ;
	    player =new Product();
	    player.setName("百赚");
	    player.setDesc("低风险，一元起购，随时买卖");
	    player.setPrice("4.387");
	    player.setPrice10000("6");
	    player.setBei("35");
	    player.setImage("button.png");
	    player.setShouyi("31.0元");
	    player.setZiChan("20000");
	    products.add(player) ;
	    player =new Product();
	    player.setName("百发");
	    player.setDesc("团结就有8%，理财周期30天");
	    player.setPrice("7.859");
	    player.setPrice10000("7");
	    player.setBei("36");
	    player.setImage("product.png");
	    player.setShouyi("32.0元");
	    player.setZiChan("30000");
	    products.add(player) ;
	    player =new Product();
	    player.setName("百度理财B");
	    player.setDesc("低风险，一元起购，随时买卖");
	    player.setPrice("4.387");
	    player.setPrice10000("8");
	    player.setBei("37");
	    player.setImage("button.png");
	    player.setShouyi("33.0元");
	    player.setZiChan("40000");
	    products.add(player) ;
		return  products;
    }
	@RequestMapping("/j_home")
	@ResponseBody
    public Object getJHome()  {
		Home home=new Home();
		ArrayList<Banner> banners = new ArrayList<Home.Banner>();
		Banner banner = new Banner();
		banner.setImg("http://107.170.199.9:9080/images/banner1.png");
		banner.setUrl("http://google.com");
		banners.add(banner);
		banner = new Banner();
		banner.setImg("http://107.170.199.9:9080/images/banner2.png");
		banner.setUrl("tel://555-1234");
		banners.add(banner);
		banner = new Banner();
		banner.setImg("http://107.170.199.9:9080/images/banner3.png");
		banner.setUrl("http://maps.google.com/maps?q=pizza");
		banners.add(banner);
		home.setBanners(banners);
		return home;
    }
	String[][] names=new String[][]{{"投钱","赎回","赎回","赎回"},{"收益","收益","收益","收益"},
			{"成功","成功","成功","失败"},{"建设银行","招商银行","建设银行","建设银行"}};
	@RequestMapping("/j_shouyi")
	@ResponseBody
    public ShouYis j_shuyi(@RequestParam(value="page")Integer page)  {
		return get(page,1);
    }
	@RequestMapping("/j_zhang")
	@ResponseBody
    public ShouYis j_zhuang(@RequestParam(value="page")Integer page)  {
		return get(page,0);
    }
	private ShouYis get(Integer page, int index) {
		ShouYis home=new ShouYis();
		ArrayList<ShouYi> shouYis = new ArrayList<ShouYi>();
		if(page<5){
			for (int i = 0; i < 10; i++) {
				shouYis.add(new ShouYi(names[index][i%4], "2010-09-"+((page+10)%30), ""+(3000+i+page*10), names[index+2][i%4]));
			}
		}
		home.setShouYis(shouYis);
		return home;
	}
	
}
