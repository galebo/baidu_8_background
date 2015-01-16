package com.galebo;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.galebo.TestLiCai.LiCai.Data;

public class TestLiCai {
	public static class LiCai{
		public static class Data {
            int progress;//": 100,
            String title;//"家多宝9号-150107003"
            int loanPeriod;
			public int getLoanPeriod() {
				return loanPeriod;
			}
			public void setLoanPeriod(int loanPeriod) {
				this.loanPeriod = loanPeriod;
			}
			public int getProgress() {
				return progress;
			}
			public void setProgress(int progress) {
				this.progress = progress;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
		}
		List<Data> data;
		public List<Data> getData() {
			return data;
		}
		public void setData(List<Data> data) {
			this.data = data;
		}
	}
	public static void main(String[] args) {
		int i=1;
		while(i++<60){
			String json = HttpTookit.doGet(null, "https://licai.lianjia.com/manageMoney/sort?sortType=0&page=1&num=5&t=HefHEmjj");
			//System.out.println(json);
			
			LiCai liCai=JSON.parseObject(json, LiCai.class);
			for (Data data : liCai.getData()) {
				if (data.getProgress()<100) {
					System.out.println("hava"+data.getTitle());
					if (data.getLoanPeriod()==1) {
						System.out.println("hava1"+data.getTitle());
					}
				}
			}
			try {
				Thread.sleep(1000*60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
