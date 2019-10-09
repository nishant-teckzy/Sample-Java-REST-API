package Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import extConfigs.PropertyConfs;
import java.sql.Connection;


/**
 * @author Nishant Tiwari
 * @Created at 01-08-2019
 *
 */
public class SqlConnection {
	private static Logger log = Logger.getLogger(SqlConnection.class);
	
	
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	   static final String DB_URL = "jdbc:mysql://localhost/user?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//1
//	    static final String USER = "root";
//	  static final String PASS = "";
//	  Connection conn = null;
//	  
//	  public static Connection conn() throws SQLException {
//		  return DriverManager.getConnection(DB_URL, USER, PASS);
//		  
//		  
//		  
//	  }
	
	public SqlConnection() {
		super();
		BasicConfigurator.configure();
	}

	/**
	 * Implements SQL Connection
	 * @Created at 01-08-2019
	 * @return SQL Connection
	 */
	public static Connection conn() {
		Connection conn = null;
		try {
			String driver = null; 
					//PropertyConfs.getProps().getProperty("jdbc.driver");
			if (driver != null) {
			    Class.forName(driver) ;
			}
			String url = PropertyConfs.getProps().getProperty("jdbc.url");
			String username = PropertyConfs.getProps().getProperty("jdbc.username");
			String password = PropertyConfs.getProps().getProperty("jdbc.password");

			conn = DriverManager.getConnection(url);
			
			if(conn == null)
				System.out.println("Connection is null");
		
		}catch(SQLException  e) {
			e.printStackTrace();
			log.error("SQL Exception in Connection"+ e.getMessage());
			System.out.println("SQL Exception in Connection"+ e.getMessage());
			
			try {
				if(null != conn)
					conn.close();
				
			} catch (SQLException sqlEX) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Connection close Error :"+sqlEX.getErrorCode());
				
			}
		}catch(ClassNotFoundException e){
			log.error("Driver Class Not found in Connection");
			try {
				conn.close();
			} catch (SQLException sqlEX) {
				// TODO Auto-generated catch block
				sqlEX.printStackTrace();
				log.error("Connection close Error :"+sqlEX.getErrorCode());
				
			}
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		  return conn;
	  }
	
	/**
	 * Implements a static Method to Use PreparedStatement
	 * @Created-at : 01-08-2019 12:15
	 * @return PreparedStatement for Putting Values
	 * @param cookedString String for Prepared Statement
	 * @throws SQLException
	 */
	public static PreparedStatement PrepStmt(String cookedString) {
		PreparedStatement prep = null;
		
		
		try {
			prep = conn().prepareStatement(cookedString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error in PrepStmt : "+e.getErrorCode());
			try {
				conn().close();
			} catch (SQLException sqlEX) {
				// TODO Auto-generated catch block
				sqlEX.printStackTrace();
				log.error("Connection close Error :"+e.getErrorCode());
				
			}
			
		}
		return prep;
	}
	
	public static void main(String[] args) {
		conn();
	}
}
	
	
	
	
