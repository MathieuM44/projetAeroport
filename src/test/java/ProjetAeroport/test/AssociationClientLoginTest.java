package ProjetAeroport.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoClient;
import ProjetAeroport.dao.DaoClientFactory;
import ProjetAeroport.dao.DaoLogin;
import ProjetAeroport.dao.DaoLoginFactory;
import ProjetAeroport.model.Client;
import ProjetAeroport.model.ClientPhysique;
import ProjetAeroport.model.Login;
import ProjetAeroport.util.Context;

public class AssociationClientLoginTest {

	private static DaoLogin daoLogin;
	private static DaoClient daoClient;

	@BeforeClass
	public static void init() {

		daoLogin = DaoLoginFactory.getInstance();
		daoClient = DaoClientFactory.getInstance();
	}

	public static void closeJpa() {
		Context.destroy();
	}

	@Test
	public void test() {
		Client cp = new ClientPhysique();
		cp.setNom("creation");
		daoClient.create(cp);
		Login login = new Login();
		login.setLogin("test");
		daoLogin.create(login);
		
		
		
		// ---------------- test création association
		
		cp = daoClient.findByKey(cp.getId());
		
		cp.setLogin(login);
		
		daoClient.update(cp); // -> Création des foreign Key réussi.
		
		
		
		
		// ---------------- test suppression d'objets associés Login - Client
		
		cp = daoClient.findByKey(cp.getId());

		 
		//login = daoLogin.findByKey(login.getId());
		//daoLogin.delete(login); --> test suppression login reussi : pas de suppression des clients
		
		daoClient.delete(cp); // --> test de suppression des clients reussi : pas de suppression des logins
		

		
		
		
		
	
		
		
	}

}
