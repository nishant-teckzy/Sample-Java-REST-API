package entity;

public class Login {
	String Username;
	String Password;
	String Mobile;
	int Admin;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Login(String username, String password, String mobile,int admin) {
		super();
		Username = username;
		Password = password;
		Mobile = mobile;
		Admin = admin;
	}


	
	public int getAdmin() {
		return Admin;
	}


	public void setAdmin(int admin) {
		Admin = admin;
	}


	public String getUsername() {
		return Username;
	}
	public String getPassword() {
		return Password;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	
	

}
