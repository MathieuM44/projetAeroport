package ProjetAeroport.dao;

import java.util.List;

import ProjetAeroport.model.Client;

public interface DaoClient extends DaoGeneric<Client, Long> {
	public List<Client> clientAvecReservation();
}
