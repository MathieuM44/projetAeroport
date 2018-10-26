import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjetAeroport.dao.DaoVol;
import ProjetAeroport.dao.DaoVolFactory;
import ProjetAeroport.model.Vol;
import ProjetAeroport.util.Context;

public class DaoVolTest {

	private static DaoVol daoVol;
	
	@BeforeClass
	public static void initDao() {
		daoVol = DaoVolFactory.getInstance();
	}
	
	@AfterClass
	public static void close() {
		Context.destroy();
	}

	@Test
	public void insert() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
	}
	
	@Test
	public void findByKey() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		assertNotNull(daoVol.findByKey(vol.getId()));
	}
	
	@Test
	public void update() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		try {
			vol.setDateArrivee(sdf.parse("16/12/2018"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.update(vol);
		assertNotNull(vol.getDateArrivee());
	}
	
	@Test
	public void findAll() {
		assertNotNull(daoVol.findAll());
	}
	
	@Test
	public void delete() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		daoVol.delete(vol);
		assertNull(daoVol.findByKey(vol.getId()));
	}
	
	@Test
	public void deleteByKey() {
		Vol vol = new Vol();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol.setDateDepart(sdf.parse("15/12/2018"));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.create(vol);
		daoVol.deleteByKey(vol.getId());
		assertNull(daoVol.findByKey(vol.getId()));
	}
}
