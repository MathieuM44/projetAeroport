package ProjetAeroport.dao;


public class DaoClientFactory {
	
		private static  DaoClient daoClient = null;
		
		private DaoClientFactory() {
			
		}
		
		public static DaoClient getInstance() {
			if (daoClient == null) {
				daoClient = new DaoClientJpaImpl();
			}
			return daoClient;
		}
	}
	
	

