package ProjetAeroport;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoAeroport;
import ProjetAeroport.dao.DaoAeroportFactory;
import ProjetAeroport.dao.DaoVille;
import ProjetAeroport.dao.DaoVilleAeroport;
import ProjetAeroport.dao.DaoVilleAeroportFactory;
import ProjetAeroport.dao.DaoVilleFactory;
import ProjetAeroport.model.Aeroport;
import ProjetAeroport.model.Ville;
import ProjetAeroport.model.VilleAeroport;
import ProjetAeroport.model.VilleAeroportKey;
import ProjetAeroport.util.Context;

public class DaoVilleAeroportTest {

	private static DaoVilleAeroport daoVilleAeroport;
	private static DaoVille daoVille;
	private static DaoAeroport daoAeroport;
	
	@BeforeClass
	public static void initDao() {
		daoVille = DaoVilleFactory.getInstance();
		daoAeroport = DaoAeroportFactory.getInstance();
		daoVilleAeroport = DaoVilleAeroportFactory.getInstance();
	}
	
	@AfterClass
	public static void close() {
		Context.destroy();
	}

	@Test
	public void insert() {
		Ville ville = new Ville();
		ville.setNom("Paris");
		daoVille.create(ville);
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		VilleAeroport va = new VilleAeroport();
		va.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(va);
	}
	
	@Test
	public void findByKey() {
		Ville ville = new Ville();
		ville.setNom("Paris");
		daoVille.create(ville);
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		VilleAeroport va = new VilleAeroport();
		va.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(va);
		assertNotNull(daoVilleAeroport.findByKey(va.getKey()));
	}
	
	@Test
	public void update() {
		Ville ville = new Ville();
		ville.setNom("Paris");
		daoVille.create(ville);
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		VilleAeroport va = new VilleAeroport();
		va.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(va);
		aeroport.setNom("update_nom");
		daoAeroport.update(aeroport);
		daoVilleAeroport.update(va);
	}
	
	@Test
	public void findAll() {
		assertNotNull(daoVilleAeroport.findAll());
	}
	
	@Test
	public void deleteLien() {
		Ville ville = new Ville();
		ville.setNom("Paris");
		daoVille.create(ville);
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		VilleAeroport va = new VilleAeroport();
		va.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(va);
		daoVilleAeroport.delete(va);
	}
	
	@Test
	public void deleteByKey() {
		Ville ville = new Ville();
		ville.setNom("Paris");
		daoVille.create(ville);
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		VilleAeroport va = new VilleAeroport();
		va.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(va);
		daoVilleAeroport.deleteByKey(va.getKey());
	}
	
	@Test
	public void deleteVilleLien() {
		Ville ville = new Ville();
		ville.setNom("Paris");
		daoVille.create(ville);
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		VilleAeroport va = new VilleAeroport();
		va.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(va);
		ville = daoVille.findByKey(ville.getId());
		daoVille.delete(ville);
	}
	
	@Test
	public void deleteAeroportLien() {
		Ville ville = new Ville();
		ville.setNom("Paris");
		daoVille.create(ville);
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		VilleAeroport va = new VilleAeroport();
		va.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(va);
		aeroport = daoAeroport.findByKey(aeroport.getId());
		daoAeroport.delete(aeroport);
	}
}
