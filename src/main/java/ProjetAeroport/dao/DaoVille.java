package ProjetAeroport.dao;

import java.util.List;

import ProjetAeroport.model.Aeroport;
import ProjetAeroport.model.Ville;

public interface DaoVille extends DaoGeneric <Ville,Long>{

	public List<Aeroport> findAllAeroport();
	
}
