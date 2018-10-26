package ProjetAeroport;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoAeroport;
import ProjetAeroport.dao.DaoAeroportFactory;
import ProjetAeroport.dao.DaoCompagnieAerienne;
import ProjetAeroport.dao.DaoCompagnieAerienneFactory;
import ProjetAeroport.dao.DaoCompagnieAerienneVol;
import ProjetAeroport.dao.DaoCompagnieAerienneVolFactory;
import ProjetAeroport.dao.DaoEscale;
import ProjetAeroport.dao.DaoEscaleFactory;
import ProjetAeroport.dao.DaoReservation;
import ProjetAeroport.dao.DaoReservationFactory;
import ProjetAeroport.dao.DaoVol;
import ProjetAeroport.dao.DaoVolFactory;
import ProjetAeroport.model.Aeroport;
import ProjetAeroport.model.CompagnieAerienne;
import ProjetAeroport.model.CompagnieAerienneVol;
import ProjetAeroport.model.CompagnieAerienneVolKey;
import ProjetAeroport.model.Escale;
import ProjetAeroport.model.EscaleKey;
import ProjetAeroport.model.Reservation;
import ProjetAeroport.model.Vol;
import ProjetAeroport.util.Context;

public class TestQueryVol {

	private static DaoVol daoVol;
	private static DaoAeroport daoAeroport;
	private static DaoEscale daoEscale;
	private static DaoReservation daoReservation;
	private static DaoCompagnieAerienne daoCompagnieAerienne;
	private static DaoCompagnieAerienneVol daoCompagnieAerienneVol;
	
	@BeforeClass
	public static void initDao() {
		daoVol = DaoVolFactory.getInstance();
		daoAeroport = DaoAeroportFactory.getInstance();
		daoEscale = DaoEscaleFactory.getInstance();
		daoReservation = DaoReservationFactory.getInstance();
		daoCompagnieAerienneVol = DaoCompagnieAerienneVolFactory.getInstance();
		daoCompagnieAerienne = DaoCompagnieAerienneFactory.getInstance();
	}
	
	@AfterClass
	public static void destroy() {
		Context.destroy();
	}
	
	@Test
	public void testVolADetA() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		Aeroport RCD1 = new Aeroport ();
		assertNull(RCD1.getId());
		daoAeroport.create(RCD1);
		Aeroport RCD2 = new Aeroport ();
		assertNull(RCD2.getId());
		daoAeroport.create(RCD2);
		vol.setAeroportDepart(RCD1);
		vol.setAeroportArrivee(RCD2);
		daoVol.update(vol);
		daoVol.findAllAeroportDepart();
		daoVol.findAllAeroportArrivee();
	}

	@Test
	public void testVolEscale() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		Aeroport RCD1 = new Aeroport ();
		assertNull(RCD1.getId());
		daoAeroport.create(RCD1);
		Escale escale = new Escale();
		escale.setKey(new EscaleKey(vol, RCD1));
		daoEscale.create(escale);
		daoVol.findAllEscale();
	}
	
	@Test
	public void testVolResa() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		Reservation resa = new Reservation();
		daoReservation.create(resa);
		daoVol.findAllReservation();
	}
	
	@Test
	public void testVolCompagnieAerienne() {
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
		daoVol.findAllCompagnieAerienneVol();
		daoVol.findAllCompagnieAerienne();
	}
}
