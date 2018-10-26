package ProjetAeroport.dao;



public class DaoReservationFactory {
	private static DaoReservation DaoReservation = null;

	public static DaoReservation getInstance() {
		if (DaoReservation == null) {
			DaoReservation = new DaoReservationJpaImpl();
		}
		return DaoReservation;
	}
	

}


