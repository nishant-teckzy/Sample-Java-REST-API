package entity;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	private Member member;
	private Login login;
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Member member, Login login) {
		super();
		this.member = member;
		this.login = login;
	}

	public Member getMember() {
		return member;
	}

	public Login getLogin() {
		return login;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	

}
