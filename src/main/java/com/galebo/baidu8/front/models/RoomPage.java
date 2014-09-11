package com.galebo.baidu8.front.models;

import org.apache.commons.beanutils.BeanUtils;

import com.galebo.baidu8.front.models.Common.Operator.Privance;
import com.galebo.baidu8.front.models.Common.Operator.Privance.Room;

public class RoomPage extends Room{
	String rooms;
	Privance privance;
	public RoomPage(Room room) {
		try {
			BeanUtils.copyProperties(this, room);
			this.pics=room.getPics();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public RoomPage() {
	}
	public String getRooms() {
		return rooms;
	}
	public Privance getPrivance() {
		return privance;
	}
	public void setPrivance(Privance privance) {
		this.privance = privance;
//		url=(Common.getRoomUrl(privance.getId()));
	}

/*	List<Operator> operators;
	public List<Operator> getOperators() {
		return operators;
	}
	public void setOperators(List<Operator> operators) {
		this.operators = operators;
		rooms=(JSONObject.toJSONString(operators));
	}*/
}
