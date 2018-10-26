package ProjetAeroport;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoClient;
import ProjetAeroport.dao.DaoClientFactory;
import ProjetAeroport.dao.DaoReservation;
import ProjetAeroport.dao.DaoReservationFactory;
import ProjetAeroport.model.Client;
import ProjetAeroport.model.ClientPhysique;
import ProjetAeroport.model.Reservation;
import ProjetAeroport.util.Context;

public class TestjointureClientReservation {
	private static DaoReservation daoReservation;
	private static DaoClient daoClient;
	private static Client vallan;
	private static Reservation reserve;

	@BeforeClass
	public static void initDaoClient() {
		daoClient = DaoClientFactory.getInstance();
		daoReservation = DaoReservationFactory.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		try {
			vallan = new ClientPhysique();
			vallan.setNom("init");
			reserve = new Reservation(sdf.parse("15/12/2017"), 123123);
			daoClient.create(vallan);
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

		daoClient = DaoClientFactory.getInstance();
		daoReservation = DaoReservationFactory.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		try {
			vallan = new ClientPhysique();
			vallan.setNom("creation");
			reserve = new Reservation(sdf.parse("15/12/2017"), 87575);
			daoClient.create(vallan);
			daoReservation.create(reserve);
			vallan = daoClient.findByKey(vallan.getId());
			reserve = daoReservation.findByKey(reserve.getId());
			reserve.setClient(vallan);
			daoReservation.update(reserve);
			reserve = daoReservation.findByKey(reserve.getId());
			assertNotNull(daoReservation.findByKey(reserve.getId()));
			daoReservation.delete(reserve);
			assertNull(daoReservation.findByKey(reserve.getId()));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteClient() {

		daoClient = DaoClientFactory.getInstance();
		daoReservation = DaoReservationFactory.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		try {
			vallan = new ClientPhysique();
			vallan.setNom("delete");
			reserve = new Reservation(sdf.parse("15/12/2017"), 199999);
			daoClient.create(vallan);
			daoReservation.create(reserve);
			vallan = daoClient.findByKey(vallan.getId());
			reserve = daoReservation.findByKey(reserve.getId());
			reserve.setClient(vallan);
			daoReservation.update(reserve);
			reserve = daoReservation.findByKey(reserve.getId());
			assertNotNull(daoReservation.findByKey(reserve.getId()));
			daoClient.delete(vallan);
			assertNull(daoClient.findByKey(vallan.getId()));


		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}