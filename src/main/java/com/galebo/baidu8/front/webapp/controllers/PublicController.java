package com.galebo.baidu8.front.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galebo.baidu8.front.models.Product;

@Controller
public class PublicController {
	static Logger log=Logger.getLogger(PublicController.class);

	
	@RequestMapping("/j_room")
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


	
	
}
