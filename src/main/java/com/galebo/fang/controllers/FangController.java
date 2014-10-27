package com.galebo.fang.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galebo.fang.services.DataGetter;

@Controller
public class FangController {
	static Logger log=Logger.getLogger(FangController.class);
	@Autowired
	DataGetter dataGetter;
	
	@RequestMapping("/j_getFang")
	@ResponseBody
    public String j_getFang()  {
		dataGetter.exe();
		return "ok";
    }
}
