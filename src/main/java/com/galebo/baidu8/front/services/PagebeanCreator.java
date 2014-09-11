package com.galebo.baidu8.front.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.galebo.baidu8.front.models.Common;
import com.galebo.baidu8.front.models.MainPage;
import com.galebo.baidu8.front.models.RoomPage;
import com.galebo.baidu8.front.models.Common.Operator;
import com.galebo.baidu8.front.models.Common.Product;
import com.galebo.baidu8.front.models.Common.Operator.Privance;
import com.galebo.baidu8.front.models.Common.Operator.Privance.Room;
import com.galebo.baidu8.front.models.Common.Operator.Privance.SubCompany;
import com.galebo.baidu8.front.services.Interfaces.IPageBeanCreator;
@Service("beanCreator")
public class PagebeanCreator implements IPageBeanCreator{

	public RoomPage getRoom(Long id) {
		RoomPage roomPage = new RoomPage();
		{
			ArrayList<Operator> operators = new ArrayList<Operator>();
			AddOperator(operators, "联通",true/*addRoom*/);
			AddOperator(operators, "电信",true/*addRoom*/);
		}
		roomPage.setName("青羊东体验厅");
		roomPage.setPrivance(getPrivance(1L,false));
		roomPage.setId(id);
		return roomPage;
	}

	public Privance getPrivance(Long id,boolean isAddSubCompany) {
		Privance privance=new Privance();
		
		if(isAddSubCompany){
			ArrayList<SubCompany> subCompanys = new ArrayList<SubCompany>();
			for (int iFor1 = 0; iFor1 < 3; iFor1++) {
				ArrayList<Room> rooms = new ArrayList<Room>();
				Room room ;

				for (int iFor2 = 0; iFor2 < 4; iFor2++) {
					 room= new Room();room.setName("青阳东营业厅"+iFor1+iFor2);room.setPhone("0734-7842666");room.setAddress("四川省成都市青羊区文庙后街88号7楼");rooms.add(room);
				}
				SubCompany subCompany = new SubCompany();subCompany.setName("成都分公司"+iFor1);subCompany.setRooms(rooms);
				subCompanys.add(subCompany);
			}
			privance.setSubCompanys(subCompanys);
		}
		
		privance.setName("四川联通"+id);
		privance.setId(id);
		return privance;
	}


	public MainPage getMain() {
		MainPage main=new MainPage();

		ArrayList<Room> rooms = new ArrayList<Room>();

		{
			ArrayList<Operator> operators = new ArrayList<Operator>();
			AddOperator(operators, "联通",false/*addRoom*/);
			AddOperator(operators, "电信",false/*addRoom*/);
			main.setOperators(operators);
		}
		for (int iFor1 = 0; iFor1 < 4; iFor1++) {
			Room room = new Room();
			room.setImg("/styles/template1/images/img/room01.jpg");
			room.setName("济南历下中路体验厅"+iFor1);
			room.setId(iFor1+0L);
			rooms.add(room);
		}
		main.setRooms(rooms);
		return main;
	}

	private void AddOperator(ArrayList<Operator> operators, String name,boolean addRoom) {
		Operator operator= new Operator();
		operator.setName(name);
		ArrayList<Common.Package> packages = new ArrayList<Common.Package>();
		for (int iFor1 = 0; iFor1 < 8; iFor1++) {
			Common.Package package1 = new Common.Package();package1.setPrice(100L);
			Product product = new Product();product.setImg("/styles/template1/images/img/tv06.jpg");product.setName("S50 合约机");
			package1.setProduct(product);
			Privance privance = new Privance();
			privance.setName("广西联通"+iFor1);
			privance.setId(iFor1+0l);
			package1.setPrivance(privance);
			packages.add(package1);
		}
		operator.setPackages(packages);
		ArrayList<Privance> privances = new ArrayList<Privance>();
		for (int iFor2 = 0; iFor2 < 12; iFor2++) {
			Privance privance = new Privance();
			privance.setName(("北京"+iFor2+name));
			privance.setId(iFor2+0L);
			if(addRoom){
				ArrayList<Room> subRooms = new ArrayList<Room>();
				for (int i = 0; i < 5; i++) {
					Room room=new Room(); room.setName("青羊东体验厅"+i);subRooms.add(room);
				}
			}
			privances.add(privance);
		}
		operator.setPrivances(privances);
		operators.add(operator);
	}

	@Override
	public RoomPage getRoom_Privance(String name) {
		return null;
	}
}
