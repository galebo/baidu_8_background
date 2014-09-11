package com.galebo.baidu8.front.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galebo.baidu8.front.services.Interfaces.IPageBeanCreator;

@Controller
public class PublicController {
	static Logger log=Logger.getLogger(PublicController.class);
	public static final String base = "/styles/template1/";

	@Autowired
	@Qualifier("beanCreator2")
	IPageBeanCreator PagebeanCreator;
	
	@RequestMapping("/j_room")
	@ResponseBody
    public Object getJroom(@RequestParam(required = true,value="id") Long id)  {
		List<Product> products=new ArrayList<Product>();
		Product player=new Product();
	    player.name = "百度利滚利版";
	    player.desc = "一元起购，即买即到，随用随取";
	    player.price = "4.654";
	    player.price10000 = "5";
	    player.bei = "34";
	    player.image="product.png";
	    player.shouyi="30.0元";
	    player.ziChan="10000";
	    products.add(player) ;
	    player =new Product();
	    player.name = "百赚";
	    player.desc = "低风险，一元起购，随时买卖";
	    player.price = "4.387";
	    player.price10000 = "6";
	    player.bei = "35";
	    player.image="button.png";
	    player.shouyi="31.0元";
	    player.ziChan="20000";
	    products.add(player) ;
	    player =new Product();
	    player.name = "百发";
	    player.desc = "团结就有8%，理财周期30天";
	    player.price = "7.859";
	    player.price10000 = "7";
	    player.bei = "36";
	    player.image="product.png";
	    player.shouyi="32.0元";
	    player.ziChan="30000";
	    products.add(player) ;
	    player =new Product();
	    player.name = "百度理财B";
	    player.desc = "低风险，一元起购，随时买卖";
	    player.price = "4.387";
	    player.price10000 = "8";
	    player.bei = "37";
	    player.image="button.png";
	    player.shouyi="33.0元";
	    player.ziChan="40000";
	    products.add(player) ;
		return  products;
    }

	static public class  Product{
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
	
	
}
