package ProjetAeroport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoPassager;
import ProjetAeroport.dao.DaoPassagerFactory;
import ProjetAeroport.model.Passager;
import ProjetAeroport.util.*;

public class DaoPassagerTest {
	
	private static DaoPassager daoPassager;
	
	@BeforeClass
	public static void initDaoPassager() {
		daoPassager = DaoPassagerFactory.getInstance();
	}
	
	@AfterClass
	public static void fermeturJpa() {
		Context.destroy();
	}
	
	
	@Test
	public void create() {
		Passager vallan;
		vallan = new Passager("sellaiah", "ddqdq");
		daoPassager.create(vallan);
		assertNotNull(vallan.getId());
	}
//	
	@Test
	public void findByKey() {
		Passager vallan;
		vallan = new Passager("unknown", "vallan");
		daoPassager.create(vallan);
		assertNotNull(daoPassager.findByKey(vallan.getId()));
	} //ok
	
	@Test
	public void update() {
		Passager vallan;
		vallan = new Passager("unknown", "vallan");
		daoPassager.create(vallan);
		vallan = daoPassager.findByKey(vallan.getId());
		vallan.setNom("sellaiah");
		daoPassager.update(vallan);
		assertEquals("sellaiah", daoPassager.findByKey(vallan.getId()).getNom()) ;
	}//ok
	
	@Test
	public void findAll() {
		assertNotNull(daoPassager.findAll());
	}//ok
//	
	@Test
	public void delete() {
		
		Passager vallan;
		vallan = new Passager("sellaiah","vallan");
			daoPassager.create(vallan);
			daoPassager.delete(vallan);
			assertNull(daoPassager.findByKey(vallan.getId()));
		
	}//ok
////	
	@Test
	public void deleteByKey() {
		
		Passager vallan;
		vallan = new Passager("sellaiah","vallan");
			daoPassager.create(vallan);
			daoPassager.delete(vallan);
			daoPassager.deleteByKey(vallan.getId());
			assertNull(daoPassager.findByKey(vallan.getId()));
		
	}//ok

}
