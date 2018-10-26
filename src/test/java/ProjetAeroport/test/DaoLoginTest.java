package ProjetAeroport.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import ProjetAeroport.dao.DaoLogin;
import ProjetAeroport.dao.DaoLoginFactory;
import ProjetAeroport.model.Login;
import ProjetAeroport.util.Context;

public class DaoLoginTest {
	
	private static DaoLogin daoLogin;

	@BeforeClass
	public static void initDaoLogin() {
		daoLogin = DaoLoginFactory.getInstance();
	}

	@AfterClass
	public static void fermetureJpa() {
		Context.destroy();
	
	}
		
	@Test
	public void insert() {
		Login loginTest = new Login();
		loginTest.setLogin("create");
		assertNull(loginTest.getId());
		daoLogin.create(loginTest);
		assertNotNull(loginTest.getId());

	}

	@Test
	public void findByKey() {
		Login loginTest = new Login();
		loginTest.setLogin("find");
		daoLogin.create(loginTest);
		assertNotNull(daoLogin.findByKey(loginTest.getId()));
	}

	@Test
	public void update() {
		Login loginTest = new Login();
		loginTest.setLogin("ancien");
		daoLogin.create(loginTest);
		loginTest.setLogin("nouveau");
		loginTest=daoLogin.update(loginTest);
		assertEquals("nouveau", loginTest.getLogin());
	}
	
	@Test
	public void delete() {
		Login loginTest = new Login();
		loginTest.setLogin("delete");
		daoLogin.create(loginTest);
		daoLogin.delete(loginTest);
		assertNull(daoLogin.findByKey(loginTest.getId()));
	
	}
	
	@Test
	public void deleteByKey() {
		Login loginTest = new Login();
		loginTest.setLogin("delete");
		daoLogin.create(loginTest);
		daoLogin.deleteByKey(loginTest.getId());
		assertNull(daoLogin.findByKey(loginTest.getId()));
	}

	

}