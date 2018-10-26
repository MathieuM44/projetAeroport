package ProjetAeroport.dao;

import java.util.List;

import ProjetAeroport.model.Aeroport;
import ProjetAeroport.model.CompagnieAerienne;
import ProjetAeroport.model.CompagnieAerienneVol;
import ProjetAeroport.model.Escale;
import ProjetAeroport.model.Reservation;
import ProjetAeroport.model.Vol;

public interface DaoVol extends DaoGeneric<Vol, Long> {

	public List<Aeroport> findAllAeroportDepart();
	public List<Aeroport> findAllAeroportArrivee();
	public List<Escale> findAllEscale();
	public List<Reservation> findAllReservation();
	public List<CompagnieAerienneVol> findAllCompagnieAerienneVol();
	public List<CompagnieAerienne> findAllCompagnieAerienne();
	
}
