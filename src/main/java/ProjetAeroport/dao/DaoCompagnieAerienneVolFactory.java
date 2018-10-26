package ProjetAeroport.dao;

public class DaoCompagnieAerienneVolFactory {

	private static DaoCompagnieAerienneVol daoCompagnieAerienneVol = null;
	
	private DaoCompagnieAerienneVolFactory() {
	}
	
	public static DaoCompagnieAerienneVol getInstance() {
		if(daoCompagnieAerienneVol == null) {
			daoCompagnieAerienneVol = new DaoCompagnieAerienneVolJpaImpl();
		}
		return daoCompagnieAerienneVol;
	}
}
