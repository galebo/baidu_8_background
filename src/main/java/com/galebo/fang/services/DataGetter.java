package com.galebo.fang.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.galebo.fang.models.Summery;
import com.galebo.fang.models.Summery.Fang;

@Service("dataGetter")
public class DataGetter {
	static Logger log = Logger.getLogger(DataGetter.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	private String sendHttp(String url) {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		// method.setRequestHeader("Content-Type", "text/html;charset=utf-8");
		StringBuffer buf = new StringBuffer("");
		try {
			client.executeMethod(method);
			// 返回响应信息
			InputStream responseBody = method.getResponseBodyAsStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(responseBody, "utf-8"));
			String result = "";
			while ((result = reader.readLine()) != null) {
				buf.append(result);
			}
			method.releaseConnection();
			return buf.toString();
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException("网络异常");
		}
	}

	public void exe() {
		DataGetter dataGetter = new DataGetter();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String date = sdf.format(calendar.getTime());
		Summery summery = new Summery();
		String big2 = "网上签约套数：";
		String key = date;
		{
			Fang fang = new Fang();
			fang.setCunLiangFang(Integer.valueOf(dataGetter.find(key, "存量房网上签约", big2)));
			fang.setXianFang(Integer.valueOf(dataGetter.find(key, "现房网上签约", big2)));
			fang.setQiFang(Integer.valueOf(dataGetter.find(key, "期房网上签约", big2)));
			summery.setAllFang(fang);
		}
		big2 = "住宅套数";
		{
			Fang fang = new Fang();
			fang.setCunLiangFang(Integer.valueOf(dataGetter.find(key, "存量房网上签约", "住宅签约套数：")));
			fang.setXianFang(Integer.valueOf(dataGetter.find(key, "现房网上签约", big2)));
			fang.setQiFang(Integer.valueOf(dataGetter.find(key, "期房网上签约", big2)));
			summery.setZhuZhai(fang);
		}
		summery.setDate(key);
		insertData("1", key, JSON.toJSONString(summery));
		try {
			FileUtils.writeStringToFile(new File("bjjs"+date+".html"),getHtml(),"utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void insertData(String type, String key, String json) {
		jdbcTemplate.update("insert into data (`key`,`type`,`json`)values(?,?,?)", new Object[] { key, type, json });
	}

	private String find(String date, String big, String big2) {
		String table = null;
		String html = null;
		{
			html = getHtml();
			html = html.replaceAll(" ", "").replaceAll("\r", "").replaceAll("\n", "");
		}
		{
			int tableStart = indexOf(html, date + "</span>" + big + "</td");
			int tableEnd = indexOf(html, "</table>", tableStart);
			table = html.substring(tableStart, tableEnd);
		}
		{
			int start = indexOf(table, big2);
			if (start == -1)
				start = indexOf(table, big2);
			start = indexOf(table, "<span", start);
			start = indexOf(table, ">", start + 6);
			int end = indexOf(table, "</span>", start);
			log.info(date + big + ":" + table.substring(start + 1, end));
			return table.substring(start + 1, end);
		}
	}

	private String getHtml() {
		String html = null;
		int count = 50;
		while (html == null && count-- > 0) {
			try {
				html = sendHttp("http://www.bjjs.gov.cn/tabid/2167/default.aspx");
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		;
		return html;
	}

	private int indexOf(String str, String find) {
		int indexof = str.indexOf(find);
		if (indexof == -1)
			throw new RuntimeException(find + "无此数据");
		return indexof;
	}

	private int indexOf(String str, String find, int start) {
		int indexof = str.indexOf(find, start);
		if (indexof == -1)
			throw new RuntimeException(find + "无此数据");
		return indexof;
	}

}
