package com.galebo;


import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;



public final class HttpTookit { 
    private static Logger log = Logger.getLogger(HttpTookit.class); 

    /** 
     * 执行一个HTTP GET请求，返回请求响应的HTML 
     * 
     * @param url                 请求的URL地址 
     * @return 返回请求响应的HTML 
     */ 
	public static String doGet(Logger logger, String url) {
		if (logger == null)
			logger = log;
		String response = null;
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		try {
			HttpConnectionManagerParams params = client.getHttpConnectionManager().getParams();
			params.setConnectionTimeout(1000 * 10);// 连接超时
			params.setSoTimeout(1000 * 60*3);// 读数据超时
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				response =IOUtils.toString(method.getResponseBodyAsStream());
			} else {
				logger.error("执行HTTP Get请求" + url + "时，发生异常！" + method.getResponseBodyAsString());
			}
		} catch (IOException e) {
			logger.error("执行HTTP Get请求" + url + "时，发生异常！", e);
		} finally {
			method.releaseConnection();
		}
		return response;
	} 
    
	
}
