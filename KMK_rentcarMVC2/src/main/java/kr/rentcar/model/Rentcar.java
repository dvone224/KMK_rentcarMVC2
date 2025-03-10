package kr.rentcar.model;

public class Rentcar {
	private int num;
	private String name;
	private int category;
	private int price;
	private int usepeople;
	private int total_qty;
	private String company;
	private String img;
	private String info;

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public int getprice() {
		return price;
	}
	
	public int getCategory() {
		return category;
	}

	public int getUsepeople() {
		return usepeople;
	}

	public int gettotal_qty() {
		return total_qty;
	}
	
	public void settotal_qty(int total_qty) {
		this.total_qty = total_qty;
	}

	public String getCompany() {
		return company;
	}

	public String getImg() {
		return img;
	}

	public String getInfo() {
		return info;
	}

	@Override
	public String toString() {
		return "Rentcar [num=" + num + ", name=" + name + ", category=" + category + ", price=" + price + ", usepeople="
				+ usepeople + ", total_qty=" + total_qty + ", company=" + company + ", img=" + img + ", info=" + info
				+ "]";
	}
	
	

}
