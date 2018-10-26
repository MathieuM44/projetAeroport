package ProjetAeroport;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoCompagnieAerienne;
import ProjetAeroport.dao.DaoCompagnieAerienneFactory;
import ProjetAeroport.model.CompagnieAerienne;
import ProjetAeroport.util.Context;

public class DaoCompagnieAerienneTest {

	private static DaoCompagnieAerienne daoCompagnieAerienne;
	
	@BeforeClass
	public static void initDao() {
		daoCompagnieAerienne = DaoCompagnieAerienneFactory.getInstance();
	}
	
	@AfterClass
	public static void close() {
		Context.destroy();
	}

	@Test
	public void insert() {
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
	}
	
	@Test
	public void findByKey() {
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		assertNotNull(daoCompagnieAerienne.findByKey(compagnieAerienne.getId()));
	}
	
	@Test
	public void update() {
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		compagnieAerienne.setNom("update_CompAe");
		daoCompagnieAerienne.update(compagnieAerienne);
	}
	
	@Test
	public void findAll() {
		assertNotNull(daoCompagnieAerienne.findAll());
	}
	
	@Test
	public void delete() {
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		compagnieAerienne = daoCompagnieAerienne.findByKey(compagnieAerienne.getId());
		daoCompagnieAerienne.delete(compagnieAerienne);
		assertNull(daoCompagnieAerienne.findByKey(compagnieAerienne.getId()));
	}
	
	
	public void deleteByKey() {
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		daoCompagnieAerienne.deleteByKey(compagnieAerienne.getId());
		assertNull(daoCompagnieAerienne.findByKey(compagnieAerienne.getId()));
	}
}
