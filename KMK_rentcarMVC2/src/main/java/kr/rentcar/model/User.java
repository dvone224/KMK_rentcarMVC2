package kr.rentcar.model;

public class User {
	private int num;
	private String name;
	private String userId;
	private String pwd;
	private String email;
	private String phone;

	public User( String name, String userId, String pwd, String email, String phone) {
		this.name = name;
		this.userId = userId;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public String getPwd() {
		return pwd;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

}
