package ProjetAeroport.dao;

import java.util.List;

import ProjetAeroport.model.CompagnieAerienne;
import ProjetAeroport.model.CompagnieAerienneVol;
import ProjetAeroport.model.Vol;

public interface DaoCompagnieAerienne extends DaoGeneric<CompagnieAerienne, Long> {

	public List<CompagnieAerienneVol> findAllCompagnieAerienneVol();
	public List<Vol> findAllVol();
	
}
