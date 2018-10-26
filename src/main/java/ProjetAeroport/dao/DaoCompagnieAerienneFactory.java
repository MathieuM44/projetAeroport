package ProjetAeroport.dao;

public class DaoCompagnieAerienneFactory {

	private static DaoCompagnieAerienne daoCompagnieAerienne = null;
	
	private DaoCompagnieAerienneFactory() {
	}
	
	public static DaoCompagnieAerienne getInstance() {
		if(daoCompagnieAerienne == null) {
			daoCompagnieAerienne = new DaoCompagnieAerienneJpaImpl();
		}
		return daoCompagnieAerienne;
	}
}
