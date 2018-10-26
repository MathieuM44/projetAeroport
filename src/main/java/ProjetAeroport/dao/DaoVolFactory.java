package ProjetAeroport.dao;

public class DaoVolFactory {

	private static DaoVol daoVol = null;
	
	private DaoVolFactory() {
	}
	
	public static DaoVol getInstance() {
		if(daoVol == null) {
			daoVol = new DaoVolJpaImpl();
		}
		return daoVol;
	}
}
