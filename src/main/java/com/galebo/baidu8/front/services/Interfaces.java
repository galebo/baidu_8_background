package com.galebo.baidu8.front.services;

import com.galebo.baidu8.front.models.MainPage;
import com.galebo.baidu8.front.models.RoomPage;
import com.galebo.baidu8.front.models.Common.Operator.Privance;

public interface Interfaces {
	public interface IPageBeanCreator {

		public RoomPage getRoom(Long id);
		public RoomPage getRoom_Privance(String name);

		public Privance getPrivance(Long id, boolean isAddSubCompany);

		public MainPage getMain();
	}

}
