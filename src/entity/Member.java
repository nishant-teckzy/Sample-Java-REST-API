package entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Member{

	private String firstname;
	private String lastname;
	private int age;
	private String address;
	private String mobile;
	private String email;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String firstname, String lastname, int age, String address, String mobile, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
