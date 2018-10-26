package ProjetAeroport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import ProjetAeroport.model.Client;
import ProjetAeroport.model.Reservation;
import ProjetAeroport.util.Context;

public class DaoClientJpaImpl implements DaoClient {

	@Override
	public void create(Client obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Client findByKey(Long Key) {

		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Client a = null;
		a = em.find(Client.class, Key);
		em.close();
		return a;
	}

	@Override
	public Client update(Client obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Client a = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			a = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return a;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			if (obj.getLogin() != null) {
				obj.setLogin(null);
			}
			if (obj.getReservations() != null) {
				for (Reservation reservation : obj.getReservations()) {
					reservation.setClient(null);
				}
			}
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteByKey(Long Key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Client obj = em.find(Client.class, Key);
			if (obj.getLogin() != null) {
				obj.setLogin(null);
			}
			if (obj.getReservations() != null) {
				for (Reservation reservation : obj.getReservations()) {
					reservation.setClient(null);
				}
			}
			em.remove(em.find(Client.class, Key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}
	
		@Override
	    public List<Client> clientAvecReservation() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query  = em.createNamedQuery("Client.clientAvecReservation");
		List<Client> clients = query.getResultList();
		em.close();
		return clients;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		List<Client> Clients = null;
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from client_projet_aeroport");
		Clients = query.getResultList();
		em.close();
		return Clients;
	}

}
