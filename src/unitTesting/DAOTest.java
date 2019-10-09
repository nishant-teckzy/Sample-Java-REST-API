package unitTesting;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import Connection.SqlConnection;
import entity.Member;
import entity.Profile;
import service.Service;


/**
 * @author Nishant Tiwari
 *
 */
@RunWith(JUnit4.class)
public class DAOTest {

	private static final String MEMBER_ID = "7054796555";
	private Connection conn = null;
	private Service serv = null;

	@Before
	public void init() {
		conn = SqlConnection.conn();
		serv = new Service();
	}

	/**
	 * To test Database Connection first
	 * 
	 * @author Nishant tiwari
	 * @return void
	 * 
	 */
	@Test
	public void getConnectionTest() {
		assertEquals(null != conn, true);
	}

	/**
	 * To Check findById from Database
	 * 
	 * @author Nishant tiwari
	 * @return void
	 * 
	 */

	@Test
	public void testFindById() {
		Member member = serv.getMemberById(MEMBER_ID);
		Assert.assertEquals("Nishant", member.getFirstname());
		Assert.assertEquals("teckzy.inc@gmail.com", member.getEmail());
		Assert.assertEquals(MEMBER_ID, member.getMobile());
		return;
	}

	/**
	 * To Check Login method from Database
	 * 
	 * @author Nishant tiwari
	 * @return void
	 * @exception SQLException May Occur
	 */
	@Test(expected = SQLException.class)
	public void testLogin() {
		Profile prof = serv.Login("705479655", "Nishant123");
		Assert.assertNull(prof);
		return;

	}
	

}
