package com.galebo.fang.services;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Service;
@Service("dateGetter")
public class DataGetter {

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
	public void exe(){
		DataGetter date=new DataGetter();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String format = sdf.format( calendar.getTime());
		
		System.out.println(format);
		System.out.println(date.find(format,"期房网上签约","网上签约套数"));
		System.out.println(date.find(format,"现房网上签约","网上签约套数"));
		System.out.println(date.find(format,"存量房网上签约","网上签约套数"));
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
