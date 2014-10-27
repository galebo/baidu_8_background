package com.galebo.fang.services;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
@Service("dataGetter")
public class DataGetter {
	static Logger log=Logger.getLogger(DataGetter.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	private String sendHttp(String url){
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		//method.setRequestHeader("Content-Type", "text/html;charset=utf-8");
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
			//e.printStackTrace();
			throw new RuntimeException("网络异常");
		}
	}
	class Fang{
		int qiFang;
		int xianFang;
		int cunLiangFang;
		String date;
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getQiFang() {
			return qiFang;
		}
		public void setQiFang(int qiFang) {
			this.qiFang = qiFang;
		}
		public int getXianFang() {
			return xianFang;
		}
		public void setXianFang(int xianFang) {
			this.xianFang = xianFang;
		}
		public int getCunLiangFang() {
			return cunLiangFang;
		}
		public void setCunLiangFang(int cunLiangFang) {
			this.cunLiangFang = cunLiangFang;
		}
	}
	public void exe(){
		DataGetter dataGetter=new DataGetter();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String date = sdf.format( calendar.getTime());
		Fang fang=new Fang();
		fang.cunLiangFang=Integer.valueOf(dataGetter.find(date,"存量房网上签约","网上签约套数"));
		fang.xianFang=Integer.valueOf(dataGetter.find(date,"现房网上签约","网上签约套数"));
		fang.qiFang=Integer.valueOf(dataGetter.find(date,"期房网上签约","网上签约套数"));
		fang.setDate(date);
		jdbcTemplate.update("insert into data (`key`,`type`,`json`)values(?,?,?)",new Object[]{date,"1",JSON.toJSONString(fang)});
	}
	private String find(String date,String big,String big2){
		String table=null;
		String html=null;
		{
			html=null;
			while(html==null){
				try {
					html = sendHttp("http://www.bjjs.gov.cn/tabid/2167/default.aspx");
				} catch (Exception e) {
					//e.printStackTrace();
				}
			};
			html = html.replaceAll(" ", "").replaceAll("\r", "").replaceAll("\n", "");
		}
		{
			int tableStart =indexOf(html,date+"</span>"+big+"</td");
			int tableEnd = indexOf(html,"</table>",tableStart);
			table=html.substring(tableStart, tableEnd);
		}
		{
			int start = indexOf(table,big2);
			start = indexOf(table,"<span",start);
			start = indexOf(table,">",start+6);
			int end = indexOf(table,"</span>",start);
			log.info(date+big+":"+table.substring(start+1, end));
			return table.substring(start+1, end);
		}
	}
	private int indexOf(String str,String find){
		int indexof=str.indexOf(find);
		if(indexof==-1)
			throw new RuntimeException("无此数据");
		return indexof;
	}
	private int indexOf(String str,String find,int start){
		int indexof=str.indexOf(find,start);
		if(indexof==-1)
			throw new RuntimeException("无此数据");
		return indexof;
	}
	public static void main(String[] args) {
		DataGetter dg=new DataGetter();
		dg.exe();
	}
}
