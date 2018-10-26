package ProjetAeroport.dao;


public class DaoLoginFactory {
	
		private static  DaoLogin daoLogin = null;
		
		private DaoLoginFactory() {
			
		}
		
		public static DaoLogin getInstance() {
			if (daoLogin == null) {
				daoLogin = new DaoLoginJpaImpl();
			}
			return daoLogin;
		}
	}
	
	

