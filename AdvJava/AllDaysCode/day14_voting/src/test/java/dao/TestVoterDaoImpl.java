package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Voter;
import utils.HibernateUtils;

class TestVoterDaoImpl {
	private static VoterDaoImpl dao;
	@BeforeAll
	public static void setUp()
	{
		System.out.println("in before all");
		//create dao instance
		dao=new VoterDaoImpl();
	}

	@Test
	void testAuthenticateUser() {
		System.out.println("in test auth user");
		Voter voter = dao.authenticateUser("rama", "ram#123");
		assertEquals("voter",voter.getRole());		
	}
	@AfterAll
	public static void cleanUp()
	{
		System.out.println("in after all");
		HibernateUtils.getFactory().close();
		
	}

}
