package ProjetAeroport;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoVille;
import ProjetAeroport.dao.DaoVilleFactory;
import ProjetAeroport.model.Ville;
import ProjetAeroport.util.Context;


public class TestVille {
	
	private static DaoVille daoVille;
	
	@BeforeClass
	public static void initDaoVille() {
		daoVille = DaoVilleFactory.getInstance();
	}

	@AfterClass
	public static void fermetureJpa() {
		Context.destroy();
	}

	@Test
	public void insert() {
		Ville Paris = new Ville ();
		assertNull(Paris.getId());
		daoVille.create(Paris);
		assertNotNull(Paris.getId());
	}

	@Test
	public void findByKey() {
		Ville v = new Ville();
		daoVille.create(v);
		assertNotNull(daoVille.findByKey(v.getId()));
	}

	@Test
	public void update() {
		Ville v = new Ville ();
		daoVille.create(v);
		v = daoVille.findByKey(v.getId());
		v.setNom("nom update");
		daoVille.update(v);
		assertEquals("nom update", daoVille.findByKey(v.getId()).getNom());

	}

	@Test
	public void findAll() {
		assertNotNull(daoVille.findAll());
	}

	@Test
	public void delete() {
		Ville v = new Ville();
		daoVille.create(v);
		daoVille.delete(v);
		assertNull(daoVille.findByKey(v.getId()));
	}

	@Test
	public void deleteByKey() {
		Ville v = new Ville (); 
		daoVille.create(v);
		daoVille.deleteByKey(v.getId());
		assertNull(daoVille.findByKey(v.getId()));
	}
}
