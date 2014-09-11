package com.galebo.baidu8.front.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.galebo.baidu8.front.models.Common.Operator.Privance;

public class Common {
	private static final String baseUrl = "/shop/_";
	private static final String baseJUrl = "/shop/j_";
	public static String getPriviceUrl(Long id) {
		return baseUrl+"content2?id="+id;
	}
	public static String getRoomUrl(Long id) {
		return baseUrl+"room2?id="+id;
	}
	public static String getHomeUrl() {
		return baseUrl+"index2";
	}
	public static String getMapUrl() {
		return baseUrl+"room_privance?id=";
	}
	public static String getOrderUrl() {
		return baseUrl+"form2";
	}
	public static String getJRoomUrl() {
		return baseJUrl+"room";
	}
	public static class IdName{
		String name;
		Long id;
		Long pid;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getPid() {
			return pid;
		}
		public void setPid(Long pid) {
			this.pid = pid;
		}
	}
	public static class Product{
		String name;
		String colorName;
		String img;
		public String getColorName() {
			return colorName;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
			this.colorName = 
					name.replace("40", "<strong>40</strong>")
					.replace("50", "<strong>50</strong>")
					.replace("60", "<strong>60</strong>")
					.replace("70", "<strong>70</strong>");
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
	}
	public static class Package{
		Privance privance;
		Product product;
		Long price;
		String url;
		public String getUrl() {
			return url;
		}
		public Privance getPrivance() {
			return privance;
		}
		public void setPrivance(Privance privance) {
			this.privance = privance;
			url=getPriviceUrl(privance.getId());
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Long getPrice() {
			return price;
		}
		public void setPrice(Long price) {
			this.price = price;
		}
	}

	public static class Operator extends IdName{
		List<Privance> privances;
		List<Common.Package> packages;
		public List<Common.Package> getPackages() {
			return packages;
		}
		public void setPackages(List<Common.Package> packages) {
			this.packages = packages;
		}
		public List<Privance> getPrivances() {
			return privances;
		}
		public void setPrivances(List<Privance> privances) {
			this.privances = privances;
		}
		public static class Privance extends IdName{
			String simpleName;
			List<Package> packages;
			List<SubCompany> subCompanys;
			String url;
			String pricePic;

			public String getPricePic() {
				return pricePic;
			}
			public void setPricePic(String pricePic) {
				if(StringUtils.isNotBlank(pricePic)){
					this.pricePic = pricePic;
				}
			}
			public void setName(String name) {
				this.name = name;
				this.simpleName = name.replaceAll("电信", "").replaceAll("联通", "").replaceAll("移动", "");
			}
/*			List<Room> allRooms;
			public List<Room> getAllRooms() {
				return allRooms;
			}
			public void setAllRooms(List<Room> allRooms) {
				this.allRooms = allRooms;
			}*/

			public String getUrl() {
				return url;
			}
			@Override
			public void setId(Long id) {
				super.setId(id);
				url=getPriviceUrl(id);
			}
			public String getSimpleName() {
				return simpleName;
			}

			public List<Package> getPackages() {
				return packages;
			}

			public void setPackages(List<Package> packages) {
				this.packages = packages;
			}

			public List<SubCompany> getSubCompanys() {
				return subCompanys;
			}

			public void setSubCompanys(List<SubCompany> subCompanys) {
				this.subCompanys = subCompanys;
			}

			public static class SubCompany extends IdName{
				List<Room> rooms;
				public List<Room> getRooms() {
					return rooms;
				}
				public void setRooms(List<Room> rooms) {
					this.rooms = rooms;
				}
			}
			public static class Room extends IdName{
				String phone;
				String address;
				String img;
				String url;
				String description;
				List<String> pics;
				public String getDescription() {
					return description;
				}
				public void setDescription(String description) {
					this.description = description;
				}
				public List<String> getPics() {
					return pics;
				}
				public void setPics(String pics) {
					this.pics=new ArrayList<String>();
					if(pics!=null&&pics.trim().length()>0){
						String[] split = pics.trim().split(",");
						for (String string : split) {
							this.pics .add(string);
						}
					}
				}
				public String getUrl() {
					return url;
				}
				public void setId(Long id) {
					super.setId(id);
					url=getRoomUrl(id);
				}
				public String getImg() {
					return img;
				}
				public void setImg(String img) {
					this.img = img;
				}
				public String getPhone() {
					return phone;
				}
				public void setPhone(String phone) {
					if(!StringUtils.isBlank(phone))
						this.phone = phone;
				}
				public String getAddress() {
					return address;
				}
				public void setAddress(String address) {
					if(!StringUtils.isBlank(address))
						this.address = address;
				}
			}
		}
	}
}
