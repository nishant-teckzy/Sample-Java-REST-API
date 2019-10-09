package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = SqlConnection.conn();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String Sql = "select * from Employee";
			ResultSet rs = stmt.executeQuery(Sql);
			while (rs.next()) {
				System.out.println(rs.getString("FirstName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
