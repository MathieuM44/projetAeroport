package ProjetAeroport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ProjetAeroport.model.Aeroport;
import ProjetAeroport.model.CompagnieAerienne;
import ProjetAeroport.model.CompagnieAerienneVol;
import ProjetAeroport.model.Escale;
import ProjetAeroport.model.Reservation;
import ProjetAeroport.model.Vol;
import ProjetAeroport.util.Context;

class DaoVolJpaImpl implements DaoVol {

	@Override
	public void create(Vol obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		// crée connexion, ouvre la factory puis crée l'entité
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {		// vérifie transaction ouverte et commit passé
				tx.rollback();						// revient avant le commit
			}
		} finally {
			if(em != null && em.isOpen()) {			// vérifie entité créée et connexion ouverte
				em.close();							// ferme la connexion
			}
		}	
	}

	@Override
	public Vol findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Vol r = null;
		r = em.find(Vol.class, key);
		em.close();
		return r;
	}

	@Override
	public Vol update(Vol obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		Vol r = new Vol();
		try {
			tx = em.getTransaction();
			tx.begin();
			r = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {		
				tx.rollback();						
			}
		} finally {
			if(em != null && em.isOpen()) {			
				em.close();							
			}
		}
		return r;
	}

	@Override
	public void delete(Vol obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			for(CompagnieAerienneVol cav : obj.getCompagnieAerienneVol()) {
				em.remove(cav);
			}
			for(Escale e : obj.getEscale()) {
				em.remove(e);
			}
			em.remove(obj);				// a besoin d'un objet rattaché à la base
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {		
				tx.rollback();						
			}
		} finally {
			if(em != null && em.isOpen()) {			
				em.close();							
			}
		}
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Vol.class , key));		// enleve la personne trouvée par la clé donnée
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {		
				tx.rollback();						
			}
		} finally {
			if(em != null && em.isOpen()) {			
				em.close();							
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vol> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Vol r");		// soit p.nomAttribut soit p pour tout de la table + select p non obligé si tout
		List<Vol> Vols = null;
		Vols = query.getResultList();
		em.close();
		return Vols;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aeroport> findAllAeroportDepart() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllAeroportDepart");
		List<Aeroport> aeroportsDepart = query.getResultList();
		em.close();
		return aeroportsDepart;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aeroport> findAllAeroportArrivee() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllAeroportArrivee");
		List<Aeroport> aeroportsArrivee = query.getResultList();
		em.close();
		return aeroportsArrivee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Escale> findAllEscale() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllEscale");
		List<Escale> escale = query.getResultList();
		em.close();
		return escale;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findAllReservation() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllReservation");
		List<Reservation> resa = query.getResultList();
		em.close();
		return resa;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompagnieAerienneVol> findAllCompagnieAerienneVol() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllCompagnieAerienneVol");
		List<CompagnieAerienneVol> cav = query.getResultList();
		em.close();
		return cav;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompagnieAerienne> findAllCompagnieAerienne() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllCompagnieAerienne");
		List<CompagnieAerienne> ca = query.getResultList();
		em.close();
		return ca;
	}

}
