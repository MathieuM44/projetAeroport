package ProjetAeroport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ProjetAeroport.model.Aeroport;
import ProjetAeroport.model.CompagnieAerienne;
import ProjetAeroport.model.CompagnieAerienneVol;
import ProjetAeroport.model.Vol;
import ProjetAeroport.util.Context;

class DaoCompagnieAerienneJpaImpl implements DaoCompagnieAerienne {

	@Override
	public void create(CompagnieAerienne obj) {
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
	public CompagnieAerienne findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		CompagnieAerienne r = null;
		r = em.find(CompagnieAerienne.class, key);
		em.close();
		return r;
	}

	@Override
	public CompagnieAerienne update(CompagnieAerienne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		CompagnieAerienne r = new CompagnieAerienne();
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
	public void delete(CompagnieAerienne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			for(CompagnieAerienneVol cav : obj.getCompagnieAerienneVol()) {
				em.remove(cav);
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
			em.remove(em.find(CompagnieAerienne.class , key));		// enleve la personne trouvée par la clé donnée
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
	public List<CompagnieAerienne> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from CompagnieAerienne r");		// soit p.nomAttribut soit p pour tout de la table + select p non obligé si tout
		List<CompagnieAerienne> CompagnieAeriennes = null;
		CompagnieAeriennes = query.getResultList();
		em.close();
		return CompagnieAeriennes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompagnieAerienneVol> findAllCompagnieAerienneVol() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("CA.findAllCompagnieAerienneVol");
		List<CompagnieAerienneVol> cav = query.getResultList();
		em.close();
		return cav;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vol> findAllVol() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("CA.findAllVol");
		List<Vol> vols = query.getResultList();
		em.close();
		return vols;
	}

}
