import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoCompagnieAerienne;
import ProjetAeroport.dao.DaoCompagnieAerienneFactory;
import ProjetAeroport.dao.DaoCompagnieAerienneVol;
import ProjetAeroport.dao.DaoCompagnieAerienneVolFactory;
import ProjetAeroport.dao.DaoVol;
import ProjetAeroport.dao.DaoVolFactory;
import ProjetAeroport.model.CompagnieAerienne;
import ProjetAeroport.model.CompagnieAerienneVol;
import ProjetAeroport.model.CompagnieAerienneVolKey;
import ProjetAeroport.model.Vol;
import ProjetAeroport.util.Context;

public class DaoCompagnieAerienneVolTest {

	private static DaoCompagnieAerienneVol daoCompagnieAerienneVol;
	private static DaoVol daoVol;
	private static DaoCompagnieAerienne daoCompagnieAerienne;
	
	@BeforeClass
	public static void initDao() {
		daoCompagnieAerienneVol = DaoCompagnieAerienneVolFactory.getInstance();
		daoVol = DaoVolFactory.getInstance();
		daoCompagnieAerienne = DaoCompagnieAerienneFactory.getInstance();
	}
	
	@AfterClass
	public static void close() {
		Context.destroy();
	}

	@Test
	public void insert() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		CompagnieAerienneVol cav = new CompagnieAerienneVol();
		cav.setKey(new CompagnieAerienneVolKey(vol, compagnieAerienne));
		daoCompagnieAerienneVol.create(cav);
	}
	
	@Test
	public void findByKey() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		CompagnieAerienneVol cav = new CompagnieAerienneVol();
		cav.setKey(new CompagnieAerienneVolKey(vol, compagnieAerienne));
		daoCompagnieAerienneVol.create(cav);
		assertNotNull(daoCompagnieAerienneVol.findByKey(cav.getKey()));
	}
	
	@Test
	public void update() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		CompagnieAerienneVol cav = new CompagnieAerienneVol();
		cav.setKey(new CompagnieAerienneVolKey(vol, compagnieAerienne));
		daoCompagnieAerienneVol.create(cav);
		compagnieAerienne.setNom("update_CompAe");
		daoCompagnieAerienne.update(compagnieAerienne);
		daoCompagnieAerienneVol.update(cav);
	}
	
	@Test
	public void findAll() {
		assertNotNull(daoCompagnieAerienneVol.findAll());
	}
	
	@Test
	public void deleteLien() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		CompagnieAerienneVol cav = new CompagnieAerienneVol();
		cav.setKey(new CompagnieAerienneVolKey(vol, compagnieAerienne));
		daoCompagnieAerienneVol.create(cav);
		daoCompagnieAerienneVol.delete(cav);
	}
	
	@Test
	public void deleteByKey() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		CompagnieAerienneVol cav = new CompagnieAerienneVol();
		cav.setKey(new CompagnieAerienneVolKey(vol, compagnieAerienne));
		daoCompagnieAerienneVol.create(cav);
		daoCompagnieAerienneVol.deleteByKey(cav.getKey());
	}
	
	@Test
	public void deleteVolLien() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		CompagnieAerienneVol cav = new CompagnieAerienneVol();
		cav.setKey(new CompagnieAerienneVolKey(vol, compagnieAerienne));
		daoCompagnieAerienneVol.create(cav);
		vol = daoVol.findByKey(vol.getId());
		daoVol.delete(vol);
	}
	
	@Test
	public void deleteCompagnieAerienneLien() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setNom("CompAe");
		daoCompagnieAerienne.create(compagnieAerienne);
		CompagnieAerienneVol cav = new CompagnieAerienneVol();
		cav.setKey(new CompagnieAerienneVolKey(vol, compagnieAerienne));
		daoCompagnieAerienneVol.create(cav);
		compagnieAerienne = daoCompagnieAerienne.findByKey(compagnieAerienne.getId());
		daoCompagnieAerienne.delete(compagnieAerienne);
	}
}
