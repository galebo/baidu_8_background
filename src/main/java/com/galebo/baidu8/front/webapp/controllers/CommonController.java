package com.galebo.baidu8.front.webapp.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galebo.web.common.ExceptionHandler;
import com.galebo.web.common.Message;

@Controller(value="commonController")
public class CommonController {
	private static final Log log = LogFactory.getLog(PublicController.class) ;
	private static final ExceptionHandler exceptionHandler = new ExceptionHandler(log) ;
	@Autowired
	private ResourceBundleMessageSource messageSource ;

	@org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
	public Object errorPage(Exception ex, HttpServletRequest request, HttpServletResponse res) {
		exceptionHandler.handleNoThrowNew(ex);
		res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return "error2"; 
	}
	@RequestMapping(value="/version",method = RequestMethod.GET)
	@ResponseBody
	public Object getVersion()  {
		return new Message(0, messageSource.getMessage("webapp.version", new Object[]{}, Locale.CHINA));
	}
}
