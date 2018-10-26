package ProjetAeroport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoReservation;
import ProjetAeroport.dao.DaoReservationFactory;
import ProjetAeroport.model.Passager;
import ProjetAeroport.model.Reservation;
import ProjetAeroport.util.Context;




public class DaoReservationTest {

	private static DaoReservation daoReservation;

	@BeforeClass
	public static void initDaoReservation() {
		daoReservation = DaoReservationFactory.getInstance();
	}

	@AfterClass
	public static void fermeturJpa() {
		Context.destroy();
	}

	@Test
	public void insert() {
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		Reservation vallan;
		try {
			vallan = new Reservation(sdf.parse("15/05/2018"),4565);
			daoReservation.create(vallan);
			assertNotNull(vallan.getId());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void findByKey() {
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		Reservation vallan;
		try {
			vallan = new Reservation(sdf.parse("21/05/1980"),1232);
			daoReservation.create(vallan);
			assertNotNull(daoReservation.findByKey(vallan.getId()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //okok
	}
//
	@Test
	public void update() {
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		Reservation vallan;
		try {
			vallan = new Reservation(sdf.parse("25/05/1983"),4565);
			daoReservation.create(vallan);
			vallan = daoReservation.findByKey(vallan.getId());
			vallan.setDate(sdf.parse("25/05/94"));
			daoReservation.update(vallan);
			assertEquals (sdf.parse("25/05/94"), daoReservation.findByKey(vallan.getId()).getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findAll() {
		assertNotNull(daoReservation.findAll());
	}// ok

	@Test
	public void delete() {
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		Reservation vallan;
		try {
			vallan = new Reservation(sdf.parse("25/05/1983"),5466);
			daoReservation.create(vallan);
			daoReservation.delete(vallan);
			assertNull(daoReservation.findByKey(vallan.getId()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
////	
//
	@Test
	public void deleteByKey() {
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		Reservation vallan;
		try {
			vallan = new Reservation(sdf.parse("15/12/2017"),1215);
			daoReservation.create(vallan);
			daoReservation.deleteByKey(vallan.getId());
			assertNull(daoReservation.findByKey(vallan.getId()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}