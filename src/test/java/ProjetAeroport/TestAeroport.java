package ProjetAeroport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoAeroport;
import ProjetAeroport.dao.DaoAeroportFactory;
import ProjetAeroport.model.Aeroport;
import ProjetAeroport.util.Context;

public class TestAeroport {
	private static DaoAeroport daoAeroport;
	
	@BeforeClass
	public static void initDaoAeroport() {
		daoAeroport = DaoAeroportFactory.getInstance();
	}

	@AfterClass
	public static void fermetureJpa() {
		Context.destroy();
	}

	@Test
	public void insert() {
		Aeroport RCD = new Aeroport ();
		assertNull(RCD.getId());
		daoAeroport.create(RCD);
		assertNotNull(RCD.getId());
	}

	@Test
	public void findByKey() {
		Aeroport a = new Aeroport();
		daoAeroport.create(a);
		assertNotNull(daoAeroport.findByKey(a.getId()));
	}

	@Test
	public void update() {
		Aeroport a = new Aeroport ();
		daoAeroport.create(a);
		a = daoAeroport.findByKey(a.getId());
		a.setNom("nom update");
		daoAeroport.update(a);
		assertEquals("nom update", daoAeroport.findByKey(a.getId()).getNom());

	}

	@Test
	public void findAll() {
		assertNotNull(daoAeroport.findAll());
	}

	@Test
	public void delete() {
		Aeroport a = new Aeroport();
		daoAeroport.create(a);
		daoAeroport.delete(a);
		assertNull(daoAeroport.findByKey(a.getId()));
	}

	@Test
	public void deleteByKey() {
		Aeroport a = new Aeroport (); 
		daoAeroport.create(a);
		daoAeroport.deleteByKey(a.getId());
	}
}

