package kr.rentcar.model;

public class Reservation {

	private int num;
	private String userId;
	private int qty;
	private int dDay;
	private String rDay;
	private int useIn;
	private int useWifi;
	private int useNavi;
	private int useSeat;

	public Reservation(int num, String userId, int qty, int dDay, String rDay, int useIn, int useWifi, int useNavi,
			int useSeat) {
		this.num = num;
		this.userId = userId;
		this.qty = qty;
		this.dDay = dDay;
		this.rDay = rDay;
		this.useIn = useIn;
		this.useWifi = useWifi;
		this.useNavi = useNavi;
		this.useSeat = useSeat;
	}

	public int getNum() {
		return num;
	}

	public String getUserId() {
		return userId;
	}

	public int getQty() {
		return qty;
	}

	public int getdDay() {
		return dDay;
	}

	public String getrDay() {
		return rDay;
	}

	public int getUseIn() {
		return useIn;
	}

	public int getUseWifi() {
		return useWifi;
	}

	public int getUseNavi() {
		return useNavi;
	}

	public int getUseSeat() {
		return useSeat;
	}

	@Override
	public String toString() {
		return "Reservation [num=" + num + ", userId=" + userId + ", qty=" + qty + ", dDay=" + dDay + ", rDay=" + rDay
				+ ", useIn=" + useIn + ", useWifi=" + useWifi + ", useNavi=" + useNavi + ", useSeat=" + useSeat + "]";
	}
	
	

}
