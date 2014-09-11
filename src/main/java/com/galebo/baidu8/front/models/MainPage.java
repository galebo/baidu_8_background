package com.galebo.baidu8.front.models;

import java.util.List;

import com.galebo.baidu8.front.models.Common.Operator;
import com.galebo.baidu8.front.models.Common.Operator.Privance;
import com.galebo.baidu8.front.models.Common.Operator.Privance.Room;

public class MainPage {
	List<Operator> operators;
	List<Room> rooms;
	List<Recommend> recommends;
	List<Privance> privances;
	
	public List<Recommend> getRecommends() {
		return recommends;
	}
	public void setRecommends(List<Recommend> recommends) {
		this.recommends = recommends;
	}
	public List<Privance> getPrivances() {
		return privances;
	}
	public void setPrivances(List<Privance> privances) {
		this.privances = privances;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public List<Operator> getOperators() {
		return operators;
	}
	public void setOperators(List<Operator> operators) {
		this.operators = operators;
	}
	public static class Recommend{
		String img;
		String url;
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	}
}
