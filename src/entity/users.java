package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class users {
	private int id;
	private String username;
	private String email;
	public users() {
		super();
		
	}
	public users(int id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	
}
