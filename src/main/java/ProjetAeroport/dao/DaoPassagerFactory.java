package ProjetAeroport.dao;



public class DaoPassagerFactory {
	private static DaoPassager DaoPassager = null;

	public static DaoPassager getInstance() {
		if (DaoPassager == null) {
			DaoPassager = new DaoPassagerJpaImpl();
		}
		return DaoPassager;
	}
	

}


