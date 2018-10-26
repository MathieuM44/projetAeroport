package ProjetAeroport.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import ProjetAeroport.dao.DaoClient;
import ProjetAeroport.dao.DaoClientFactory;
import ProjetAeroport.model.Client;
import ProjetAeroport.model.ClientEI;
import ProjetAeroport.util.Context;

public class DaoClientTest {
	
	private static DaoClient daoClient;

	@BeforeClass
	public static void initDaoClient() {
		daoClient = DaoClientFactory.getInstance();
	}

	@AfterClass
	public static void fermetureJpa() {
		Context.destroy();
	
	}
		
	@Test
	public void insert() {
		Client cp = new ClientEI();
		cp.setNom("create");
		assertNull(cp.getId());
		daoClient.create(cp);
		assertNotNull(cp.getId());

	}

	@Test
	public void findByKey() {
		Client cp = new ClientEI();
		cp.setNom("find");
		daoClient.create(cp);
		assertNotNull(daoClient.findByKey(cp.getId()));
	}

	@Test
	public void update() {
		Client cp = new ClientEI();
		cp.setNom("ancien");
		daoClient.create(cp);
		cp.setNom("nouveau");
		cp=daoClient.update(cp);
		assertEquals("nouveau", cp.getNom());
	}
	
	@Test
	public void delete() {
		Client cp = new ClientEI();
		cp.setNom("delete");
		daoClient.create(cp);
		daoClient.delete(cp);
		assertNull(daoClient.findByKey(cp.getId()));
	
	}
	
	@Test
	public void deleteByKey() {
		Client cp = new ClientEI();
		cp.setNom("delete");
		daoClient.create(cp);
		daoClient.deleteByKey(cp.getId());
		assertNull(daoClient.findByKey(cp.getId()));
	}

	

}