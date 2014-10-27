package com.galebo.fang.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.galebo.fang.daos.FangDao;
import com.galebo.fang.models.Summery;
import com.galebo.fang.models.Summery.Data;

@Service("statics")
public class Statics {
	@Autowired
	FangDao fangDao;
	public void exe(){
		List<Data> datas = fangDao.getDatas();
		for (Data data : datas) {
			String json = data.getJson();
			Summery sum=JSONObject.parseObject(json, Summery.class);
			System.out.println(sum.getAllFang().getCunLiangFang());
		}
	}
}
