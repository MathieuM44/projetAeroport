package ProjetAeroport.dao;

import java.util.List;

import ProjetAeroport.model.Aeroport;
import ProjetAeroport.model.Escale;
import ProjetAeroport.model.Ville;
import ProjetAeroport.model.Vol;

public interface DaoAeroport extends DaoGeneric <Aeroport,Long>{

	public List<Escale> findAllEscale();
	public List<Vol> findAllVols();
	public List<Ville> findAllVille();
	
}
