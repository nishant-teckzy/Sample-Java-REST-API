package extConfigs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import Connection.SqlConnection;

/**
 * Class to implement all Methods Related to Properties
 * @author Nishant
 * @Created-at : 01-08-2019 12:15
 *
 */
public class PropertyConfs {
	
	private static Logger log = Logger.getLogger(SqlConnection.class);

	public PropertyConfs() {
		super();
		BasicConfigurator.configure();
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implements to get SQL Property file
	 * @author Nishant
	 * @return Properties
	 * @Created-at : 01-08-2019 12:15
	 * @throws IOException
	 */
	public static Properties getProps() {
		InputStream in = null;
		Properties props = null;
		try {
			props = new Properties();
//			URL url = getClass().getResource("extConfigs/SQL.properties");
			in = new SqlConnection().getClass().getResourceAsStream("SQL.properties");
			props.load(in);
		}catch(IOException e) {
			e.printStackTrace();
			log.error("Error Occurred in getProps :"+e.getMessage());
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("InputStream close Error :"+e.getMessage());
				
			}
		  
	  }
		return props;
	}
	

}
