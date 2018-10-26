package ProjetAeroport;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoAeroport;
import ProjetAeroport.dao.DaoAeroportFactory;
import ProjetAeroport.dao.DaoEscale;
import ProjetAeroport.dao.DaoEscaleFactory;
import ProjetAeroport.dao.DaoVol;
import ProjetAeroport.dao.DaoVolFactory;
import ProjetAeroport.model.Aeroport;
import ProjetAeroport.model.Escale;
import ProjetAeroport.model.EscaleKey;
import ProjetAeroport.model.Vol;
import ProjetAeroport.util.Context;

public class DaoVolAeroportTest {

	private static DaoEscale daoEscale;
	private static DaoVol daoVol;
	private static DaoAeroport daoAeroport;
	
	@BeforeClass
	public static void initDao() {
		daoEscale = DaoEscaleFactory.getInstance();
		daoVol = DaoVolFactory.getInstance();
		daoAeroport = DaoAeroportFactory.getInstance();
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
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		Escale e = new Escale();
		e.setKey(new EscaleKey(vol, aeroport));
		daoEscale.create(e);
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
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		Escale e = new Escale();
		e.setKey(new EscaleKey(vol, aeroport));
		daoEscale.create(e);
		assertNotNull(daoEscale.findByKey(e.getKey()));
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
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		Escale e = new Escale();
		e.setKey(new EscaleKey(vol, aeroport));
		daoEscale.create(e);
		aeroport.setNom("update_nom");
		daoAeroport.update(aeroport);
		daoEscale.update(e);
	}
	
	@Test
	public void findAll() {
		assertNotNull(daoEscale.findAll());
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
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		Escale e = new Escale();
		e.setKey(new EscaleKey(vol, aeroport));
		daoEscale.create(e);
		daoEscale.delete(e);
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
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		Escale e = new Escale();
		e.setKey(new EscaleKey(vol, aeroport));
		daoEscale.create(e);
		daoEscale.deleteByKey(e.getKey());
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
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		Escale e = new Escale();
		e.setKey(new EscaleKey(vol, aeroport));
		daoEscale.create(e);
		vol = daoVol.findByKey(vol.getId());
		daoVol.delete(vol);
	}
	
	@Test
	public void deleteAeroportLien() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("nom");
		daoAeroport.create(aeroport);
		Escale e = new Escale();
		e.setKey(new EscaleKey(vol, aeroport));
		daoEscale.create(e);
		aeroport = daoAeroport.findByKey(aeroport.getId());
		daoAeroport.delete(aeroport);
	}
}
