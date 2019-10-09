package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import Connection.SqlConnection;
import entity.Login;
import entity.Member;
import entity.Profile;
import entity.users;
import extConfigs.PropertyConfs;
import interfaceImpl.MemberOps;
public class Service implements MemberOps {
	
	static List<users> userList = new ArrayList<>();
	static int id = 1;
	static ArrayList<Member> memberList = new ArrayList<>();
	static ArrayList<Login> loginList = new ArrayList<>();
	static JSONArray json = new JSONArray();
	private static Logger log = Logger.getLogger(Service.class);
//	private Statement stmt = null;
	
	
	
	static
	{
		
//		try {
//			json = readJson("https://jsonplaceholder.typicode.com/users");
//			System.out.println(json);
//			for(int i=0;i<json.length();i++) {
//				JSONObject obj = (JSONObject)json.get(i);
//				userList.add(new users(obj.getInt("id"),obj.getString("username"),obj.getString("email")));
//				
//			}
//			
//		} catch (IOException |JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	/*
	 * ------------------------------USER-Method------------------------------------------------
	 */

	public Service() {
		super();
		BasicConfigurator.configure();
	}

	/**
	 * Implemented to get All users from List
	 * @author Nishant
	 * @Created-at 01-08-2019 16:29
	 * @return List<users>
	 */

	public List<users> getAllusers() {
		return userList;
	}

	/**
	 * Implemented to get users by id from List
	 * @author Nishant
	 * @Created-at 01-08-2019 16:29
	 * @param id :- userid
	 * @return users object
	 */
	public users getuserById(int id) {
		return userList.stream().filter(in -> (in.getId() == id)).findFirst().get();
	}
	/**
	 * Implemented to Add new Object to users List
	 * @author Nishant
	 * @Created-at 01-08-2019 16:29
	 * @param users Object
	 * @return String : Success || Error
	 */
	public String setusers(users in) {
		if(userList.add(in))
			return "Added";
		else
			return "Error while adding";		
	}
	
	
	/*
	 * ------------------------------Member-Method------------------------------------------------
	 */
	
	public Profile Login(String mobile,String password) {
		PreparedStatement prep = SqlConnection.PrepStmt(PropertyConfs.getProps().getProperty("Login.Auth"));
		Profile profile = null;
		Member member = null;
		Login login = null;
		
		
		try {
			prep.setString(1, mobile);
			prep.setString(2, password);
			ResultSet rs = prep.executeQuery();
			
			if(rs.next()) {
				member = new Member(rs.getString("FirstName"),
						rs.getString("LastName"),
						rs.getInt("Age"),
						rs.getString("Address"),
						rs.getString("Mobile"),
						rs.getString("Email"));
				login = new Login(rs.getString("Username"),rs.getString("Password"),rs.getString("Mobile"),rs.getInt("admin"));
				profile = new Profile(member,login);
			}else
				return null;
			
				System.out.println("---->"+login.getMobile());
				System.out.println(profile);
	
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in Connection"+ e.getMessage());
			
		}
		return profile;
	}
	
	
	/**
	 * Implemented to get All Members from Database
	 * @author Nishant
	 * @Created-at 01-08-2019 16:29
	 * @return List<member>
	 * @throws SQLException
	 */
	public List<Member> getAllMembers() {
		PreparedStatement prep = SqlConnection.PrepStmt(PropertyConfs.getProps().getProperty("Person.selectAll"));
		try {
			ResultSet rs = prep.executeQuery();
			memberList.clear();
				while(rs.next()) {
//		Member(String firstname, String lastname, int age, String address, String mobile, String email)
					memberList.add(new Member(rs.getString("FirstName"),
							rs.getString("LastName"),
							rs.getInt("Age"),
							rs.getString("Address"),
							rs.getString("Mobile"),
							rs.getString("Email")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in Connection"+ e.getMessage());
		}
		return memberList;
	}
	
	
	/**
	 * Implemented to get Profile of a specific Member from Database
	 * @author Nishant
	 * @Created-at 01-08-2019 16:29
	 * @return Profile Containing two List<member> , List<Login>
	 * @throws SQLException
	 */
	
	public Profile getMemberProfile(String mobile) {
		PreparedStatement prep = SqlConnection.PrepStmt(PropertyConfs.getProps().getProperty("Person.innerJoin"));
		Profile profile = null;
		
		try {
			prep.setString(1, mobile);
			ResultSet rs = prep.executeQuery();
				while(rs.next()) {
					Member member = new Member(rs.getString("FirstName"),
							rs.getString("LastName"),
							rs.getInt("Age"),
							rs.getString("Address"),
							rs.getString("Mobile"),
							rs.getString("Email"));
					Login login = new Login(rs.getString("Username"),rs.getString("Password"),rs.getString("Mobile"),rs.getInt("admin"));
					profile = new Profile(member,login);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in Connection"+ e.getMessage());
		}
		return profile;
	}
	
	
	/**
	 * Implemented to get a Member by id from Database
	 * @author Nishant
	 * @Created-at 01-08-2019 16:29
	 * @return member object
	 * @param  String mobile (unique key to match from database)
	 * @throws SQLException
	 */
	public Member getMemberById(String mobile) {
		PreparedStatement prep = SqlConnection.PrepStmt(PropertyConfs.getProps().getProperty("Person.select"));
		try {
			prep.setString(1, mobile);
			ResultSet rs = prep.executeQuery();
				while(rs.next()) {
//		Member(String firstname, String lastname, int age, String address, String mobile, String email)
					memberList.add(new Member(rs.getString("FirstName"),
							rs.getString("LastName"),
							rs.getInt("Age"),
							rs.getString("Address"),
							rs.getString("Mobile"),
							rs.getString("Email")));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("SQL Exception in Connection"+ e.getMessage());
		}
		return memberList.get(0);
	}

	
	/**
	 * Implemented to insert a new Member into Database
	 * @author Nishant
	 * @Created-at 01-08-2019 16:29
	 * @return String : Result [Success || Error]
	 * @param  Member Object
	 * @throws SQLException
	 */
	public boolean setMember(Member member) {
//		PreparedStatement prepStmt = 
		String Person_insert =  PropertyConfs.getProps().getProperty("Person.insert");//Login.insert
		String Login_insert =  PropertyConfs.getProps().getProperty("Login.insert");
//		(FirstName,LastName,Address,Mobile,Email,age)
		
		PreparedStatement prepInsert = SqlConnection.PrepStmt(Person_insert);
		PreparedStatement prepInsertLogin = SqlConnection.PrepStmt(Login_insert);
		try {
			prepInsert.setString(1, member.getFirstname());
			
			prepInsert.setString(2, member.getLastname());
			prepInsert.setString(3, member.getAddress());
			prepInsert.setString(4, member.getMobile());
			prepInsert.setString(5, member.getEmail());
			prepInsert.setInt(6, member.getAge());
			
			prepInsertLogin.setString(1,  member.getFirstname());
			prepInsertLogin.setString(2,  member.getMobile());
			prepInsertLogin.setString(3,  member.getMobile());
//			SqlConn.conn().commit()
			if(prepInsert.executeUpdate() != 0 && prepInsertLogin.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				prepInsert.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("SQL Exception in Connection"+ e.getMessage());
			}
		}
		return false;		
	}
	

	
	/**
	 * @deprecated
	 * Implemented to invoke GET on REST API URL to fetch data as JSONArray
	 * @author Nishant
	 * @Created-at 01-08-2019 16:29
	 * @return String : Result [Success || Error]
	 * @param  Member Object
	 * @throws IOException
	 */
	
	public static JSONArray readJson(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
	      
	      String jsonText = new String(sb);
	      JSONArray json = new JSONArray(jsonText);
	      
	    }catch(IOException e) {
	    	e.printStackTrace();
	    } finally {
	      is.close();
	    }
	    return json;
	  }
}
