package ProjetAeroport;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoPassager;
import ProjetAeroport.dao.DaoPassagerFactory;
import ProjetAeroport.dao.DaoReservation;
import ProjetAeroport.dao.DaoReservationFactory;
import ProjetAeroport.model.Passager;
import ProjetAeroport.model.Reservation;
import ProjetAeroport.util.Context;

public class TestjointurePassagerReservation {
	private static DaoReservation daoReservation;
	private static DaoPassager daoPassager;
	private static Passager vallan;
	private static Reservation reserve;

	@BeforeClass
	public static void initDaoPassager() {
		daoPassager = DaoPassagerFactory.getInstance();
		daoReservation = DaoReservationFactory.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		try {
			vallan = new Passager("initi", "vallan");
			reserve = new Reservation(sdf.parse("15/12/2017"), 123123);
			daoPassager.create(vallan);
			daoReservation.create(reserve);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void fermeturJpa() {
		Context.destroy();
	}

	@Test
	public void instanceAndCreateObjects() {

		assertNotNull(vallan.getId());
		assertNotNull(reserve.getId());
	}


	@Test
	public void deleteResrvation() {

		daoPassager = DaoPassagerFactory.getInstance();
		daoReservation = DaoReservationFactory.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		try {
			vallan = new Passager("sellaiah", "vallan");
			reserve = new Reservation(sdf.parse("15/12/2017"), 87575);
			daoPassager.create(vallan);
			daoReservation.create(reserve);
			vallan = daoPassager.findByKey(vallan.getId());
			List<Reservation> reservations = new ArrayList<>();
			vallan.setReservations(reservations);
			daoPassager.update(vallan);
			reserve = daoReservation.findByKey(reserve.getId());
			daoReservation.delete(reserve);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deletePassager() {
		daoPassager = DaoPassagerFactory.getInstance();
		daoReservation = DaoReservationFactory.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		try {
			vallan = new Passager("deletepas", "vallan");
			reserve = new Reservation(sdf.parse("15/12/2017"), 00111);
			daoPassager.create(vallan);
			daoReservation.create(reserve);
			vallan = daoPassager.findByKey(vallan.getId());
			List<Reservation> reservations = new ArrayList<>();
			vallan.setReservations(reservations);
			daoPassager.update(vallan);
			vallan = daoPassager.findByKey(vallan.getId());
			reserve = daoReservation.findByKey(reserve.getId());
			daoPassager.delete(vallan);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


}